package com.xgit.starter.dao;

import com.xgit.starter.entities.Role;

/**
 * Created by tianxuanxuan
 * On 2020-09-09 14:07
 */
public interface RoleRedisDao {
    public boolean addRole(Role role);
    public boolean updateRole(Role role);
    public boolean deleteRole(Long id);
    public Role findRoleById(Long id);
}
