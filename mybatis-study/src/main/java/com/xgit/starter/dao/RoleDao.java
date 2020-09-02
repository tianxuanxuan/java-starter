package com.xgit.starter.dao;

import com.xgit.starter.entities.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tianxuanxuan
 * On 2020-08-31 17:17
 */
@Mapper
public interface RoleDao {
    public List<Role> findRolesByName(@Param("roleName") String name,
                                      @Param("note") String note);
    public List<Role> findRoles(Role role);

    public int updateRole(Role role);

    public List<Role> findRoleByIds(@Param("ids") List<Long> ids);
}
