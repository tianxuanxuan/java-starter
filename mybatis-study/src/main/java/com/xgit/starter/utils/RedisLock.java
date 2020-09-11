
package com.xgit.starter.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by tianxuanxuan
 * On 2020-09-11 10:31
 */
@Component
public class RedisLock {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 获取锁
     */
    public boolean lock(String lockId, long expireTime){
        Boolean isLock = redisTemplate.opsForValue().setIfAbsent(lockId, "lock",expireTime, TimeUnit.MILLISECONDS);
        return isLock != null && isLock;
    }

    /**
     * 释放锁
     */
    public boolean releaseLock(String lockId){
        Boolean isUnLock = redisTemplate.delete(lockId);
        return isUnLock != null && isUnLock;
    }
}
