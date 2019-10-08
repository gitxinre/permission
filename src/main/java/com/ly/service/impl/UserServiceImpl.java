package com.ly.service.impl;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.ly.entity.dto.UserDTO;
import com.ly.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author xinre
 */
@Service
public class UserServiceImpl implements UserService {

    public static void main(String[] args) {
        Multimap<String, Object> multimap = ArrayListMultimap.create();

        multimap.put("a", 1);
        multimap.put("a", "yf");
        List<Object> a = (List<Object>) multimap.get("a");

        System.out.println("a = " + a.toString());
        Map<String, Object> map = new HashMap<String, Object>();
        if (CollectionUtils.isEmpty(a)) {
            map.isEmpty();
        }
    }


    @Override
    public void saveUser(UserDTO userDTO) {

    }
}
