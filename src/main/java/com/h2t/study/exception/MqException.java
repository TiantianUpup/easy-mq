package com.h2t.study.exception;

import com.h2t.study.enums.ErrorCodeEnum;
import lombok.Data;

/**
 * MqException
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2021/01/23 15:02
 */
@Data
public class MqException extends RuntimeException {
    private ErrorCodeEnum errorCodeEnum;

    public MqException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getErrorMsg());
        this.errorCodeEnum = errorCodeEnum;
    }
}
