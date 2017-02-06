package hackerrank.data_structures.balanced_trees;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Aleksandr on 01/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/array-and-simple-queries
 */
public class ArrayAndSimpleQueries {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));
        final int N = in.nextInt();
        final int M = in.nextInt();

        final ImplicitTreap<Integer> treap = new ImplicitTreap<Integer>(new Delegate());
        for (int i = 0; i < N; i++) {
            treap.add(in.nextInt());
        }

        for (int i = 0; i < M; i++) {
            int op = in.nextInt();

            if (op == 1) {
                treap.moveToFront(in.nextInt() - 1, in.nextInt());
            } else {
                treap.moveToBack(in.nextInt() - 1, in.nextInt());
            }
        }
        final List<Integer> inOrder = treap.inOrderTraversal();

        System.out.println(Math.abs(inOrder.get(0) - inOrder.get(N - 1)));
        inOrder.forEach(i -> System.out.print(i + " "));
    }

    private static class Delegate extends ImplicitTreap.Delegate<Integer> {
        @Override
        public void updateStatistics(ImplicitTreap.TreapNode<Integer> root) {
            int size = (root.getLeft() == null ? 0 : root.getLeft().getSize()) + (root.getRight() == null ? 0 : root.getRight().getSize()) + 1;

            root.updateSize(size);
        }

        @Override
        public void updateData(ImplicitTreap.TreapNode<Integer> root) {
            // Don't needed
        }
    }

    private static class ImplicitTreap<E> {
        private static final Random RANDOM = new Random();

        private TreapNode<E> root;
        private final Delegate<E> delegate;

        public ImplicitTreap(Delegate<E> delegate) {
            this.delegate = delegate;
        }

        private static <E> void inOrderTraversal(TreapNode<E> root, List<E> result) {
            if (root == null) {
                return;
            }

            if (root.left != null) {
                inOrderTraversal(root.left, result);
            }
            result.add(root.element);
            if (root.right != null) {
                inOrderTraversal(root.right, result);
            }
        }

        private static <E> void pushDelta(TreapNode<E> node) {
            // Not needed
        }

        // Keys of left tree should be less then keys of right tree
        private static <E> TreapNode<E> merge(Delegate<E> delegate, TreapNode<E> L, TreapNode<E> R) {
            if (L == null) {
                return R;
            }
            if (R == null) {
                return L;
            }

            TreapNode<E> answer;
            if (L.priority > R.priority) {
                delegate.updateData(L);
                pushDelta(L);

                final TreapNode<E> newR = merge(delegate, L.right, R);
                answer = new TreapNode<>(delegate, L.element, L.priority, L.left, newR);
            } else {
                delegate.updateData(R);
                pushDelta(R);

                final TreapNode<E> newL = merge(delegate, L, R.left);
                answer = new TreapNode<>(delegate, R.element, R.priority, newL, R.right);
            }

            delegate.updateStatistics(answer);

            return answer;
        }

        private static <E> SplitResult<E> split(Delegate<E> delegate, TreapNode<E> root, int index) {
            delegate.updateData(root);
            pushDelta(root);

            SplitResult<E> splitResult;
            TreapNode<E> L, R, newTree = null;
            final int curIndex = ((root.left == null) ? 0 : root.left.size) + 1;
            if (curIndex <= index) {
                if (root.right == null) {
                    R = null;
                } else {
                    splitResult = split(delegate, root.right, index - curIndex);
                    newTree = splitResult.left;
                    R = splitResult.right;
                }
                L = new TreapNode<>(delegate, root.element, root.priority, root.left, newTree);
                delegate.updateStatistics(L);
                splitResult = new SplitResult<>(L, R);
            } else {
                if (root.left == null) {
                    L = null;
                } else {
                    splitResult = split(delegate, root.left, index);
                    L = splitResult.left;
                    newTree = splitResult.right;
                }
                R = new TreapNode<>(delegate, root.element, root.priority, newTree, root.right);
                delegate.updateStatistics(R);
                splitResult = new SplitResult<>(L, R);
            }

            return splitResult;
        }

        public E query(int index) {
            if (root == null || root.size == 0 || index < 0 || index >= root.size) {
                throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
            }

            return query(delegate, root, index).element;
        }

        private static <E> TreapNode<E> query(Delegate<E> delegate, TreapNode<E> root, int index) {
            final SplitResult<E> resultFirst = split(delegate, root, index);
            final SplitResult<E> resultSecond = split(delegate, resultFirst.right, 1);

            return resultSecond.left;
        }

        public void moveToFront(int left, int right) {
            SplitResult<E> splitResult1 = split(delegate, root, left);
            SplitResult<E> splitResult2 = split(delegate, splitResult1.right, right - left);

            root = merge(delegate, merge(delegate, splitResult2.left, splitResult1.left), splitResult2.right);
        }

        public void moveToBack(int left, int right) {
            SplitResult<E> splitResult1 = split(delegate, root, left);
            SplitResult<E> splitResult2 = split(delegate, splitResult1.right, right - left);

            root = merge(delegate, merge(delegate, splitResult1.left, splitResult2.right), splitResult2.left);
        }

        public void add(E element, int index, int priority) {
            if (root == null) {
                root = new TreapNode<>(delegate, element, priority, null, null);
            } else {
                final SplitResult<E> result = split(delegate, root, index);
                final TreapNode<E> m = new TreapNode<>(delegate, element, priority, null, null);
                root = merge(delegate, merge(delegate, result.left, m), result.right);
            }
        }

        public void add(E element) {
            add(element, root != null ? root.size : 0, RANDOM.nextInt());
        }

        private List<E> inOrderTraversal() {
            final List<E> result = new ArrayList<>();
            inOrderTraversal(root, result);

            return result;
        }

        public static class TreapNode<E> {
            private E element;
            private int priority;
            private TreapNode<E> left;
            private TreapNode<E> right;
            private int size;

            public TreapNode(Delegate<E> delegate, E element, int priority, TreapNode<E> left, TreapNode<E> right) {
                this.element = element;
                this.priority = priority;
                this.left = left;
                this.right = right;
                delegate.updateStatistics(this);
            }

            public TreapNode<E> getLeft() {
                return left;
            }

            public TreapNode<E> getRight() {
                return right;
            }

            public int getSize() {
                return size;
            }

            public void updateSize(int size) {
                this.size = size;
            }
        }

        private static class SplitResult<E> {
            private TreapNode<E> left;
            private TreapNode<E> right;

            public SplitResult(TreapNode<E> left, TreapNode<E> right) {
                this.left = left;
                this.right = right;
            }
        }

        public static abstract class Delegate<E> {
            public abstract void updateStatistics(TreapNode<E> root);

            public abstract void updateData(TreapNode<E> root);
        }
    }
}
