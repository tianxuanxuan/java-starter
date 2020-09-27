package com.xgit.starter.dao;

import com.xgit.starter.model.PermissionDto;
import com.xgit.starter.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by tianxuanxuan
 * On 2020-09-27 10:19
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public UserDto getUSerByUsername(String userName){
        String sql = "select * from t_user where username = ?";

        List<UserDto> users = jdbcTemplate.query(sql, new Object[]{userName},
                new BeanPropertyRowMapper<>(UserDto.class));
        if (users.size() == 1){
            return users.get(0);
        }
        return null;
    }

    public List<String> findPermissionByUserId(String userId){
        String sql = "select * from t_permission where id in (\n" +
                "\n" +
                "\tselect permission_id from t_role_permission where role_id in (\n" +
                "\n" +
                "\n" +
                "\tselect role_id from t_user_role where user_id = ? )\n" +
                ")";
        List<PermissionDto> list = jdbcTemplate.query(sql, new Object[]{userId},
                new BeanPropertyRowMapper<>(PermissionDto.class));
        return list.stream()
                .map(PermissionDto::getCode)
                .collect(Collectors.toList());
    }
}

