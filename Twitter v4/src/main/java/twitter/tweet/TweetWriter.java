package twitter.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter.activeusers.CurrentActiveUser;
import twitter.user.User;
import twitter.user.UserRepository;

import java.util.Scanner;

@Component
public class TweetWriter {

    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    UserRepository userRepository;

    public String writeTweet(String tweetMessage){
        if (checkIfLoggedIn()){
            Tweet currentTweet = saveTweet(tweetMessage);
            updateUserTweets(currentTweet);
            return "Tweet saved!";
        }
        return "You are not logged in! Log in or create an account.";
    }

    private boolean checkIfLoggedIn(){
        if (CurrentActiveUser.SIGNED_IN_ACCOUNT_EMAIL != null){
            return true;
        }
        return false;
    }

    private Tweet saveTweet(String tweetMessage){
        Tweet newTweet = new Tweet(tweetMessage, getCurrentUser());
        tweetRepository.save(newTweet);
        return newTweet;
    }

    private User getCurrentUser(){
        return userRepository.findUserByEmail(CurrentActiveUser.SIGNED_IN_ACCOUNT_EMAIL);
    }

    private void updateUserTweets(Tweet tweet){
        getCurrentUser().getTweets().add(tweet);
        userRepository.save(getCurrentUser());
    }

}
