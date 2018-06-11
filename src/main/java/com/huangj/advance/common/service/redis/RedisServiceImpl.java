//package com.huangj.advance.common.service.redis;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.ListOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.List;
//
///**
// * Author: huangj
// * Description: Redis service 工具类
// * Date: 2018/6/11
// */
//@Service
//public class RedisServiceImpl<HK, T> implements IRedisService<HK, T>{
//
//    @Autowired
//    private RedisTemplate<String, T> redisTemplate;
//
//    @Override
//    public List<T> getList(String key, long start, long end) {
//        return null;
//        //return redisTemplate.opsForList().range(key, start, end);
//
////        try {
////            return redisTemplate.opsForList().range(key, start, end);
////        } catch (Exception e) {
////            //logger.error(String.format(REDIS_SERVICE_MSG,e.getMessage()));
////            return Collections.emptyList();
//        }
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
