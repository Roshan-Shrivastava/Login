package com.roshan.login.Repository;

import com.roshan.login.Controller.Login.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Long> {

    // Add a method to find a user by username
    @Query(value = "select Distinct c.username from user_detail c where c.username=?1",nativeQuery = true)
    Optional<String> findDistinctByUsername(String username);

    Optional<LoginEntity> findByUsername(String username);

//    Optional<LoginEntity> findById(String username);

    Optional<LoginEntity> findByPassword(String password);
//    @Query(value = "Select u.* from user_detail u ",nativeQuery = true)
    Optional<LoginEntity> findByCustTypeAndUsernameAndPassword (String custType, String username, String password);

}
