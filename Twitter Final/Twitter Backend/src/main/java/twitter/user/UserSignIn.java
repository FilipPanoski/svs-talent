package twitter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserSignIn {

    @Autowired
    UserRepository userRepository;

    public Boolean signInWithAccount(String email){
        if (checkIfAccountExists(email)){
            return true;
        }

        return false;
    }

    private boolean checkIfAccountExists(String accountEmail){
        User user = userRepository.findUserByEmail(accountEmail);
        if (user != null){
            return true;
        }
        return false;
    }
}
