package twitter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter.user.UserSignIn;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class SignInController {

    @Autowired
    private UserSignIn userSignIn;


    @GetMapping
    public Boolean signInRegisteredUser(@RequestParam("email") String userEmail){
        return userSignIn.signInWithAccount(userEmail);
    }
}
