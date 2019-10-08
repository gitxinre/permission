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
public class RolePO extends BaseEntity {

    private int type;
    private int status;
    private String remark;
    private String operator;
    private Date operateTime;
    private String operateIp;
}
