package twitter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import twitter.activeusers.CurrentActiveUser;

import java.util.Scanner;

@Component
public class UserFollowing {

    @Autowired
    UserRepository userRepository;

    public void followAnotherUser(Scanner commandScanner){
        System.out.print("Enter the user's email whom you want to follow: ");
        String userEmail = commandScanner.nextLine();
        checkAndFollowUser(userEmail);
    }

    private void checkAndFollowUser(String userEmail){
        User user = userRepository.findUserByEmail(userEmail);
        if (user != null){
            User currentUser = userRepository.findUserByEmail(CurrentActiveUser.SIGNED_IN_ACCOUNT_EMAIL);
            currentUser.getFollowingUsers().add(user);
            userRepository.save(currentUser);
            System.out.println("You are now following " + userEmail);
        } else {
            System.out.println(userEmail + " doesn't exist! Check the spelling again.");
        }
    }
}
