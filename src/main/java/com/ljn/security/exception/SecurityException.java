package com.ljn.security.exception;

import com.ljn.security.common.REnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecurityException extends RuntimeException {
    private Integer code;
    private String msg;
    public SecurityException(REnum rEnum) {
        code = rEnum.getCode();
        msg = rEnum.getMessage();
    }
}
