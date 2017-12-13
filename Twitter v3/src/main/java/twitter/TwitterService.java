package twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import twitter.activeusers.CurrentActiveUser;
import twitter.tweet.TweetPrinter;
import twitter.tweet.TweetWriter;
import twitter.user.UserFollowing;
import twitter.user.UserSignIn;
import twitter.user.UserSignOut;
import twitter.user.UserSignUp;

import java.util.Scanner;

@Service
public class TwitterService {

    private Scanner commandScanner;
    private String command;

    private TweetWriter tweetWriter;
    private TweetPrinter tweetPrinter;
    private UserSignUp userSignUp;
    private UserSignIn userSignIn;
    private UserSignOut userSignOut;
    private UserFollowing userFollowing;

    @Autowired
    public TwitterService(TweetWriter tweetWriter, TweetPrinter tweetPrinter, UserSignUp userSignUp,
                          UserSignIn userSignIn, UserSignOut userSignOut, UserFollowing userFollowing){
        this.tweetWriter = tweetWriter;
        this.tweetPrinter = tweetPrinter;
        this.userSignUp = userSignUp;
        this.userSignIn = userSignIn;
        this.userSignOut = userSignOut;
        this.userFollowing = userFollowing;
    }

    protected void startApplication(){
        showWelcomeAndCommandsMessage();
        startScanningForCommands();
    }

    private void showWelcomeAndCommandsMessage(){
        System.out.println("Welcome to Filip's Twitter Application!");
        System.out.println("Commands: \n 'sign up' - sign up an account \n 'sign in' - log in with an account \n" +
                " 'sign out' - log out from an account \n 'tweet' - write a tweet \n 'show' - show all tweets \n" +
                " 'follow' - follow another user \n 'help' - get command lines");
    }

    private void startScanningForCommands(){
        while (true){
            commandScanner = new Scanner(System.in);
            command = commandScanner.nextLine();
            scanCommands();
        }
    }

    private void scanCommands(){
        switch (command){
            case ("sign up"):
                userSignUp.signUpNewUser(commandScanner);
                break;
            case ("sign in"):
                userSignIn.signInWithAccount(commandScanner);
                break;
            case ("sign out"):
                userSignOut.signOutAccount();
                break;
            case ("tweet"):
                if (checkIfSignedIn())
                    tweetWriter.writeTweet(commandScanner);
                break;
            case ("show"):
                if (checkIfSignedIn())
                    tweetPrinter.showTweets();
                break;
            case ("follow"):
                if (checkIfSignedIn())
                    userFollowing.followAnotherUser(commandScanner);
                break;
            case ("help"):
                showWelcomeAndCommandsMessage();
                break;
            default:
                System.out.println("Invalid command!\nType 'help' for command lines.");
                break;
        }
    }

    private boolean checkIfSignedIn(){
        if (CurrentActiveUser.SIGNED_IN_ACCOUNT_EMAIL != null){
            return true;
        } else {
            System.out.println("You are not signed in! Sign in or create an account.");
            return false;
        }
    }
}
