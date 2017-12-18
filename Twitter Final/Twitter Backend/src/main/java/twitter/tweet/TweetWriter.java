package twitter.tweet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter.user.User;
import twitter.user.UserRepository;

@Component
public class TweetWriter {

    @Autowired
    TweetRepository tweetRepository;
    @Autowired
    UserRepository userRepository;

    public Boolean writeTweet(Long userId, String tweetMessage){
            Tweet newTweet = saveTweet(tweetMessage, userId);
            updateUserTweets(newTweet, userId);
            return true;
    }

    private Tweet saveTweet(String tweetMessage, Long userId){
        Tweet newTweet = new Tweet(tweetMessage, getUser(userId));
        tweetRepository.save(newTweet);
        return newTweet;
    }

    private User getUser(Long userId){
        return userRepository.findUserById(userId);
    }

    private void updateUserTweets(Tweet tweet, Long userId){
        User user = getUser(userId);
        user.getTweets().add(tweet);
        userRepository.save(user);
    }

}
