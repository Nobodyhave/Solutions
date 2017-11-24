package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 15/11/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/accounts-merge
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) {
            return result;
        }

        final Map<String, Integer> emailToIndex = new HashMap<>();
        final Map<String, String> emailToName = new HashMap<>();
        final Map<Integer, String> indexToEmail = new HashMap<>();
        int index = 0;
        for (List<String> account : accounts) {
            final String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                final String email = account.get(i);
                boolean added = emailToIndex.putIfAbsent(email, index) == null;
                if (added) {
                    emailToName.put(email, name);
                    indexToEmail.put(index, email);
                    index++;
                }
            }
        }

        final Graph graph = new Graph(indexToEmail.size());
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                for (int j = i + 1; j < account.size(); j++) {
                    graph.addEdge(emailToIndex.get(account.get(i)), emailToIndex.get(account.get(j)));
                }
            }
        }

        result = new BreadthFirstSearch(graph, indexToEmail).accounts;
        for (List<String> account : result) {
            Collections.sort(account);
            account.add(0, emailToName.get(account.get(0)));
        }

        return result;
    }

    private static class BreadthFirstSearch {
        private boolean[] marked;
        private final List<List<String>> accounts = new ArrayList<>();

        public BreadthFirstSearch(Graph G, Map<Integer, String> indexToEmail) {
            marked = new boolean[G.size()];

            for (int i = 0; i < G.size(); i++) {
                if (!marked[i]) {
                    final List<String> emails = new ArrayList<>();
                    bfs(G, indexToEmail, emails, i);
                    accounts.add(emails);
                }
            }
        }

        private void bfs(Graph G, Map<Integer, String> indexToEmail, List<String> emails, int s) {
            Queue<Integer> q = new LinkedList<>();
            marked[s] = true;
            q.add(s);

            while (!q.isEmpty()) {
                int v = q.poll();
                emails.add(indexToEmail.get(v));
                G.adj(v).stream().filter(w -> !marked[w]).forEach(w -> {
                    marked[w] = true;
                    q.add(w);
                });
            }
        }
    }

    private static class DepthFirstSearch {
        private boolean[] marked;
        private final List<List<String>> accounts = new ArrayList<>();

        DepthFirstSearch(Graph G, Map<Integer, String> indexToEmail) {
            marked = new boolean[G.size()];
            for (int i = 0; i < G.size(); i++) {
                if (!marked[i]) {
                    final List<String> emails = new ArrayList<>();
                    dfs(G, indexToEmail, emails, i);
                    accounts.add(emails);
                }
            }
        }

        private void dfs(Graph G, Map<Integer, String> indexToEmail, List<String> emails, int v) {
            marked[v] = true;
            emails.add(indexToEmail.get(v));
            G.adj(v).stream().filter(w -> !marked[w]).forEach(w -> dfs(G, indexToEmail, emails, w));
        }
    }

    private static class Graph {
        private final int V;
        private List<Integer>[] adj;

        public Graph(int V) {
            this.V = V;
            //noinspection unchecked
            adj = (List<Integer>[]) new ArrayList[V];
            for (int v = 0; v < V; v++) {
                adj[v] = new ArrayList<>();
            }
        }

        public int size() {
            return V;
        }

        public void addEdge(int v, int w) {
            adj[v].add(w);
            adj[w].add(v);
        }

        public List<Integer> adj(int v) {
            return adj[v];
        }
    }
}
