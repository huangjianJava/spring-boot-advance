package com.huangj.advance;

import com.huangj.advance.common.service.RedisService;
import com.huangj.advance.dto.PersonConfig;
import com.huangj.advance.mapper.StoreInfoMapper;
import com.huangj.advance.mapper.StoreInfoTkMapper;
import com.huangj.advance.model.StoreInfoModel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * @author huangj
 * @Description:
 * @date 2018/5/25
 */
public class DemoBaseTest extends BaseTest {

    @Value("${person.account}")
    String account;

    @Autowired
    PersonConfig personConfig;

    @Autowired
    @Qualifier("druidDataSource")
    DataSource dataSource;

    @Autowired
    StoreInfoMapper storeInfoMapper;

    @Autowired
    StoreInfoTkMapper storeInfoTkMapper;

    @Autowired
    private RedisService redisService;

    @Test
    public void testRedis(){
//        boolean setSuccess = redisService.setObject("two","测试一下");
//        System.out.println("setSuccess:" + setSuccess);

        //List<StoreInfoModel> storeInfos = storeInfoTkMapper.selectAll();
//        List<String> names = Arrays.asList("小米1","小哈1","1测试hello");
//        boolean setSuccess = redisService.setObject("tt",names);
//        //boolean setSuccess = redisService.setList("storeInfos",storeInfos);
//        System.out.println("setSuccess:" + setSuccess);

        List<Object> test = redisService.getList("storeInfos",0,-1);
        StoreInfoModel model = (StoreInfoModel)test.get(0);

    }

    @Test
    public void testMybatis(){
        StoreInfoModel storeInfoModel = storeInfoTkMapper.selectAll().get(0);
        System.out.println("name:" + storeInfoModel.getStoreName());

        long size = storeInfoMapper.countStoreInfo();
        System.out.println("account:" + size);
    }

    @Test
    public void testDataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
    }

    @Test
    public void testOne(){
        System.out.println("account:" + account);
        System.out.println("personConfig:" + personConfig);
    }

}
