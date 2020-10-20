package com.xgit.starter.entities;

import lombok.Data;

import java.sql.Date;

/**
 * @author xgxx tianxx
 * @date 2020-10-20 13:56:53
 */
@Data
public class User {
    private Long id;

    private String name;

    private Integer age;

    private String email;

    private Long managerId;

    private Date createTime;
}
