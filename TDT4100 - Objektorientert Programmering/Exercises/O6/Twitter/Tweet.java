package interfaces.twitter;

public class Tweet {
  private TwitterAccount account;
  private String text = "";
  private Tweet originalTweet = null;
  private int retweetCount = 0;
  
  public Tweet(TwitterAccount a, String s) {
    this.account = a;
    this.text = s;
  }
  
  public Tweet(TwitterAccount owner, Tweet originalTweet) {
    // If i retweet myself
    if (originalTweet.getOwner() == owner) {
      throw new IllegalArgumentException("Do not retweet yourself.");
    }
    
    // If i retweet a retweet of myself
    if (originalTweet.getOriginalTweet() != null && originalTweet.getOriginalTweet().getOwner() == owner) {
      throw new IllegalArgumentException("Still yourself.");
    }
    
    this.account = owner;
    this.originalTweet = originalTweet.getOriginalTweet() != null ? originalTweet.getOriginalTweet() : originalTweet;
    this.originalTweet.retweetCount++;
    this.text = originalTweet.getText();
  }
  
  public TwitterAccount getOwner() {
    return this.account;
  }
  
  public String getText() {
    return this.text;
  }
  
  public Tweet getOriginalTweet() {
    return this.originalTweet;
  }
  
  public int getRetweetCount() {
    return this.retweetCount;
  }
  
}
