package com.xgit.starter.utils;

import com.github.pagehelper.PageInfo;
import com.xgit.starter.entities.PageRequest;
import com.xgit.starter.entities.PageResult;
import com.xgit.starter.entities.Role;

/**
 * Created by tianxuanxuan
 * On 2020-09-02 10:24
 */
public class PageUtils {
    /**
     * 将分页信息封装到统一的接口
     *
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageInfo<?> pageInfo){
        PageResult result = new PageResult();
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotalPages(pageInfo.getPages());
        result.setTotalSize(pageInfo.getTotal());
        result.setContent(pageInfo.getList());
        return result;
    }
}
