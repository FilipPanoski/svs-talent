package com.company;
import java.util.*;

public class Twitter {

    Deque<String> tweets = new ArrayDeque<>();

    public void tweet(String tweet){
        tweets.push(tweet);
    }

    public void showTweets(){
        int counter = 0;
        for (Iterator i = tweets.iterator(); i.hasNext(); ){
            counter++;
            String tweet = (String) i.next();
            System.out.println(counter + ". " + tweet);
        }
    }
}
