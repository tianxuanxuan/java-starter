package com.xgit.starter.exception;

/**
 * Created by tianxuanxuan
 * On 2020-09-03 11:33
 */
public interface BaseErrorInfoInterface {
    /** 错误码*/
    Integer getResultCode();

    /** 错误描述*/
    String getResultMsg();
}
