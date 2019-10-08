package com.ly.entity.po;

import com.ly.entity.pojo.BaseEntity;
import lombok.*;

import java.util.Date;

/**
 * @author xinre
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
