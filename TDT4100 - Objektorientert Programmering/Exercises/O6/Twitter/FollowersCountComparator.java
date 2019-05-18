package interfaces.twitter;

import java.util.Comparator;

public class FollowersCountComparator implements Comparator<TwitterAccount> {
 @Override
 public int compare(TwitterAccount a1, TwitterAccount a2) {
   return a2.getFollowerCount() - a1.getFollowerCount();
 }
}
