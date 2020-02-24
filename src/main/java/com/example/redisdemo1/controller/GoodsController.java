package com.example.redisdemo1.controller;

import com.example.redisdemo1.request.GoodsRequest;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class GoodsController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @PostMapping
    public String addGoods(@RequestHeader String token,@RequestBody GoodsRequest request){
        if (checkToken(token)){
            return "参数不合法";
        }
        return "添加成功";
    }

    private boolean checkToken(String token){
        String s = stringRedisTemplate.opsForValue().get(token);
       return StringUtils.isEmpty(s);
    }
}
