package com.xgit.starter.entities;

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
public class Role implements Serializable {
    private Long id;
    private String roleName;
    private String note;
}
