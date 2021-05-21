package com.dlice.hello.common.exception;

import com.dlice.hello.common.model.response.ResultCode;

/**
 * @Date: 2020/9/2 23:51
 * @Author: dlice
 */
public class CustomException extends RuntimeException {
    private ResultCode resultCode;

    public CustomException(ResultCode resultCode) {
        //异常信息为错误代码+异常信息
        super("错误代码：" + resultCode.code() + "错误信息：" + resultCode.message());
        this.resultCode = resultCode;
    }
    public ResultCode getResultCode() {
        return this.resultCode;
    }
}
