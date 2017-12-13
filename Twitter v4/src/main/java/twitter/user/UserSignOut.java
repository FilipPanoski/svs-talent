package twitter.user;

import org.springframework.stereotype.Component;
import twitter.activeusers.CurrentActiveUser;

@Component
public class UserSignOut {

    public String signOutAccount(){
        if (CurrentActiveUser.SIGNED_IN_ACCOUNT_EMAIL != null){
            CurrentActiveUser.SIGNED_IN_ACCOUNT_EMAIL = null;
            return "You have successfully logged out!";
        } else {
            return "You are not logged in! Log in or sign up an account.";
        }
    }
}
