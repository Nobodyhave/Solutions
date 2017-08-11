package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 14/07/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/the-skyline-problem
 */
public class SkyLineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        final List<int[]> result = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return result;
        }

        final Building[] B = new Building[buildings.length];
        for (int i = 0; i < buildings.length; i++) {
            B[i] = new Building(i, buildings[i][0], buildings[i][1], buildings[i][2]);
        }

        final List<Building> uB = mergeOverlaps(B);

        final Map<Integer, Building> allB = new HashMap<>();
        for (int i = 0; i < uB.size(); i++) {
            allB.put(uB.get(i).id, uB.get(i));
        }
        final TreeSet<Building> currentB = new TreeSet<>(Comparator.comparingInt(b -> b.height));

        final List<Event> events = new ArrayList<>();
        for (int i = 0; i < uB.size(); i++) {
            events.add(new Event(uB.get(i).id, uB.get(i).left, true));
            events.add(new Event(uB.get(i).id, uB.get(i).right, false));
        }

        events.sort(Comparator.comparingInt(b -> b.x));

        for (int i = 0; i < events.size(); i++) {
            Event event = events.get(i);
            Building eventB = allB.get(event.id);
            if (event.start) {
                if (currentB.isEmpty()) {
                    int[] r = new int[]{event.x, eventB.height};
                    if (result.isEmpty() || result.get(result.size() - 1)[0] != r[0]) {
                        result.add(r);
                    } else {
                        result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], r[1]);
                    }
                } else if (eventB.height > currentB.last().height) {
                    int[] r = new int[]{event.x, eventB.height};
                    if (result.isEmpty() || result.get(result.size() - 1)[0] != r[0]) {
                        result.add(r);
                    } else {
                        result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], r[1]);
                    }
                }
                currentB.add(eventB);
            } else {
                currentB.remove(eventB);
                if (currentB.isEmpty()) {
                    int[] r = new int[]{event.x, 0};
                    if (result.isEmpty() || result.get(result.size() - 1)[0] != r[0]) {
                        result.add(r);
                    } else {
                        result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], r[1]);
                    }
                } else if (eventB.height > currentB.last().height) {
                    int[] r = new int[]{event.x, currentB.last().height};
                    if (result.isEmpty() || result.get(result.size() - 1)[0] != r[0]) {
                        result.add(r);
                    } else {
                        result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], r[1]);
                    }
                }
            }
        }
        result.get(result.size() - 1)[1] = 0;

        return result;
    }

    private static List<Building> mergeOverlaps(Building[] buildings) {
        final Stack<Building> stack = new Stack<>();

        for (int i = 0; i < buildings.length; i++) {
            if (stack.isEmpty() || stack.peek().height != buildings[i].height || stack.peek().right < buildings[i].left) {
                stack.push(buildings[i]);
            } else if (stack.peek().height == buildings[i].height && stack.peek().right >= buildings[i].left) {
                stack.peek().right = Math.max(buildings[i].right, stack.peek().right);
            }
        }

        return new ArrayList<>(stack);
    }

    private static class Event {
        private int id;
        private int x;
        private boolean start;

        Event(int id, int x, boolean start) {
            this.id = id;
            this.x = x;
            this.start = start;
        }
    }

    private static class Building {
        int id;
        int left;
        int right;
        int height;

        Building(int id, int left, int right, int height) {
            this.id = id;
            this.left = left;
            this.right = right;
            this.height = height;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Building building = (Building) o;

            return id == building.id;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }
}
