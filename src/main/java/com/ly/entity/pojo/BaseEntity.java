package com.ly.entity.pojo;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

/**
 * 基础简单对象
 *
 * @author xinre
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

    private String id;
    private String name;
    private String nameHeadChar;
}
