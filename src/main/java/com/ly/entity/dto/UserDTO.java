package com.ly.entity.dto;

import com.ly.entity.pojo.BaseEntity;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author xinre
 */
@Builder
@Accessors(chain = true) // 开启链式风格
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO extends BaseEntity {

    private String code;
    private String deptId;
    private String telephone;
    private String email;
    private int status;
    private String remark;
}
