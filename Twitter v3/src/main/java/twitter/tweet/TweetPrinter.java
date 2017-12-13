package twitter.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter.activeusers.CurrentActiveUser;
import twitter.user.User;
import twitter.user.UserRepository;

import java.util.*;

@Component
public class TweetPrinter {

    private Deque<Tweet> allTweets;

    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    UserRepository userRepository;

    public void showTweets(){
        System.out.println("All tweets:");
        allTweets = new ArrayDeque<>();
        getAllTweetsFromFollowingUsers();
        printTweets();
    }

    private void getAllTweetsFromFollowingUsers(){
        User currentUser = userRepository.findUserByEmail(CurrentActiveUser.SIGNED_IN_ACCOUNT_EMAIL);
        for (User user : currentUser.getFollowingUsers()){
            List<Tweet> userTweets = tweetRepository.findAllByUser(user);
            for (Tweet tweet : userTweets){
                allTweets.push(tweet);
            }
        }
    }

    private void printTweets(){
        int tweetCounter = 0;
        for (Tweet tweet : allTweets){
            tweetCounter++;
            System.out.println(tweetCounter + ". " + tweet.getTweet());
        }
    }
}
