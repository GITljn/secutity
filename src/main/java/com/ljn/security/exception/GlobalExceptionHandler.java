package com.ljn.security.exception;

import com.ljn.security.common.R;
import com.ljn.security.common.REnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 可以捕获所有controller中的异常，将异常信息展示给用户
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 指定触发该方法的异常类型，按异常匹配度决定执行哪个异常
    // 最好不要配置Exception.class，因为其他异常出现后没有异常信息，如果要配置，就输出异常信息
//    @ExceptionHandler(Exception.class)
//    public R error(Exception exception) {
//        exception.printStackTrace();
//        return R.error().codeAndMsg(REnum.ERROR);
//    }

    // 常用于手动抛出异常，并将异常信息展示给用户
    @ExceptionHandler(SecurityException.class)
    public R error(SecurityException exception) {
        return R.error().code(exception.getCode()).msg(exception.getMsg());
    }

//    在同一个函数内对不同类型的异常进行处理
//    @ExceptionHandler(Exception.class)
//    public R exceptionHandler(Exception exception) {
//        if (exception instanceof GlobalException) {
//            GlobalException e = (GlobalException) exception;
//            return R.error(e.getREnum());
//        } else if (exception instanceof BindException) {
//            BindException e = (BindException) exception;
//            R r = R.error(REnum.BIND_ERROR);
//            r.setMessage("参数校验异常: " + e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
//            return r;
//        }
//        return R.error(REnum.ERROR);
//    }
}
