package com.huangj.advance.service.impl;

import com.huangj.advance.config.RedisConfig;
import com.huangj.advance.mapper.StoreInfoTkMapper;
import com.huangj.advance.model.StoreInfoModel;
import com.huangj.advance.service.StoreInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huangj
 * @Description: 仓库信息 service impl
 * @date 2018/6/6
 */
@Service
public class StoreInfoServiceImpl implements StoreInfoService{

    @Autowired
    StoreInfoTkMapper storeInfoTkMapper;

    @Cacheable(value = RedisConfig.ONE_HOUR_CACHE,keyGenerator = "wiselyKeyGenerator")
    @Override
    public List<StoreInfoModel> queryAllStoreInfo() {
        System.out.println("============= queryAllStoreInfo =============，方法被调用");
        return storeInfoTkMapper.selectAll();
    }
}














