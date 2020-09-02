package com.xgit.starter.service;

import com.xgit.starter.entities.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tianxuanxuan
 * On 2020-09-01 14:08
 */
public interface RoleService {
    public List<Role> findRolesByName(String name, String note);
    public List<Role> findRoles(Role role);
    public int updateRole(Role role);
    public List<Role> findRoleByIds(List<Long> ids);
}
