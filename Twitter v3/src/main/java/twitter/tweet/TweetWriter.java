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

    public void writeTweet(Scanner commandScanner){
        System.out.print("Write your tweet: ");
        String message = commandScanner.nextLine();
        User currentUser = userRepository.findUserByEmail(CurrentActiveUser.SIGNED_IN_ACCOUNT_EMAIL);
        Tweet tweet = new Tweet(message, currentUser);
        tweetRepository.save(tweet);
        System.out.println(" - Tweet saved!");
    }
}
