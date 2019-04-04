package interfaces.twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TwitterAccount {
  private String username;
  List<TwitterAccount> followers = new ArrayList<TwitterAccount>();
  List<TwitterAccount> following = new ArrayList<TwitterAccount>();
  List<Tweet> tweets = new ArrayList<Tweet>();
  
  public TwitterAccount(String username) {
    this.username = username;
  }
  
  public String getUserName() {
    return this.username;
  }
  
  public void follow(TwitterAccount account) {
    if (this == account) {
      throw new IllegalArgumentException("Don't follow yourself.");
    }
    
    if (!following.contains(account)) {
      following.add(account);
      account.followers.add(this);
    }
  }
  
  public void unfollow(TwitterAccount account) {
    if (account == this) {
      throw new IllegalArgumentException("You cannot unfollow yourself.");
    }
    
    if (following.contains(account)) {
      following.remove(account);
      account.followers.remove(this);
    }
  }
  
  public boolean isFollowing(TwitterAccount a) {
    return this.following.contains(a);
  }
  
  public boolean isFollowedBy(TwitterAccount a) {
    return this.followers.contains(a);
  }
  
  public void tweet(String s) {
    this.tweets.add(new Tweet(this, s));
  }
  
  public void retweet(Tweet tweet) {
    this.tweets.add(new Tweet(this, tweet));
  }
  
  public Tweet getTweet(int i) {
    return tweets.get(tweets.size() - i);
  }
  
  public int getTweetCount() {
    return this.tweets.size();
  }
  
  public int getRetweetCount() {
    int count = 0;
    for (Tweet tweet : tweets) {
      count += tweet.getRetweetCount();
    }
    return count;
  }
  
  public int getFollowerCount() {
    return this.followers.size();
  }
  
  public List<TwitterAccount> getFollowers(Comparator<TwitterAccount> comparator) {
    if (comparator == null) {
      return this.followers;
    }
    
    List<TwitterAccount> tmp = new ArrayList<>(this.followers);
    tmp.sort(comparator);
    return tmp;
  }
}
