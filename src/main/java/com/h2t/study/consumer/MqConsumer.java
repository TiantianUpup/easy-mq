package com.h2t.study.consumer;

import com.h2t.study.dto.Message;
import com.h2t.study.enums.ErrorCodeEnum;
import com.h2t.study.exception.MqException;
import com.h2t.study.utils.JedisUtil;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.List;

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
     * 非阻塞式消费消息
     */
    public String Consume(Message message) {
        //参数校验
        validateMessageKey(message);
        Jedis jedis = JedisUtil.getJedis();
        String msg = jedis.rpop(message.getKey());
        log.info("consume message successfully, key is:{}, message list is:{}", message.getKey(), message.getMsg());
        return msg;
    }

    /**
     * 阻塞式消费消息
     *
     * @param message
     * @return
     */
    public List<String> bConsume(Message message) {
        //参数校验
        validateMessageKey(message);
        Jedis jedis = JedisUtil.getJedis();
        List<String> msgList = jedis.brpop(message.getKey());
        log.info("consume message successfully, key is:{}, message list is:{}", message.getKey(), message.getMsg());
        return msgList;
    }

    /**
     * 参数校验
     *
     * @param message
     */
    private void validateMessageKey(Message message) {
        if (StringUtils.isBlank(message.getKey())) {
            log.error("consume message param error, message key is blank");
            throw new MqException(ErrorCodeEnum.TNP1001000);
        }
    }
}
