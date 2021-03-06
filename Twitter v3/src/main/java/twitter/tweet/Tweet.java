package twitter.tweet;

import twitter.user.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tweet {

    @Id
    @GeneratedValue
    private Long id;
    private String tweet;

    @ManyToOne
    private User user;

    public Tweet(){}
    public Tweet(String tweet, User user){
        this.tweet = tweet;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }
}
