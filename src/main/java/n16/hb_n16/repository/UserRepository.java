package n16.hb_n16.repository;

import n16.hb_n16.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("from User where username = :username")
    User getUsersByName(@Param("username") String username);
    @Query("from  User where  role = :role_value")
    List<User> getUsersByRole(@Param("role_value") String role);

    @Query("from  User where  gender = :gender")
    List<User> getUsersByGender(@Param("gender") String gender);

    @Query(value = "select  top 5 * from users where "
            + "last_name like :keyword or"
            + "phone like :keyword or"
            + "user_id_like :keyword",nativeQuery = true)
    List<User> searchUserAlikeByKeyWord(@Param("keyword") String keyword);
    @Query("from  User where gender = :gender_value AND role = :role_value")
    List<User> getUsersByGender(@Param("role_value") String role, @Param("gender_value") String gender);

}
