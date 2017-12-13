package twitter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserSignUp {

    @Autowired
    UserRepository userRepository;

    public String signUpNewUser(String email){
        User newUser = new User(email);
        newUser.getFollowingUsers().add(newUser);
        userRepository.save(newUser);
        return email + " was successfully signed up!";
    }
}
