package com.ymp.onlinevoltingsystem.service;

import com.ymp.onlinevoltingsystem.model.User;
import com.ymp.onlinevoltingsystem.repository.UserRepository;
import com.ymp.onlinevoltingsystem.util.ValidationUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

/**
 * @Author Yoon Myat Phoo
 * @created 7/20/2023
 * @project online-voting-system
 * @package com.ymp.onlinevotingsystem.service
 */
@Service
@Slf4j // for logging by using lombok
@RequiredArgsConstructor
public class SelectionServiceImpl implements SelectionService{

    @Autowired
    UserRepository userRepository;

    @Override
    public String register(User user) {
        try {
            if (!ValidationUtil.isValidString(user.getEmail()) || !ValidationUtil.isValidString(user.getPassword()))
            {
                return "input is empty";
            }else if (!ValidationUtil.isValidString(user.getPassword()) || !user.getPassword().equals(user.getConfirmPassword())) {
                return "Password and Confirmation Password do not match or input is empty";
            }
            else {
                List<User> userList = userRepository.findByEmail(user.getEmail());
                if (!userList.isEmpty()) {
                    log.info("Duplicate login");
                    return "duplicate user";
                }
                User userRegister = new User();
                userRegister.setEmail(user.getEmail());
                userRegister.setPassword(user.getPassword());
                userRegister.setRoleId(2L);
                userRepository.save(userRegister);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "system error";
        }
        return "Successfully Registered!!!";
    }

    @Override
    public User login(User user) {

      List<User> userList = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
        log.info("userList: {}",userList);
        if (userList == null || userList.size() == 0) {
            log.info("Wrong credentials");
            return null;
        }

        if (userList.size() > 1) {
            log.info("Something went wrong, contact to administrator");
            return null;
        }

        return userList.get(0);
    }
}
