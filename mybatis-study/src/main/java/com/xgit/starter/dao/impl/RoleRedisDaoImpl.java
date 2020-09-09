package com.xgit.starter.dao.impl;

import com.alibaba.fastjson.JSON;
import com.xgit.starter.dao.RoleRedisDao;
import com.xgit.starter.entities.Role;
import com.xgit.starter.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by tianxuanxuan
 * On 2020-09-09 14:13
 */
@Repository
public class RoleRedisDaoImpl implements RoleRedisDao {
    @Autowired
    private RedisUtils redisUtils;

    @Override
    public boolean addRole(Role role) {
        return redisUtils.set(String.valueOf(role.getId()), JSON.toJSONString(role));
    }

    @Override
    public boolean updateRole(Role role) {
        return redisUtils.set(String.valueOf(role.getId()), JSON.toJSONString(role));
    }

    @Override
    public boolean deleteRole(Long id) {
        return redisUtils.delete(String.valueOf(id));
    }

    @Override
    public Role findRoleById(Long id) {
        String result = (String) redisUtils.get(String.valueOf(id));
        return JSON.parseObject(result, Role.class);
    }
}
