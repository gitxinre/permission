package com.ly.entity.po;

import com.ly.entity.pojo.BaseEntity;
import lombok.*;

import java.util.Date;

/**
 * 权限ACL是AccessControlList(访问控制列表)的缩写
 *
 * @author xinre
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AclPO extends BaseEntity {

    private String code;
    private String aclModuleId;
    private String url;
    private int type;
    private int orderId;
    private int status;
    private String remark;
    private String operator;
    private Date operateTime;
    private String operateIp;

}
