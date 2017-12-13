package codechef;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Aleksandr on 07/12/2017.
 * Project Solutions
 * <p>
 * https://www.codechef.com/DEC17/problems/DSANTAP
 */
public class SantaDeliveringProblem {
    /*private static final Map<Integer, List<House>> houseMapL = new HashMap<>();
    private static final Map<Integer, List<House>> houseMapK = new HashMap<>();
    private static Map<Integer, House> houses;*/
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        //generateTest();
        //final Scanner in = new Scanner(System.in);
        final Scanner in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"));

        final int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            final int N = in.nextInt();
            final int G = in.nextInt();
            final int B = in.nextInt();
            final int X = in.nextInt();
            final int Y = in.nextInt();

            final int[] presents = new int[G];
            for (int i = 0; i < G; i++) {
                presents[i] = in.nextInt();
            }

            /*houses = new HashMap<>();
            houses.put(0, new House(0, X, Y, -1, -1));
            houseMapL.clear();
            houseMapK.clear();
            for (int i = 0; i < N; i++) {
                final House house = new House(i + 1, in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt());
                houses.put(i + 1, house);
                if (house.k != house.l) {
                    houseMapL.computeIfAbsent(house.l, key -> new ArrayList<>());
                    houseMapL.get(house.l).add(house);
                    houseMapK.computeIfAbsent(house.k, key -> new ArrayList<>());
                    houseMapK.get(house.k).add(house);
                }
            }*/
            sb = new StringBuilder();
            /*final int idx = new Random().nextInt(N);
            House curHouse = houses.get(idx);
            takePresentForHouse(curHouse);
            moveTo(curHouse);
            do {
                House nextHouse;
                dropPresent(curHouse);
                if (houseMapL.isEmpty()) {
                    break;
                } else if (houseMapL.get(curHouse.k) == null) {
                    nextHouse = visitSanta(curHouse);
                } else {
                    if (houseMapK.get(curHouse.k) != null) {
                        takePresent(curHouse);
                        nextHouse = getNextHouse(curHouse);
                        moveTo(nextHouse);
                    } else {
                        nextHouse = visitSanta(curHouse);
                    }
                }
                curHouse = nextHouse;
            } while (!houseMapL.isEmpty());
            moveTo(houses.get(0));
            sb.append(0);*/
            for (int i = 0; i < N; i++) {
                final int x = in.nextInt();
                final int y = in.nextInt();
                final int k = in.nextInt();
                final int l = in.nextInt();
                sb.append(2).append(" ").append(l).append("\n");
                sb.append(1).append(" ").append(i + 1).append("\n");
                sb.append(3).append(" ").append(l).append("\n");
                sb.append(2).append(" ").append(k).append("\n");
                sb.append(1).append(" ").append(0).append("\n");
                sb.append(3).append(" ").append(k).append("\n");
            }
            sb.append(0);

            System.out.println(sb);
        }
    }

    /*private static House visitSanta(House house) {
        moveTo(houses.get(0));
        dropCurrentPresent(house);
        House nextHouse = getNextHouse(houses.get(0));
        takePresentForHouse(nextHouse);
        moveTo(nextHouse);

        return nextHouse;
    }

    private static void moveTo(House house) {
        sb.append(1).append(" ").append(house.idx).append("\n");
    }

    private static void takePresent(House house) {
        sb.append(2).append(" ").append(house.k).append("\n");
        if (houseMapK.get(house.k) != null) {
            houseMapK.get(house.k).remove(house);
            if (houseMapK.get(house.k).isEmpty()) {
                houseMapK.remove(house.k);
            }
        }
    }

    private static void takePresentForHouse(House house) {
        sb.append(2).append(" ").append(house.l).append("\n");
    }

    private static void dropPresent(House house) {
        sb.append(3).append(" ").append(house.l).append("\n");
        if (houseMapL.get(house.l) != null) {
            houseMapL.get(house.l).remove(house);
            if (houseMapL.get(house.l).isEmpty()) {
                houseMapL.remove(house.l);
            }
        }
    }

    private static void dropCurrentPresent(House house) {
        sb.append(3).append(" ").append(house.k).append("\n");
    }

    private static House getNextHouse(House curHouse) {
        int dist = Integer.MAX_VALUE;
        House nextHouse = null;
        for (House next : curHouse.k != -1 ? houseMapL.get(curHouse.k) : houseMapL.values().iterator().next()) {
            final int dx = Math.abs(curHouse.x - next.x);
            final int dy = Math.abs(curHouse.y - next.y);
            final int curDist = dx * dx + dy * dy;
            if (dx * dx + dy * dy < dist) {
                dist = curDist;
                nextHouse = next;
            }
        }

        return nextHouse;
    }

    private static class House {
        private int idx;
        private int x;
        private int y;
        private int k;
        private int l;

        House(int idx, int x, int y, int k, int l) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.k = k;
            this.l = l;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            House house = (House) o;

            return idx == house.idx;
        }

        @Override
        public int hashCode() {
            return idx;
        }
    }*/
}
