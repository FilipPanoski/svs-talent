package twitter;

import org.springframework.stereotype.Component;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

@Component
public class Tweets {

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
