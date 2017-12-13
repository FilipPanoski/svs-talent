package twitter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter.activeusers.CurrentActiveUser;


@Component
public class UserSignIn {

    @Autowired
    UserRepository userRepository;

    public String signInWithAccount(String email){
        if (checkIfAccountExists(email)){
            CurrentActiveUser.SIGNED_IN_ACCOUNT_EMAIL = email;
            return "You have successfully logged in! \nWelcome " + email;
        } else {
            return "Invalid email! Try again or sign up an account!";
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
