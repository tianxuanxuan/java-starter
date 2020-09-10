package com.xgit.starter.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * Created by tianxuanxuan
 * On 2020-09-10 11:49
 */

@Data
@Slf4j
public class MybatisRedisCache implements Cache {
    private String id;

    private RedisTemplate<String, Object> getRedisTemplate(){
        return ApplicationContextHolder.getBean("redisTemplate");
    }


    public MybatisRedisCache(String id){
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        getRedisTemplate().boundHashOps(getId()).put(key, value);
        //设置缓存失效时间，保证数据一致性, 能不能设置key的过期时间而不是id
        getRedisTemplate().expire(getId(), 10, TimeUnit.SECONDS);
        log.info("[结果放入到缓存中: " + key + "=" + value+" ]");
    }

    @Override
    public Object getObject(Object key) {
        Object value = getRedisTemplate().boundHashOps(getId()).get(key);
        log.info("[从缓存中获取了: " + key + "=" + value+" ]");
        return value;
    }

    @Override
    public Object removeObject(Object key) {
        Object value = getRedisTemplate().boundHashOps(getId()).delete(key);
        log.info("[从缓存删除了: " + key + "=" + value+" ]");
        return value;
    }

    @Override
    public void clear() {
        getRedisTemplate().delete(getId());
        log.info("清空缓存!!!");

    }

    @Override
    public int getSize() {
        Long size = getRedisTemplate().boundHashOps(getId()).size();
        return size == null?  0 : size.intValue();
    }
}
