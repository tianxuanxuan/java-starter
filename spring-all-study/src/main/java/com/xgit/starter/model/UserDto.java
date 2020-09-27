package com.xgit.starter.model;

import lombok.Data;

/**
 * Created by tianxuanxuan
 * On 2020-09-27 10:14
 */
@Data
public class UserDto {
    private String id;
    private String username;
    private String password;
    private String fullname;
    private String mobile;
}
