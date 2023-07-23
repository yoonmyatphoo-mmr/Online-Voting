package com.ymp.onlinevoltingsystem.repository;

import com.ymp.onlinevoltingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author Yoon Myat Phoo
 * @created 7/23/2023
 * @project online-voting-system
 * @package com.ymp.onlinevotingsystem.repository
 */
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByEmailAndPassword(String email, String password);
    List<User> findByEmail(String email);

}
