package org.example.poly.repo;

import org.example.poly.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User , Integer> {
    @Query("SELECT u FROM User u " +
            " WHERE u.email = :email")
    User getUserByEmail(@Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.userName = :userName ")
    User getUserByUserName(@Param("userName") String userName);
}
