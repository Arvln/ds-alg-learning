package questions.design_ds.twitter;

import java.util.*;

public class Twitter {
    private static int timeStamp=0;
    private HashMap<Integer, User> userMap=new HashMap<>();
    private static class User {
        private int id;
        public Set<Integer> followed;
        public Tweet head;

        public User(int id) {
            this.id=id;
            followed=new HashSet<>();
            follow(id);
        }

        public void follow(int userId) {
            followed.add(userId);
        }

        public void unfollowed(int userId) {
            if (id==userId) return;

            followed.remove(userId);
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId, timeStamp);
            timeStamp++;

            tweet.next=head;
            head=tweet;
        }
    }
    private static class Tweet {
        private int id, time;
        private Tweet next;

        public Tweet(int id, int time) {
            this.id=id;
            this.time=time;
        }
    }

    public void postTweet(int userId, int tweetId) {
        userMap.putIfAbsent(userId, new User(userId));
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res=new LinkedList<>();
        if (!userMap.containsKey(userId)) return res;

        Set<Integer> followed = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>(followed.size(), (a, b) -> b.time - a.time);

        for (Integer followerId : followed) {
            Tweet posts = userMap.get(followerId).head;
            if (posts!=null) pq.offer(posts);
        }

        while (!pq.isEmpty()&&res.size()<10) {
            Tweet closestTweet = pq.poll();
            res.add(closestTweet.id);

            if (closestTweet.next!=null) pq.offer(closestTweet.next);
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        userMap.putIfAbsent(followerId, new User(followerId));
        userMap.putIfAbsent(followeeId, new User(followeeId));
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) return;

        userMap.get(followerId).unfollowed(followeeId);
    }
}
