package com.xgit.starter.controller;

import com.xgit.starter.dao.RoleDao;
import com.xgit.starter.entities.CommonResult;
import com.xgit.starter.entities.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tianxuanxuan
 * On 2020-08-31 17:35
 */
@RestController
@Slf4j
public class RoleController {
    @Autowired
    private RoleDao roleDao;


    /**
     * @PathVariable注解用作get请求
     *              URL请求格式：http://localhost:8081/role/getByName/总经理/管理岗位
     *              required = false，同样参数可以不全部传吗？
     * @param name
     * @param note
     * @return
     */
    @GetMapping("/role/getByName/{name}/{note}")
    public CommonResult<List<Role>> getRolesByName(@PathVariable(value = "name", required = false) String name,
                                                   @PathVariable(value = "note", required = false) String note){
        List<Role> results =  roleDao.findRolesByName(name, note);
        log.info("****查询结果:" + results);
        if (results != null && results.size() > 0){
            return new CommonResult<>(200, "查询数据成功", results);
        }else {
            return new CommonResult<>(444, "查询失败，没有对应记录 name: " + name);
        }
    }

    /**
     * @RequestParam 注解用作get传参
     *               url请求格式：http://localhost:8081/role/getByName1?name=总经理&note=管理岗位
     *               由于required=false，参数不用全传
     * @param name
     * @param note
     * @return
     */
    @GetMapping("/role/getByName1")
    public CommonResult<List<Role>> getRolesByName1(@RequestParam(value = "name", required = false) String name,
                                                   @RequestParam(value = "note", required = false) String note){
        List<Role> results =  roleDao.findRolesByName(name, note);
        log.info("****查询结果:" + results);
        if (results != null && results.size() > 0){
            return new CommonResult<>(200, "查询数据成功", results);
        }else {
            return new CommonResult<>(444, "查询失败，没有对应记录 name: " + name);
        }
    }

    @PostMapping(value = "/role/get")
    public CommonResult<List<Role>> getRoles(Role role){
        log.info("****查询参数:" + role);
        List<Role> results =  roleDao.findRoles(role);
        log.info("****查询结果:" + results);
        if (results != null && results.size() > 0){
            return new CommonResult<>(200, "查询数据成功", results);
        }else {
            return new CommonResult<>(444, "查询失败，没有对应记录");
        }
    }

    /**
     * 使用@RequestBody注解，postMan传参时，请求参数必须以json格式放在body中
     * @param role
     * @return
     */
    @PostMapping(value = "/role/create")
    public CommonResult<Role> createRoles(@RequestBody Role role){
        log.info("****接收参数:" + role);
        return new CommonResult<Role>(200, "接收参数成功", role);
    }
}
