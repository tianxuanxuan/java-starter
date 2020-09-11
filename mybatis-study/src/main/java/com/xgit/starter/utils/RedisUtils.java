package com.xgit.starter.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * Created by tianxuanxuan
 * On 2020-09-09 10:57
 */
@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public boolean set(String key, Object value){
        try{
            Boolean result = redisTemplate.opsForValue().setIfAbsent(key, value,300, TimeUnit.SECONDS);
            return result != null && result;
        }catch (Exception e){
            return false;
        }
    }


    public Boolean delete(String... key){
        if (key == null || key.length == 0){
            return false;
        }

        if (key.length == 1){
            return redisTemplate.delete(key[0]);
        }else {
            Long result = redisTemplate.delete(Arrays.asList(key));
            return result != null && result > 0L;
        }
    }

    public Object get(String key){
        if (key == null){
            return null;
        }
        return redisTemplate.opsForValue().get(key);
    }
}
