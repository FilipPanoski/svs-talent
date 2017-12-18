package twitter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter.user.UserFollowing;

@RestController
@CrossOrigin
@RequestMapping("/users/{currentUserId}")
public class UserFollowingController {

    @Autowired
    UserFollowing userFollowing;


    @PutMapping
    public Boolean followAnotherUser(@PathVariable Long currentUserId, @RequestParam("userId") Long userToFollowId){
        return userFollowing.followAnotherUser(currentUserId, userToFollowId);
    }
}
