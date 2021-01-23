package com.h2t.study.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * ErrorCodeEnum
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2021/01/23 15:00
 */
@Getter
@AllArgsConstructor
public enum ErrorCodeEnum {
    TNP1001000("TNP1001000", "param error");

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;
}
