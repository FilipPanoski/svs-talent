package twitter.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import twitter.user.UserSignUp;

@RestController
@CrossOrigin
@RequestMapping("/signup")
public class SignUpController {

    @Autowired
    private UserSignUp userSignUp;


    @PostMapping
    public Boolean signUpNewUser(@RequestParam("email") String userEmail){
        return userSignUp.signUpNewUser(userEmail);
    }
}
