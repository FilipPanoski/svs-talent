package twitter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter.tweet.TweetPrinter;
import twitter.tweet.TweetWriter;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserSignUp userSignUp;
    private UserSignIn userSignIn;
    private UserSignOut userSignOut;
    private UserFollowing userFollowing;

    private TweetWriter tweetWriter;
    private TweetPrinter tweetPrinter;

    @Autowired
    public UserController(UserSignUp userSignUp, UserSignIn userSignIn, UserSignOut userSignOut,
                          UserFollowing userFollowing, TweetWriter tweetWriter, TweetPrinter tweetPrinter){

        this.userSignUp = userSignUp;
        this.userSignIn = userSignIn;
        this.userSignOut = userSignOut;
        this.userFollowing = userFollowing;
        this.tweetWriter = tweetWriter;
        this.tweetPrinter = tweetPrinter;
    }

    @PostMapping
    public String signUpNewUser(@RequestParam("email") String userEmail){
        return userSignUp.signUpNewUser(userEmail);
    }

    @GetMapping
    public String signInRegisteredUser(@RequestParam("email") String userEmail){
        return userSignIn.signInWithAccount(userEmail);
    }

    @GetMapping("/logout")
    public String signOutLoggedUser(){
        return userSignOut.signOutAccount();
    }

    @PutMapping("/follow")
    public String followAnotherUser(@RequestParam("follow") String userEmail){
        return userFollowing.followAnotherUser(userEmail);
    }

    @PutMapping
    public String writeNewTweet(@RequestParam("tweet") String tweetMessage){
        return tweetWriter.writeTweet(tweetMessage);
    }

    @GetMapping("/show")
    public String showTweets(){
        return tweetPrinter.showTweets();
    }

}
