package twitter.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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


    public String showTweets(Long userId){
        allTweets = new ArrayDeque<>();
        return putTweetsIntoAString(getAllTweetsFromFollowers(userId));
    }

    private Deque<Tweet> getAllTweetsFromFollowers(Long userId){
        for (User user : getUser(userId).getFollowingUsers()){
            for (Tweet tweet : user.getTweets()){
                allTweets.push(tweet);
            }
        }
        return allTweets;
    }

    private User getUser(Long userId){
        return userRepository.findUserById(userId);
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
