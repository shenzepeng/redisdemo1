package com.example.redisdemo1;

import com.example.redisdemo1.pojo.Car;
import com.example.redisdemo1.service.RedisService;
import com.example.redisdemo1.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.UUID;
@Slf4j
@SpringBootTest
class Redisdemo1ApplicationTests {
    @Autowired
    private RedisService service;
    @Test
    void contextLoads() {
//        Car car=new Car();
//        car.setId(1l);
//        car.setColor("红色");
//        car.setLength(10);
//        car.setWidth(2);
//        car.setPrice(200000D);
//        log.warn("需要在redis中添加的对象-{}",car);
//        String key= UUID.randomUUID().toString();
//        service.setMap(key, JsonUtils.objectToJson(car));
        String token="a7a53b37-4750-4012-8cbd-322594c0efec,1,911";
        String value = service.getMap(token);
        System.out.println(value);
//        log.info("从redis中获取了信息,key为-{},所取的结果是-{}",key,value);
//        Car jsonToPojo = JsonUtils.jsonToPojo(value, Car.class);
//        log.info("获取的car对象-{}",jsonToPojo);


    }

}
