package com.h2t.study.dto;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.JedisPubSub;

/**
 * 自定义JedisPubSub
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2021/01/25 19:59
 */
@Slf4j
public class CustomJedisPubSub extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {
        //do somthing
        log.info("consumer message from channel:{} successfully, msg is:{}", channel, message);
    }
}
