package com.ly.service;

import com.ly.entity.dto.UserDTO;
import com.ly.entity.po.UserPO;

/**
 * @author xinre
 */
public interface UserService {

    void saveUser(UserDTO userDTO);

    UserPO login(String username, String password);
}
