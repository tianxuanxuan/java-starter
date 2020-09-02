package com.xgit.starter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by tianxuanxuan
 * On 2020-09-02 10:06
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageResult {
    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 每页数量
     */
    private Integer pageSize;

    /**
     * 记录总数
     */
    private Long totalSize;

    /**
     * 页码总数
     */
    private Integer totalPages;

    /**
     * 内容
     */
    private List<?> content;
}
