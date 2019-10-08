package com.ly.controller;

import com.ly.common.ReturnResult;
import com.ly.entity.dto.UserDTO;
import com.ly.entity.po.DeptPO;
import com.ly.util.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xinre
 */
@Slf4j
@RestController
@RequestMapping("/demo")
public class TestController {

    @RequestMapping("/hello.json")
    public ReturnResult hello(Map<String, Object> map, UserDTO userDTO, String id) {

        System.out.println("map = " + map.size());
        System.out.println("userDTO = " + userDTO);
        List<DeptPO> deptPOList = new ArrayList<DeptPO>();
        for (int i = 0; i < 5; i++) {
            DeptPO mfl = DeptPO.builder().operateTime(new Date()).build();
            //.id(IdGenerator.guid()).name("mfl")
            mfl.setId(IdGenerator.guid());
            mfl.setName("mfl");
            log.info("dfasdfasdf:[{}]", IdGenerator.guid());
            deptPOList.add(mfl);
        }

        //throw new RuntimeException("test permission");
        return ReturnResult.success(deptPOList);
    }

}
