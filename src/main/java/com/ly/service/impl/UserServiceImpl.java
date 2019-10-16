package com.ly.service.impl;

import com.ly.common.ThreadHolder;
import com.ly.dao.UserDao;
import com.ly.entity.dto.UserDTO;
import com.ly.entity.po.UserPO;
import com.ly.exception.PermissionSqlException;
import com.ly.service.UserService;
import com.ly.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xinre
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired(required = false)
    private UserDao userDao;

    @Override
    public void saveUser(UserDTO userDTO) {

        UserPO userPO = BeanUtil.convert(userDTO, UserPO.class);
        /*userPO.setOperateIp(IpUtils.getIpAddress(ThreadHolder.getRequest()))
                .setOperateTime(DateUtils.currentTime())
                .setOperator(ThreadHolder.getUser().getId())
                .setPassword(PinYinUtils.allSpelling(userDTO.getName()));*/
        userPO.setId(IdGenerator.guid());
        userPO.setNameHeadChar(PinYinUtils.headChar(userDTO.getName()));
        try {
            userDao.saveUser(userPO);
        } catch (Exception e) {
            throw new PermissionSqlException(e.getMessage());
        }
    }

    @Override
    public UserPO login(String username, String password) {
        return null;
    }
}
