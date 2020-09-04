package com.xgit.starter.exception;

import com.xgit.starter.commons.CommonEnum;
import com.xgit.starter.commons.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tianxuanxuan
 * On 2020-09-02 11:40
 *
 * 全局异常捕获
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理业务异常
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public CommonResult exceptionHandler(BizException e){
        log.error("发生业务异常，原因是：{}：", e.getErrorCode());
        return CommonResult.error(e.getErrorCode(), e.getMessage());
    }

    /**
     * 处理空指针异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public CommonResult exceptionHandler(NullPointerException e){
        log.error("发生空指针异常！原因是:", e);
        return CommonResult.error(CommonEnum.BODY_NOT_MATCH);
    }

    /**
     * 处理其他异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public CommonResult exceptionHandler(Exception e){
        log.error("未知异常！原因是:", e);
        return CommonResult.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }
}
