package com.ly.dao;

import com.ly.entity.po.UserPO;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xinre
 */
public interface UserDao {


    void saveUser(UserPO userPO);

    @ResultMap("userResultMap")
    @Select("select * from demo_user")
    List<UserPO> listUser();



    class UserDaoProvider {

    }
}
