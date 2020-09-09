package com.xgit.starter.service;

import com.xgit.starter.entities.Role;

/**
 * Created by tianxuanxuan
 * On 2020-09-09 10:57
 */
public interface RedisService {
    public boolean addRole(Role role);
    public boolean updateRole(Role role);
    public boolean deleteRole(Long id);
    public Role findRoleById(Long id);
}
