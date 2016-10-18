package hackerrank.algorithms.greedy;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Aleksandr on 18/10/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/largest-permutation
 */
public class LargestPermutation {

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final int N = in.nextInt();
        int K = in.nextInt();

        final int[] nums = new int[N];
        final TreeSet<Entry> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            final int num = in.nextInt();
            nums[i] = num;
            set.add(new Entry(i, num));
        }

        for (int i = 0; i < Math.min(N - 1, K); i++) {
            final Entry entry = set.pollLast();

            if (entry.value > nums[i]) {
                final Entry newEntry = new Entry(entry.index, nums[i]);
                set.remove(new Entry(i, nums[i]));
                set.add(newEntry);
                nums[entry.index] = nums[i];
                nums[i] = entry.value;
            } else if (entry.value == nums[i]) {
                K++;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static class Entry implements Comparable<Entry> {
        private int index;
        private int value;

        public Entry(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Entry o) {
            int result = Integer.compare(value, o.value);

            if (result == 0) {
                result = Integer.compare(index, o.index);
            }

            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Entry entry = (Entry) o;

            return index == entry.index && value == entry.value;

        }

        @Override
        public int hashCode() {
            int result = index;
            result = 31 * result + value;
            return result;
        }
    }
}
