package twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScanCommands {

    private Tweets tweets;
    private boolean isRunning = false;

    @Autowired
    private ScanCommands(Tweets tweets){
        this.tweets = tweets;
    }

    public void startApplication(){
        showInitMessage();
        scanForCommands();
    }

    private void showInitMessage(){
        System.out.println("Welcome to Filip's Twitter Application!");
        System.out.println("Commands: \n 'tweet' - write a tweet \n 'show' - show all tweets \n " +
                "'exit' - exit the application");
    }

    private void scanForCommands(){
        isRunning = true;
        while (isRunning){
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            switch (command){
                case ("tweet"):
                    System.out.print("Write your tweet: ");
                    String message = scanner.nextLine();
                    tweets.tweet(message);
                    System.out.println(" - Tweet saved!");
                    break;
                case ("show"):
                    System.out.println("All tweets:");
                    tweets.showTweets();
                    break;
                case ("exit"):
                    System.out.println("Closing application...");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }
        }
    }
}
