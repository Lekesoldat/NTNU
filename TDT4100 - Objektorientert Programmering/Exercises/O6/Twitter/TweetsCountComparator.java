package interfaces.twitter;

import java.util.Comparator;

public class TweetsCountComparator implements Comparator<TwitterAccount> {

  @Override
  public int compare(TwitterAccount o1, TwitterAccount o2) {
    return o2.getTweetCount() - o1.getTweetCount();
  }
  
}
