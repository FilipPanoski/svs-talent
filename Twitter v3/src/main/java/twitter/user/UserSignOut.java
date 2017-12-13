package twitter.user;

import org.springframework.stereotype.Component;
import twitter.activeusers.CurrentActiveUser;

@Component
public class UserSignOut {

    public void signOutAccount(){
        if (CurrentActiveUser.SIGNED_IN_ACCOUNT_EMAIL != null){
            CurrentActiveUser.SIGNED_IN_ACCOUNT_EMAIL = null;
            System.out.println("You have successfully logged out!");
        } else {
            System.out.println("You are not logged in! Log in or sign up an account.");
        }
    }
}
