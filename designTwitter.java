import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Tweet implements Comparable<Tweet>{
    int time;
    int tweetId;
    Tweet(int t, int id){
        time = t;
        tweetId = id;
    }

    public int compareTo(Tweet that){
        return that.time - this.time;  //decreasing order
    }
}

class User{
    int userId;
    HashSet<Integer> followers;
    List<Tweet> tweets;

    User(int userId){
        this.userId = userId;
        followers = new HashSet<>();
        tweets = new LinkedList<>();
    }

    public void addTweet(Tweet t){
        tweets.add(0, t);  //insertion at the head
    }

    public void addFollower(int followeeId){
        followers.add(followeeId);
    }

    public void removeFollower(int followeeId){
        followers.remove(followeeId);
    }
}

class Twitter{
    HashMap<Integer, User> userMap;
    int timeCounter;
    public Twitter(){
        userMap = new HashMap<>();
        timeCounter = 0;
    }

    public void postTweet(int userId, int tweetId){
        timeCounter++;
        if(!userMap.containsKey(userId)){
            userMap.put(userId, new User(userId));
        }

        User user = userMap.get(userId);
        user.addTweet(new Tweet(timeCounter, tweetId));
    }

    public List<Integer> getNewsFeed(int userId){
        if(!userMap.containsKey(userId)){
            return new ArrayList<>();
        }
        PriorityQueue<Tweet> pq = new PriorityQueue<>();

        // add self tweets + followers tweets

        User user = userMap.get(userId);
        for(int followerId: user.followers){
            int count = 0;
            for(Tweet tweet: userMap.get(followerId).tweets){
                pq.offer(tweet);
                count++;
                if(count > 10){
                    break;
                }
            }
        }

        int count = 0;
        for(Tweet tweet: user.tweets){
            pq.offer(tweet);
            count++;
            if(count > 10){
                break;
            }
        }
        List<Integer> res = new ArrayList<>();
        int index = 0;
        while(!pq.isEmpty() && index < 10){
            Tweet tweet = pq.poll();
            res.add(tweet.tweetId);
            index++;
        }
        return res;
    }

    public void follow(int followerId, int followeeId){
        if(!userMap.containsKey(followerId)){
            userMap.put(followerId, new User(followerId));
        }

        if(!userMap.containsKey(followeeId)){
            userMap.put(followeeId, new User(followeeId));
        }

        User user = userMap.get(followerId);
        user.addFollower(followeeId);
    }

    public void unfollow(int followerId, int followeeId){
        if(!userMap.containsKey(followerId) || !userMap.containsKey(followeeId)){
            return;
        }
        User user = userMap.get(followerId);
        user.removeFollower(followeeId);
    }
}
public class designTwitter{
    public static void main(String args[]) {
        Twitter twitter = new Twitter();

        // User 1 posts tweets
        twitter.postTweet(1, 101);
        twitter.postTweet(1, 102);

        // User 2 posts a tweet
        twitter.postTweet(2, 201);

        // User 1 follows User 2
        twitter.follow(1, 2);

        // Get news feed for User 1
        System.out.println(twitter.getNewsFeed(1));
        // Expected: [201, 102, 101]

        // User 1 unfollows User 2
        twitter.unfollow(1, 2);

        // Get news feed again for User 1
        System.out.println(twitter.getNewsFeed(1));
        // Expected: [102, 101]
    }

}