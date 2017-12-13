package twitter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UserSignUp {

    @Autowired
    UserRepository userRepository;

    public void signUpNewUser(Scanner commandScanner){
        System.out.print("Enter your email: ");
        String email = commandScanner.nextLine();
        User newUser = new User(email);
        newUser.getFollowingUsers().add(newUser);
        userRepository.save(newUser);
        System.out.println("You successfully signed up!");
    }
}
