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
public class AclModulePO extends BaseEntity {

    private String pId;
    private int level;
    private int orderId;
    private int status;
    private String remark;
    private String operator;
    private Date operateTime;
    private String operateIp;
}
