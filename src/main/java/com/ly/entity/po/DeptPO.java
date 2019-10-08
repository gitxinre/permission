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
@ToString
public class DeptPO extends BaseEntity {

    /*private String id;
    private String name;*/
    private String pId;
    private int level;
    private int orderId;
    private String remark;
    private String operator;
    private Date operateTime;
    private String operateIp;
}
