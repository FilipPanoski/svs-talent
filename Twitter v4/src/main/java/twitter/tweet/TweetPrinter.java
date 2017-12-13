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

    public String showTweets(){
        allTweets = new ArrayDeque<>();
        if (checkIfSignedIn()){
            return putTweetsIntoAString(getAllTweetsFromFollowers());
        } else
            return "You are not logged in! Sign in or create an account.";
    }

    private boolean checkIfSignedIn(){
        User currentUser = getCurrentUser();
        if (currentUser != null){
            return true;
        }
        return false;
    }

    private User getCurrentUser(){
        return userRepository.findUserByEmail(CurrentActiveUser.SIGNED_IN_ACCOUNT_EMAIL);
    }

    private Deque<Tweet> getAllTweetsFromFollowers(){
        for (User user : getCurrentUser().getFollowingUsers()){
            for (Tweet tweet : user.getTweets()){
                allTweets.push(tweet);
            }
        }
        return allTweets;
    }

    private String putTweetsIntoAString(Deque<Tweet> allTweets){
        StringBuilder tweetList = new StringBuilder();
        String finalTweetList;
        for (Tweet tweet : allTweets){
            tweetList.append(tweet.getUser().getEmail() + ":\n" + tweet.getTweet() + "\n\n");
        }
        finalTweetList = tweetList.toString();
        return finalTweetList;
    }
}
