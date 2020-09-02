package com.xgit.starter.service.impl;

import com.xgit.starter.dao.RoleDao;
import com.xgit.starter.entities.Role;
import com.xgit.starter.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tianxuanxuan
 * On 2020-09-01 14:08
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findRolesByName(String name, String note) {
        return roleDao.findRolesByName(name, note);
    }

    @Override
    public List<Role> findRoles(Role role) {
        return roleDao.findRoles(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleDao.updateRole(role);
    }

    @Override
    public List<Role> findRoleByIds(List<Long> ids) {
        return roleDao.findRoleByIds(ids);
    }
}
