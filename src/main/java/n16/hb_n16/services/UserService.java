package n16.hb_n16.services;

import n16.hb_n16.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    List<User> getUsersByGender(String gender);
    User getUserByUserID(int userID);
    User getUserByUserName(String username);
    void addOrUpdateUser(User newUser);
    void updateOldUser(User user);
    List<User> getUsersByRole(String role);
    List<User> searchUserALikeByKeyWord(String keyword);
    List<User> getUsersByGender(String role, String gender);
}
