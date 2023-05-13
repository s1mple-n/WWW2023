package n16.hb_n16.impl;

import n16.hb_n16.entity.User;
import n16.hb_n16.repository.UserRepository;
import n16.hb_n16.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByGender(String gender) {
        return userRepository.getUsersByGender(gender);
    }

    @Override
    public User getUserByUserID(int userID) {
        return userRepository.findById(userID).get();
    }

    @Override
    public User getUserByUserName(String username) {
        return userRepository.getUsersByName(username);
    }

    @Override
    public void addOrUpdateUser(User newUser) {
        userRepository.save(newUser);

    }

    @Override
    public void updateOldUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> getUsersByRole(String role) {
        return userRepository.getUsersByRole(role);
    }

    @Override
    public List<User> searchUserALikeByKeyWord(String keyword) {
        return userRepository.searchUserAlikeByKeyWord("%"+keyword+"%");
    }

    @Override
    public List<User> getUsersByGender(String role, String gender) {
        return userRepository.getUsersByGender(role, gender);
    }
}
