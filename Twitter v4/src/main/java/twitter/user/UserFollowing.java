package twitter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter.activeusers.CurrentActiveUser;


@Component
public class UserFollowing {

    @Autowired
    UserRepository userRepository;

    public String followAnotherUser(String userEmail){
        if (checkIfLoggedIn()) {
            if (checkIfUserExists(userEmail)) {
                updateUserFollowers(userEmail);
                return "You are now following " + userEmail;
            } else
                return userEmail + " doesn't exist! Check your spelling and try again.";
        } else
            return "You are not logged in! Sign in or create a new account.";
    }

    private boolean checkIfLoggedIn(){
        if (CurrentActiveUser.SIGNED_IN_ACCOUNT_EMAIL != null){
            return true;
        }
        return false;
    }

    private boolean checkIfUserExists(String userEmail){
        User user = userRepository.findUserByEmail(userEmail);
        if (user != null){
            return true;
        }
        return false;
    }

    private void updateUserFollowers(String userEmail){
        User currentUser = userRepository.findUserByEmail(CurrentActiveUser.SIGNED_IN_ACCOUNT_EMAIL);
        User user = userRepository.findUserByEmail(userEmail);
        currentUser.getFollowingUsers().add(user);
        userRepository.save(currentUser);
    }
}
