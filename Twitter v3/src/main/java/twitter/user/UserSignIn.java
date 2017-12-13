package twitter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter.activeusers.CurrentActiveUser;

import java.util.Scanner;

@Component
public class UserSignIn {

    @Autowired
    UserRepository userRepository;

    public void signInWithAccount(Scanner commandScanner){
        System.out.print("Enter your account email: ");
        String accountEmail = commandScanner.nextLine();
        if (checkIfAccountExists(accountEmail)){
            CurrentActiveUser.SIGNED_IN_ACCOUNT_EMAIL = accountEmail;
            System.out.println("You have successfully logged in! \nWelcome " + accountEmail);
        } else {
            System.out.println("Invalid email! Try again or sign up an account!");
        }
    }

    private boolean checkIfAccountExists(String accountEmail){
        User user = userRepository.findUserByEmail(accountEmail);
        if (user != null){
            return true;
        }
        return false;
    }
}
