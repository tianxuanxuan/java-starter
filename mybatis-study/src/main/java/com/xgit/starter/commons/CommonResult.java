package com.xgit.starter.commons;

import com.xgit.starter.exception.BaseErrorInfoInterface;
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
public class CommonResult{
    //404 not found
    private Integer code;
    private String message;
    private Object data;
    public CommonResult(Integer code, String message){
        this(code, message, null);
    }

    public CommonResult(BaseErrorInfoInterface errorInfo) {
        this(errorInfo.getResultCode(), errorInfo.getResultMsg(), null);
    }

    /**
     * 成功
     */
    public static CommonResult success(Object data) {
        CommonResult result = new CommonResult();
        result.setCode(CommonEnum.SUCCESS.getResultCode());
        result.setMessage(CommonEnum.SUCCESS.getResultMsg());
        result.setData(data);
        return result;
    }

    /**
     * 失败
     */
    public static CommonResult error(Integer code, String msg){
        return new CommonResult(code, msg);
    }

    /**
     * 失败
     */
    public static CommonResult error(BaseErrorInfoInterface errorInfo) {
        CommonResult result = new CommonResult();
        result.setCode(errorInfo.getResultCode());
        result.setMessage(errorInfo.getResultMsg());
        return result;
    }
}
