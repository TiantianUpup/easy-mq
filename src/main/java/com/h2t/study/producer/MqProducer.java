package com.h2t.study.producer;

import com.h2t.study.dto.Message;
import com.h2t.study.enums.ErrorCodeEnum;
import com.h2t.study.exception.MqException;
import com.h2t.study.utils.JedisUtil;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

/**
 * MqProducer
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2021/01/23 14:31
 */
@Data
@Slf4j
@Builder
public class MqProducer {
    /**
     * 发送消息
     *
     * @param message
     */
    public void send(Message message) {
        //参数校验
        if (StringUtils.isBlank(message.getKey())
                || StringUtils.isBlank(message.getMsg())) {
            log.error("produce message param error, message key or msg is blank, message:{}", message);
            throw new MqException(ErrorCodeEnum.TNP1001000);
        }

        Jedis jedis = JedisUtil.getJedis();
        Long size = jedis.lpush(message.getKey(), message.getMsg());
        log.info("producer send msg successfully, msgKey is:{}, msg is:{}", message.getKey(), message.getMsg());
    }
}
