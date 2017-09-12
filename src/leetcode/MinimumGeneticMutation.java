package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by Aleksandr on 12/09/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/minimum-genetic-mutation
 */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        if (start == null || end == null || bank == null) {
            return 0;
        }

        final Set<String> bankSet = new HashSet<>();
        bankSet.addAll(Arrays.asList(bank));

        final Set<String> marked = new HashSet<>();
        final PriorityQueue<Mutation> pq = new PriorityQueue<>();
        pq.add(new Mutation(start, 0));
        marked.add(start);
        while (!pq.isEmpty()) {
            final Mutation m = pq.poll();
            if (end.equals(m.gene)) {
                return m.count;
            }

            final char[] str = m.gene.toCharArray();
            String newGene;
            for (int i = 0; i < m.gene.length(); i++) {
                char old = str[i];

                str[i] = 'A';
                newGene = new String(str);
                if (!marked.contains(newGene) && bankSet.contains(newGene)) {
                    marked.add(newGene);
                    pq.add(new Mutation(newGene, m.count + 1));
                }
                str[i] = 'C';
                newGene = new String(str);
                if (!marked.contains(newGene) && bankSet.contains(newGene)) {
                    marked.add(newGene);
                    pq.add(new Mutation(newGene, m.count + 1));
                }
                str[i] = 'G';
                newGene = new String(str);
                if (!marked.contains(newGene) && bankSet.contains(newGene)) {
                    marked.add(newGene);
                    pq.add(new Mutation(newGene, m.count + 1));
                }
                str[i] = 'T';
                newGene = new String(str);
                if (!marked.contains(newGene) && bankSet.contains(newGene)) {
                    marked.add(newGene);
                    pq.add(new Mutation(newGene, m.count + 1));
                }

                str[i] = old;
            }
        }

        return -1;
    }

    private static class Mutation implements Comparable<Mutation> {
        private String gene;
        private int count;

        Mutation(String gene, int count) {
            this.gene = gene;
            this.count = count;
        }

        @Override
        public int compareTo(Mutation o) {
            return Integer.compare(count, o.count);
        }
    }
}
