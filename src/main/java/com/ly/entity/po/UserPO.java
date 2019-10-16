package com.ly.entity.po;

import com.ly.entity.pojo.BaseEntity;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author xinre
 */
//@Accessors(chain = true) // 使用这个注解时，在BeanUtils中复制的时候属性赋值不上
@Getter
@Setter
@ToString
public class UserPO extends BaseEntity {

    private String code;
    private String deptId;
    private String password;
    private String telephone;
    private String email;
    private int status;
    private String remark;
    private String operator;
    private Date operateTime;
    private String operateIp;
}
