package com.xgit.starter.controller;

import com.xgit.starter.commons.CommonEnum;
import com.xgit.starter.commons.CommonResult;
import com.xgit.starter.entities.PageRequest;
import com.xgit.starter.entities.PageResult;
import com.xgit.starter.entities.Role;
import com.xgit.starter.service.RoleService;
import com.xgit.starter.utils.Constant;
import com.xgit.starter.utils.RedisLock;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tianxuanxuan
 * On 2020-08-31 17:35
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    private final RedisLock redisLock;

    /**
     * @PathVariable注解用作get请求
     *              URL请求格式：http://localhost:8081/role/getByName/总经理/管理岗位
     *              required = false，同样参数可以不全部传吗？
     * @param name
     * @param note
     * @return
     */
    @GetMapping("/role/getByName/{name}/{note}")
    public CommonResult getRolesByName(@PathVariable(value = "name", required = false) String name,
                                                   @PathVariable(value = "note", required = false) String note){
        List<Role> results =  roleService.findRolesByName(name, note);
        log.info("****查询结果:" + results);
        if (results != null && results.size() > 0){
            return CommonResult.success(results);
        }else {
            return CommonResult.error(CommonEnum.NOT_FOUND);
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
    //@Function("role.getByName1")
    public CommonResult getRolesByName1(@RequestParam(value = "name", required = false)
                                                            String name,
                                                    @RequestParam(value = "note", required = false)
                                                                String note){
        List<Role> results =  roleService.findRolesByName(name, note);
        log.info("****查询结果:" + results);
        if (results != null && results.size() > 0){
            return CommonResult.success(results);
            //return new CommonResult<>(200, "查询数据成功", results);
        }else {
            return CommonResult.error(CommonEnum.NOT_FOUND);
            //return new CommonResult<>(444, "查询失败，没有对应记录 name: " + name);
        }
    }

    /**
     * 用@RequestBody注解，postMan传参时，请求参数必须以json格式放在body中
     * @param role
     * @return
     */
    @PostMapping(value = "/role/get")
    public CommonResult getRoles(Role role){
        log.info("****查询参数:" + role);
        List<Role> results =  roleService.findRoles(role);
        log.info("****查询结果:" + results);
        if (results != null && results.size() > 0){
            return CommonResult.success(results);
        }else {
            return CommonResult.error(CommonEnum.NOT_FOUND);
        }
    }

    @PostMapping(value = "/role/update")
    public CommonResult updateRole(Role role){
        int result = roleService.updateRole(role);
        if (result > 0){
            return CommonResult.success(null);
        }else {
            return CommonResult.error(CommonEnum.NOT_FOUND);
        }
    }

    @GetMapping(value = "/role/findByIds")
    public CommonResult findRoleByIds(@RequestParam List<Long> ids){
        log.info("****查询参数:" + ids);
        List<Role> results = roleService.findRoleByIds(ids);
        log.info("****查询结果:" + results);
        if (results != null && results.size() > 0){
            return CommonResult.success(results);
        }else {
            return CommonResult.error(CommonEnum.NOT_FOUND);
        }
    }

    @PostMapping(value = "/role/findByPage")
    public CommonResult findRoleByPage(@RequestBody PageRequest request){
        log.info("****查询参数:" + request);
        PageResult results = roleService.findRoleByPage(request);
        log.info("****查询结果:" + results);
        if (results != null){
            return CommonResult.success(results);
        }else {
            return CommonResult.error(CommonEnum.NOT_FOUND);
        }
    }

    @GetMapping(value = "/role/lock")
    public CommonResult distributeLock(@RequestParam(value = "taskId", required = false)
                                              String taskId) {
        boolean lock = redisLock.lock(taskId, Constant.REDIS_EXPIRE_TIME);
        if (lock){
            return CommonResult.success("-----抢到锁，执行任务......");
        }else {
            return CommonResult.success("-----没有获得锁，请稍后重试-----");
        }
    }
}
