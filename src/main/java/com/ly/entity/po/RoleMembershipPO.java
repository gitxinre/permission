package com.ly.entity.po;

import lombok.*;

import java.util.Date;

/**
 * 角色关系持久类（角色与user关系、角色与acl关系）
 * type：1（user）、2（acl）
 *
 * @author xinre
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleMembershipPO {

    private String id;
    private int type;
    private String roleId;
    private String membershipId;
    private String operator;
    private Date operateTime;
    private String operateIp;

}
