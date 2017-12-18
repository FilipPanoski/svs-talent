package twitter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserSignUp {

    @Autowired
    UserRepository userRepository;


    public Boolean signUpNewUser(String email){
        if (!checkIfUserAlreadyExists(email)) {
            User newUser = new User(email);
            newUser.getFollowingUsers().add(newUser);
            userRepository.save(newUser);
            return true;
        }

        return false;
    }

    private boolean checkIfUserAlreadyExists(String email){
        User user = userRepository.findUserByEmail(email);
        if (user == null){
            return false;
        }

        return true;
    }
}
