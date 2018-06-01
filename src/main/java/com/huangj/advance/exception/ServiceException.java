package com.huangj.advance.exception;

import com.huangj.advance.common.ErrorCode;

/**
 * @author huangj
 * @Description:    service 层统一异常处理
 * @date 2018/6/1
 */
public class ServiceException extends CommonException{

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(ErrorCode errorCode) {
        super(errorCode);
    }

    public ServiceException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
