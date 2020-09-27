package com.xgit.starter.service;

import cn.hutool.crypto.digest.BCrypt;
import com.xgit.starter.dao.UserDao;
import com.xgit.starter.model.PermissionDto;
import com.xgit.starter.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tianxuanxuan
 * On 2020-09-27 09:06
 */
@Service
public class SpringDataUserDetialService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = userDao.getUSerByUsername(username);
        if (user == null){
            return null;//返回null，由provider抛异常
        }
        //权限
        List<String> permissions = userDao.findPermissionByUserId(user.getId());
        String[] permissionsArr = new String[permissions.size()];
        permissions.toArray(permissionsArr);

        //将来采用查数据库的方式验证
        return User.withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities(permissionsArr)
                .build();
    }
}
