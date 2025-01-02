package com.dist.interview.core.model.common;

import com.dist.interview.core.App;

public class AppException extends RuntimeException {
    private AppExceptionInfo info;
    public AppException(String code,String message) {
        super(message);
        this.info=new AppExceptionInfo(code, message);
    }

    public AppException(String code,String message, Throwable cause) {
        super(message, cause);
        this.info=new AppExceptionInfo(code, message);
        if(App.getCallInfo().isTechnicalDetails()){
            this.info.fill(this);
        }
    }

    public AppException(String code,String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.info=new AppExceptionInfo(code, message);
        if(App.getCallInfo().isTechnicalDetails()){
            this.info.fill(this);
        }
    }

    public AppExceptionInfo getInfo() {
        return info;
    }
}
