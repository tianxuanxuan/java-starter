package com.xgit.starter.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xgit.starter.entities.Role;
import com.xgit.starter.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
 * Created by tianxuanxuan
 * On 2020-09-12 20:31
 */

@Service("")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService{
}
