package com.xgit.starter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tianxuanxuan
 * On 2020-09-02 10:02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest {
    /**
     * 当前页码
     */
    private Integer pageNum;

    /**
     * 每页数量
     */
    private Integer pageSize;

}
