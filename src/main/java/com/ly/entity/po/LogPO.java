package com.ly.entity.po;

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
public class LogPO{

    private String id;
    private String targetId;
    private String oldValue;
    private String newValue;
    private int type;
    private int status;
    private String operator;
    private Date operateTime;
    private String operateIp;

}
