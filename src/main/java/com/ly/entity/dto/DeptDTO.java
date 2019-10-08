package com.ly.entity.dto;

import com.ly.entity.pojo.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author xinre
 */
@Getter
@Setter
@ToString
public class DeptDTO extends BaseEntity {

    private String pId;
    private int orderId;
    private String remark;

}
