package com.xgit.starter.exception;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by tianxuanxuan
 * On 2020-09-03 11:26
 */
@Data
public class BizException extends RuntimeException{

    /** 错误码*/
    protected Integer errorCode;

    /**错误信息*/
    protected String errorMsg;

    public BizException(){
        super();
    }

    public BizException(BaseErrorInfoInterface errorInfoInterface){
        super(String.valueOf(errorInfoInterface.getResultCode()));
        this.errorCode = errorInfoInterface.getResultCode();
        this.errorMsg = errorInfoInterface.getResultMsg();
    }

    public BizException(BaseErrorInfoInterface errorInfoInterface, Throwable cause){
        super(String.valueOf(errorInfoInterface.getResultCode()));
        this.errorCode = errorInfoInterface.getResultCode();
        this.errorMsg = errorInfoInterface.getResultMsg();
    }

    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BizException(Integer errorCode, String errorMsg) {
        super(String.valueOf(errorCode));
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(Integer errorCode, String errorMsg, Throwable cause) {
        super(String.valueOf(errorCode), cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
