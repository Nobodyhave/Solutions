package hackerrank.algorithms.search;

/**
 * Created by Aleksandr on 01/11/2016.
 * Project Solutions
 * <p>
 * https://www.hackerrank.com/challenges/gridland-metro
 */

import java.io.FileNotFoundException;
import java.util.*;

public class GridlandMetro {

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner in = new Scanner(System.in);

        final long N = in.nextLong();
        final long M = in.nextLong();
        final int K = in.nextInt();

        final Map<Integer, List<Track>> map = new HashMap<>();
        for (int i = 0; i < K; i++) {
            final int row = in.nextInt();
            List<Track> list = map.get(row);
            if (list != null) {
                list.add(new Track(in.nextInt(), in.nextInt()));
            } else {
                list = new ArrayList<>();
                list.add(new Track(in.nextInt(), in.nextInt()));
                map.put(row, list);
            }
        }

        for (List<Track> tracks : map.values()) {
            mergeTracks(tracks);
        }

        long allTracks = 0;
        for (List<Track> tracks : map.values()) {
            for (Track track : tracks) {
                allTracks += track.end - track.start + 1;
            }
        }

        System.out.println(N * M - allTracks);
    }

    private static void mergeTracks(List<Track> tracks) {
        if (tracks.size() < 2) {
            return;
        }

        Collections.sort(tracks);
        for (int i = 0; i < tracks.size() - 1; i++) {
            final Track t1 = tracks.get(i);
            final Track t2 = tracks.get(i + 1);

            if (t1.end >= t2.start) {
                tracks.remove(t1);
                tracks.remove(t2);
                tracks.add(i, new Track(Math.min(t1.start, t2.start), Math.max(t1.end, t2.end)));
                i--;
            }
        }
    }

    private static class Track implements Comparable<Track> {
        private int start;
        private int end;

        public Track(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Track o) {
            int result = Integer.compare(end, o.end);
            if (result == 0) {
                result = Integer.compare(start, o.start);
            }

            return result;
        }
    }
}
