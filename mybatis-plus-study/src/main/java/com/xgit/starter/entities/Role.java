package com.xgit.starter.entities;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by tianxuanxuan
 * On 2020-08-31 17:14
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("role")
public class Role implements Serializable {
    //指定主键
    @TableId
    private Long id;
    //指定对应数据库的哪一列
    @TableField("role_name")
    private String roleName;
    private String note;

    //排除数据库中不用的字段
    @TableField(exist = false)
    private String remarkInfo;
}
