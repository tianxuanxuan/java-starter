package com.xgit.starter.service;

import com.xgit.starter.entities.PageRequest;
import com.xgit.starter.entities.PageResult;
import com.xgit.starter.entities.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    public PageResult findRoleByPage(PageRequest pageRequest);

    /**
     * 开启事务，插入成功，异常回滚，插入和更新操作都失败
     * 关闭事务，插入成功，更新失败，可能造成数据不一致
     */
    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.REPEATABLE_READ, timeout = 5)
    public void testTransactional(Role updateRole, Role insetRole);
}
