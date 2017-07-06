package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 29/06/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/clone-graph
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        final UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        dfs(node, clone, new HashSet<>(), new HashMap<>());

        return clone;
    }

    private static void dfs(UndirectedGraphNode node, UndirectedGraphNode clone, Set<Integer> marked, Map<Integer, UndirectedGraphNode> map) {
        if (node == null) {
            return;
        }

        marked.add(node.label);
        map.put(clone.label, clone);

        for (UndirectedGraphNode n : node.neighbors) {
            if (!marked.contains(n.label)) {
                final UndirectedGraphNode cloneN = new UndirectedGraphNode(n.label);
                clone.neighbors.add(cloneN);
                dfs(n, cloneN, marked, map);
            } else {
                clone.neighbors.add(map.get(n.label));
            }
        }
    }

    private static class UndirectedGraphNode {
        private int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }
}
