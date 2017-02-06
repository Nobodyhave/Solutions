package hackerrank.data_structures.balanced_trees;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Aleksandr on 01/02/2017.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/median
 */
public class MedianUpdates {
    public static void main(String[] args) throws FileNotFoundException {
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int N = in.nextInt();
        final Treap<Integer> treap = new Treap<>(new Delegate());
        for (int i = 0; i < N; i++) {
            String op = in.next();
            final int key = in.nextInt();

            if ("a".equals(op)) {
                treap.add(key);

                double median = calculateMedian(treap);

                if (Double.compare(median - (int) median, 0) == 0) {
                    System.out.format("%d\n", (int) median);
                } else {
                    System.out.format("%.1f\n", median);
                }

            } else {
                if (treap.size() == 0 || !treap.contains(key)) {
                    System.out.println("Wrong!");
                } else if (treap.size() == 1) {
                    treap.remove(key);
                    System.out.println("Wrong!");
                } else {
                    treap.remove(key);

                    double median = calculateMedian(treap);

                    if (Double.compare(median - (int) median, 0) == 0) {
                        System.out.format("%d\n", (int) median);
                    } else {
                        System.out.format("%.1f\n", median);
                    }
                }
            }
        }
    }

    private static double calculateMedian(Treap<Integer> treap) {
        double median;
        if (treap.size() % 2 == 0) {
            double e1 = treap.getKthElement(treap.size() / 2 - 1);
            double e2 = treap.getKthElement(treap.size() / 2);

            median = (e1 + e2) / 2.0;
        } else {
            median = treap.getKthElement(treap.size() / 2);
        }

        return median;
    }

    private static class Delegate extends Treap.Delegate<Integer> {
        @Override
        public void updateStatistics(Treap.TreapNode<Integer> root) {
            int size = (root.getLeft() == null ? 0 : root.getLeft().getSize()) + (root.getRight() == null ? 0 : root.getRight().getSize()) + 1;

            root.updateSize(size);
        }

        @Override
        public void updateKey(Treap.TreapNode<Integer> root) {
            // Do nothing
        }
    }

    private static class Treap<K extends Comparable<K>> {
        private static final Random RANDOM = new Random();

        private TreapNode<K> root;
        private final Delegate<K> delegate;

        public Treap(Delegate<K> delegate) {
            this.delegate = delegate;
        }

        private static <K extends Comparable<K>> TreapNode<K> query(TreapNode<K> root, K key) {
            if (root == null || root.key.compareTo(key) == 0) {
                return root;
            } else if (key.compareTo(root.key) < 0) {
                return query(root.left, key);
            } else {
                return query(root.right, key);
            }
        }

        // Keys of left tree should be less then keys of right tree
        private static <K extends Comparable<K>> TreapNode<K> merge(Delegate<K> delegate, TreapNode<K> L, TreapNode<K> R) {
            if (L == null) {
                return R;
            }
            if (R == null) {
                return L;
            }

            TreapNode<K> answer;
            if (L.priority > R.priority) {
                delegate.updateKey(L);
                if (L.key.compareTo(R.key) != 0) {
                    final TreapNode<K> newR = merge(delegate, L.right, R);
                    answer = new TreapNode<>(delegate, L.key, L.priority, L.left, newR);
                } else {
                    final TreapNode<K> newR = null;
                    final TreapNode<K> newL = new TreapNode<>(delegate, R.key, R.priority, merge(delegate, L.left, R.left), merge(delegate, L.right, R.right));
                    answer = new TreapNode<>(delegate, L.key, L.priority, newL, newR);
                }
            } else {
                delegate.updateKey(R);
                if (L.key.compareTo(R.key) != 0) {
                    final TreapNode<K> newL = merge(delegate, L, R.left);
                    answer = new TreapNode<>(delegate, R.key, R.priority, newL, R.right);
                } else {
                    final TreapNode<K> newR = null;
                    final TreapNode<K> newL = new TreapNode<>(delegate, L.key, L.priority, merge(delegate, L.left, R.left), merge(delegate, L.right, R.right));
                    answer = new TreapNode<>(delegate, R.key, R.priority, newL, newR);
                }
            }

            delegate.updateStatistics(answer);

            return answer;
        }

        private static <K extends Comparable<K>> SplitResult<K> split(Delegate<K> delegate, TreapNode<K> root, K key, boolean remove) {
            delegate.updateKey(root);

            SplitResult<K> splitResult;
            TreapNode<K> L, R, newTree = null;

            if (root == null) {
                return new SplitResult<>(null, null);
            }

            if (root.key.compareTo(key) == 0 && remove) {
                splitResult = new SplitResult<>(root.left, null);
            } else if (root.key.compareTo(key) <= 0) {
                if (root.right == null) {
                    R = null;
                } else {
                    splitResult = split(delegate, root.right, key, remove);
                    newTree = splitResult.left;
                    R = splitResult.right;
                }
                L = new TreapNode<>(delegate, root.key, root.priority, root.left, newTree);
                delegate.updateStatistics(L);
                splitResult = new SplitResult<>(L, R);
            } else {
                if (root.left == null) {
                    L = null;
                } else {
                    splitResult = split(delegate, root.left, key, remove);
                    L = splitResult.left;
                    newTree = splitResult.right;
                }
                R = new TreapNode<>(delegate, root.key, root.priority, newTree, root.right);
                delegate.updateStatistics(R);
                splitResult = new SplitResult<>(L, R);
            }

            return splitResult;
        }

        public void add(K key, int priority) {
            if (root == null) {
                root = new TreapNode<>(delegate, key, priority, null, null);
            } else {
                final SplitResult<K> result = split(delegate, root, key, false);
                final TreapNode<K> m = new TreapNode<>(delegate, key, priority, null, null);

                root = merge(delegate, merge(delegate, result.left, m), result.right);
            }
        }

        public void add(K key) {
            add(key, RANDOM.nextInt());
        }

        public void remove(K key) {
            if (root == null || root.size == 0) {
                throw new IllegalStateException("Unable to remove " + key + ". Treap is empty");
            }

            if (contains(key)) {
                final SplitResult<K> resultFirst = split(delegate, this.root, key, false);
                final SplitResult<K> resultSecond = split(delegate, resultFirst.left, key, true);
                root = merge(delegate, resultSecond.left, resultFirst.right);
            }
        }

        public boolean contains(K key) {
            return query(root, key) != null;
        }

        public int size() {
            return root != null ? root.size : 0;
        }

        public K getKthElement(int k) {
            TreapNode<K> node = root;
            while (node != null) {
                int sizeLeft = (node.left != null ? node.left.size : 0);

                if (sizeLeft == k) {
                    return node.key;
                }

                node = sizeLeft > k ? node.left : node.right;
                if (sizeLeft < k) {
                    k -= sizeLeft + 1;
                }
            }

            throw new IndexOutOfBoundsException(k + " exceeds treap bounds");
        }

        public static class TreapNode<K> {
            private K key;
            private int priority;
            private TreapNode<K> left;
            private TreapNode<K> right;
            private int size;

            public TreapNode(Delegate<K> delegate, K key, int priority, TreapNode<K> left, TreapNode<K> right) {
                this.key = key;
                this.priority = priority;
                this.left = left;
                this.right = right;
                delegate.updateStatistics(this);
            }

            public TreapNode<K> getLeft() {
                return left;
            }

            public TreapNode<K> getRight() {
                return right;
            }

            public int getSize() {
                return size;
            }

            public void updateSize(int size) {
                this.size = size;
            }
        }

        private static class SplitResult<K extends Comparable<K>> {
            private TreapNode<K> left;
            private TreapNode<K> right;

            public SplitResult(TreapNode<K> left, TreapNode<K> right) {
                this.left = left;
                this.right = right;
            }
        }

        public static abstract class Delegate<K> {
            public abstract void updateStatistics(TreapNode<K> root);

            public abstract void updateKey(TreapNode<K> root);
        }
    }
}
