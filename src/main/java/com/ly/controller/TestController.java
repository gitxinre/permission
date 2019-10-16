package com.ly.controller;

import com.ly.common.Result;
import com.ly.entity.dto.UserDTO;
import com.ly.entity.po.DeptPO;
import com.ly.exception.PermissionException;
import com.ly.util.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xinre
 */
@Slf4j
@Controller
@RequestMapping
public class TestController {

    @ResponseBody
    @RequestMapping("/hello.json")
    public Result hello(Map<String, Object> map, UserDTO userDTO, String id, HttpServletRequest request) {
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

        if (StringUtils.isNotBlank(id) && "1".equals(id)) {
            throw new PermissionException("test permission");
        }
        return Result.success(deptPOList);
    }

    @RequestMapping("/ntp")
    public String login() {
        return "login";
    }


    @ResponseBody
    @GetMapping(path = "divide")
    public int divide(int sub) {
        return 1000 / sub;
    }
    private int[] ans = new int[]{1, 2, 3, 4};
    @ResponseBody
    @GetMapping(path = "ary")
    public int ary(int index) {
        return ans[index];
    }



}
