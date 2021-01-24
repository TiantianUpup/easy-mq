package com.h2t.study.consumer;

import com.h2t.study.dto.Message;
import com.h2t.study.enums.ErrorCodeEnum;
import com.h2t.study.exception.MqException;
import com.h2t.study.utils.JedisUtil;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

import javax.xml.ws.BindingType;

/**
 * MqConsumer
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2021/01/23 14:32
 */
@Slf4j
@Builder
public class MqConsumer {
    /**
     * 消费消息
     *
     * @param message
     * @return
     */
    public String consume(Message message) {
        //参数校验
        if (StringUtils.isBlank(message.getKey())) {
            log.error("consume message param error, message key is blank");
            throw new MqException(ErrorCodeEnum.TNP1001000);
        }
        Jedis jedis = JedisUtil.getJedis();
        String msg = jedis.rpop(message.getKey());
        log.info("consume message successfully, key is:{}, message is:{}", message.getKey(), message.getMsg());
        return msg;
    }
}
