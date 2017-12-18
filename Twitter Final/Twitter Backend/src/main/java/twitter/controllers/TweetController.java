package twitter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter.tweet.TweetPrinter;
import twitter.tweet.TweetWriter;

@RestController
@CrossOrigin
@RequestMapping("/users/{userId}")
public class TweetController {

    @Autowired
    private TweetWriter tweetWriter;
    @Autowired
    private TweetPrinter tweetPrinter;


    @PostMapping
    public Boolean writeNewTweet(@PathVariable Long userId, @RequestParam("message") String tweet){
        return tweetWriter.writeTweet(userId, tweet);
    }

    @GetMapping
    public String showTweets(@PathVariable Long userId){
        return tweetPrinter.showTweets(userId);
    }
}
