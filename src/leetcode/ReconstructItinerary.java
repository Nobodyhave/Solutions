package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 22/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/reconstruct-itinerary
 */
public class ReconstructItinerary {
    List<String> findItinerary(String[][] tickets) {
        final Map<String, PriorityQueue<String>> targets = new HashMap<>();

        for (String[] ticket : tickets) {
            targets.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }

        final List<String> route = new LinkedList<>();
        visit("JFK", targets, route);

        return route;
    }

    private void visit(String airport, Map<String, PriorityQueue<String>> targets, List<String> route) {
        while (targets.containsKey(airport) && !targets.get(airport).isEmpty()) {
            visit(targets.get(airport).poll(), targets, route);
        }
        route.add(0, airport);
    }
}
