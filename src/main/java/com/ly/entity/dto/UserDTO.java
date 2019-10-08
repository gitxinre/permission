package com.ly.entity.dto;

import com.ly.entity.pojo.BaseEntity;
import lombok.*;

/**
 * @author xinre
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends BaseEntity {

    private String code;
    private String deptId;
    private String telephone;
    private String email;
    private int status;
    private String remark;
}
