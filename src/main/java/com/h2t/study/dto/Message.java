package com.h2t.study.dto;

import lombok.Builder;
import lombok.Data;

/**
 * Message DTO
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2021/01/23 14:51
 */
@Data
@Builder
public class Message {
    private String key;

    private String msg;
}
