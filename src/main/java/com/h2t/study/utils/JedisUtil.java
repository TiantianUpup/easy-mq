package com.h2t.study.utils;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * JedisUtil
 *
 * @author hetiantian
 * @version 1.0
 * @Date 2021/01/23 14:26
 */
@Slf4j
public class JedisUtil {
    private static JedisPool pool = null;

    static {
        //加载配置文件
        InputStream in = JedisUtil.class.getClassLoader().getResourceAsStream("redis.properties");
        Properties pro = new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            log.error("load properties occur exception, exception is:{}", e);
        }

        //获得池子对象
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(Integer.parseInt(pro.get("redis.maxIdle").toString())); //最大闲置个数
        poolConfig.setMaxWaitMillis(Integer.parseInt(pro.get("redis.maxWait").toString())); //最大闲置个数
        poolConfig.setMinIdle(Integer.parseInt(pro.get("redis.minIdle").toString())); //最小闲置个数
        poolConfig.setMaxTotal(Integer.parseInt(pro.get("redis.maxTotal").toString())); //最大连接数
        pool = new JedisPool(poolConfig, pro.getProperty("redis.url"), Integer.parseInt(pro.get("redis.port").toString()));
    }

    /**
     * 获取Jedis资源
     */
    public static Jedis getJedis() {
        return pool.getResource();
    }

    /**
     * 释放Jedis连接
     */
    public void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }

    }
}

