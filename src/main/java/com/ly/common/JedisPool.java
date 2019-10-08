package com.ly.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @author xinre
 */
@Slf4j
//@Service
public class JedisPool {

    @Autowired
    private ShardedJedisPool shardedJedisPool;


}
