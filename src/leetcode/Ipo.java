package leetcode;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Created by Aleksandr on 26/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/ipo
 */
public class Ipo {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (k == 0 || profits == null || profits.length == 0 || capital == null || capital.length == 0 || profits.length != capital.length) {
            return 0;
        }

        final TreeMap<Integer, PriorityQueue<Integer>> capitalToProfit = new TreeMap<>();
        for (int i = 0; i < capital.length; i++) {
            capitalToProfit.computeIfAbsent(capital[i], key -> new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1)));
            capitalToProfit.get(capital[i]).add(profits[i]);
        }

        int minCapital = 0, maxCapital = w;
        final PriorityQueue<Project> projects = new PriorityQueue<>();

        while (k > 0) {
            if (minCapital <= maxCapital) {
                Map<Integer, PriorityQueue<Integer>> map = capitalToProfit.subMap(minCapital, true, maxCapital, true);
                minCapital = maxCapital + 1;
                for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
                    projects.add(new Project(entry.getKey(), entry.getValue().poll()));
                }
            }

            if (projects.isEmpty()) {
                break;
            }
            final Project project = projects.poll();
            w += project.profit;
            if(!capitalToProfit.get(project.capital).isEmpty()) {
                projects.add(new Project(project.capital, capitalToProfit.get(project.capital).poll()));
            }
            maxCapital = Math.max(maxCapital, w);
            k--;
        }

        return w;
    }

    private static class Project implements Comparable<Project> {
        private int capital;
        private int profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        @Override
        public int compareTo(Project o) {
            return Integer.compare(o.profit, profit);
        }
    }
}
