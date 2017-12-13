package twitter.user;

import twitter.tweet.Tweet;

import javax.persistence.*;
import java.util.*;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Tweet> tweets = new ArrayList<>();
    @ManyToMany(targetEntity = User.class, fetch = FetchType.EAGER)
    private Set<User> followingUsers = new HashSet<>();

    public User(){}
    public User(String email){
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<User> getFollowingUsers() {
        return followingUsers;
    }

    public void setFollowingUsers(Set<User> followingUsers) {
        this.followingUsers = followingUsers;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }
}
