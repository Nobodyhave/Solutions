package interviewbit;

import java.util.*;

/**
 * Created by Aleksandr on 24/11/2017.
 * Project Solutions
 */
public class GetModeArrayUpdates {
    public static void main(String[] args) {
        final List<Integer> a = Arrays.asList(2, 2, 2, 2, 2);
        ArrayList<List<Integer>> q = new ArrayList<>();
        q.add(Arrays.asList(4, 1));
        q.add(Arrays.asList(3, 1));
        q.add(Arrays.asList(3, 1));
        q.add(Arrays.asList(2, 1));
        q.add(Arrays.asList(4, 2));

        new GetModeArrayUpdates().getMode(a, q);
    }

    public ArrayList<Integer> getMode(List<Integer> a, ArrayList<List<Integer>> b) {
        final Map<Integer, Integer> numToCount = new HashMap<>();
        final TreeSet<Mode> modes = new TreeSet<>();

        for (Integer num : a) {
            numToCount.put(num, numToCount.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : numToCount.entrySet()) {
            modes.add(new Mode(entry.getKey(), entry.getValue()));
        }

        final ArrayList<Integer> result = new ArrayList<>();
        for (List<Integer> q : b) {
            final int i = q.get(0) - 1;
            final int j = q.get(1);

            int num = a.get(i);
            int count1 = numToCount.get(num);
            int count2 = numToCount.getOrDefault(j, 0);

            if (num != j) {
                modes.remove(new Mode(num, count1));
                modes.remove(new Mode(j, count2));
                modes.add(new Mode(num, count1 - 1));
                modes.add(new Mode(j, count2 + 1));

                numToCount.put(num, count1 - 1);
                numToCount.put(j, count2 + 1);
            }

            a.set(i, j);
            result.add(modes.first().num);
        }

        return result;
    }

    private static class Mode implements Comparable<Mode> {
        private int num;
        private int count;

        Mode(int num, int count) {
            this.num = num;
            this.count = count;
        }

        @Override
        public int compareTo(Mode o) {
            int result = Integer.compare(o.count, count);

            if (result == 0) {
                result = Integer.compare(num, o.num);
            }

            return result;
        }
    }
}
