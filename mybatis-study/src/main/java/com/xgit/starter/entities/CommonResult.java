package com.xgit.starter.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by tianxuanxuan
 * On 2020-08-26 17:19
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>{
    //404 not found
    private Integer code;
    private String message;
    private T data;
    public CommonResult(Integer code, String message){
        this(code, message, null);
    }
}
