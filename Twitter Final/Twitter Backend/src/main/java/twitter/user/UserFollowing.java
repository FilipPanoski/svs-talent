package twitter.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserFollowing {

    @Autowired
    UserRepository userRepository;

    public Boolean followAnotherUser(Long currentUserId, Long userToFollowId){
        User currentUser = userRepository.findUserById(currentUserId);
        User userToFollow = userRepository.findUserById(userToFollowId);
        return updateUserFollowers(currentUser, userToFollow);
    }

    private Boolean updateUserFollowers(User currentUser, User userToFollow){
        currentUser.getFollowingUsers().add(userToFollow);
        userRepository.save(currentUser);
        return true;
    }
}
