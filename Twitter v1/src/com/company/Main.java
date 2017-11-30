package com.company;
import java.util.*;

public class Main {

    static Twitter tw;
    static boolean isRunning;

    public static void main(String[] args) {
        initApplication();
        startApplication();
    }

    public static void initApplication(){
        tw = new Twitter();
        showInitMessage();
    }

    public static void startApplication(){
        isRunning = true;
        while (isRunning){
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            switch (command){
                case ("tweet"):
                    System.out.print("Write your tweet: ");
                    String message = scanner.nextLine();
                    tw.tweet(message);
                    System.out.println(" - Tweet saved!");
                    break;
                case ("show"):
                    System.out.println("All tweets:");
                    tw.showTweets();
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

    public static void showInitMessage(){
        System.out.println("Welcome to Filip's Twitter Application!");
        System.out.println("Commands: \n 'tweet' - write a tweet \n 'show' - show all tweets \n " +
                "'exit' - exit the application");
    };
}
