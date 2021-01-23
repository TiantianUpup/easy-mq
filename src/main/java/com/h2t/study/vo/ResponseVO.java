package com.h2t.study.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ResponseVO
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2021/01/23 14:58
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVO<T> {
    private String errorCode;

    private String errorMsg;

    private T data;
}
