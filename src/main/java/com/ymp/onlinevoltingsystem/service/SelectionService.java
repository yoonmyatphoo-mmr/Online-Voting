package com.ymp.onlinevoltingsystem.service;

import com.ymp.onlinevoltingsystem.model.User;

/**
 * @Author Yoon Myat Phoo
 * @created 7/20/2023
 * @project online-voting-system
 * @package com.ymp.onlinevotingsystem.service
 */
public interface SelectionService {

    String register(User user);

    User login(User user);
}
