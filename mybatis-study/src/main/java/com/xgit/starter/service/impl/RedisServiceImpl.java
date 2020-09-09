package com.xgit.starter.service.impl;

import com.xgit.starter.dao.RoleRedisDao;
import com.xgit.starter.entities.Role;
import com.xgit.starter.service.RedisService;
import com.xgit.starter.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by tianxuanxuan
 * On 2020-09-09 10:58
 */

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RoleRedisDao roleRedisDao;

    @Override
    public boolean addRole(Role role) {
        return roleRedisDao.addRole(role);
    }

    @Override
    public boolean updateRole(Role role) {
        return roleRedisDao.updateRole(role);
    }

    @Override
    public boolean deleteRole(Long id) {
        return roleRedisDao.deleteRole(id);
    }

    @Override
    public Role findRoleById(Long id) {
        return roleRedisDao.findRoleById(id);
    }
}
