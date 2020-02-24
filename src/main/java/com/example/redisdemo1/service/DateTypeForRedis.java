package com.example.redisdemo1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.HashMap;
import java.util.Set;

@Slf4j
public class DateTypeForRedis {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //key value的数据结构
    public void setKeyValue(String key,String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }
    public String getKeyValue(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    //hash类型
    public boolean setHashKey(String key){
        return stringRedisTemplate.hasKey(key);
    }

    //list类型
    public void addList(String key,String value){
        stringRedisTemplate.opsForList().leftPush(key, value);
    }
    public String getList(String key){
        return stringRedisTemplate.opsForList().rightPop(key);
    }

    //set
    public void addSet(String value){
        stringRedisTemplate.opsForSet().add(value);
    }
    public String getSet(String value){
        return stringRedisTemplate.opsForSet().pop(value);
    }

    public void addZset(String key,String value,Double num){
        stringRedisTemplate.opsForZSet().add(key,value,num);
    }

    public RedisOperations<String, String> getZset(){
        return stringRedisTemplate.opsForZSet().getOperations();
    }

}
