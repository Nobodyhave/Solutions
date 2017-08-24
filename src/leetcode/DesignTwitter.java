package leetcode;

import java.util.*;

/**
 * Created by Aleksandr on 24/08/2017.
 * Project Solutions
 * <p>
 * https://leetcode.com/problems/design-twitter
 */
public class DesignTwitter {
    private int time = 0;
    private Map<Integer, TreeSet<Tweet>> userToTweet;
    private Map<Integer, Set<Integer>> userToUser;

    public DesignTwitter() {
        userToTweet = new HashMap<>();
        userToUser = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        userToTweet.computeIfAbsent(userId, key -> new TreeSet<>());
        userToTweet.get(userId).add(new Tweet(userId, tweetId, time++));
    }

    public List<Integer> getNewsFeed(int userId) {
        final Set<Integer> users = new HashSet<>();
        if (userToUser.get(userId) != null) {
            users.addAll(userToUser.get(userId));
        }
        users.add(userId);

        final List<Iterator<Tweet>> tweetIterators = new ArrayList<>();
        for (Integer user : users) {
            if (userToTweet.get(user) != null) {
                tweetIterators.add(userToTweet.get(user).iterator());
            }
        }

        final List<Integer> tweets = new ArrayList<>();
        final PriorityQueue<Tweet> pq = new PriorityQueue<>();
        for (Iterator<Tweet> iterator : tweetIterators) {
            for (int i = 0; i < 10 && iterator.hasNext(); i++) {
                pq.add(iterator.next());
            }
        }

        for (int i = 0; i < 10 && !pq.isEmpty(); i++) {
            tweets.add(pq.poll().tweetId);
        }

        return tweets;
    }

    public void follow(int followerId, int followeeId) {
        userToUser.computeIfAbsent(followerId, key -> new HashSet<>());
        userToUser.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        userToUser.computeIfAbsent(followerId, key -> new HashSet<>());
        userToUser.get(followerId).remove(followeeId);
    }

    private static class Tweet implements Comparable<Tweet> {
        private int userId;
        private int tweetId;
        private int time;

        Tweet(int userId, int tweetId, int time) {
            this.userId = userId;
            this.tweetId = tweetId;
            this.time = time;
        }

        @Override
        public int compareTo(Tweet o) {
            return o.time - time;
        }
    }
}
