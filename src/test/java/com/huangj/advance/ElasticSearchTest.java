//package com.huangj.advance;
//
//import com.google.common.collect.Lists;
//import com.huangj.advance.dao.StoreInfoDao;
//import com.huangj.advance.dto.StoreInfoDto;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//
///**
// * @author huangj
// * @Description:
// * @date 2018/6/13
// */
//public class ElasticSearchTest extends BaseTest {
//
//    @Autowired
//    StoreInfoDao storeInfoDao;
//
//    @Test
//    public void query(){
//        Iterable<StoreInfoDto> iterable = storeInfoDao.findAll();
//        List<StoreInfoDto> list =  Lists.newArrayList(iterable);
//        System.out.println("size:" + list.size());
//
//        StoreInfoDto storeInfoDto = storeInfoDao.findByStoreNameLike("北京").get();
//        System.out.println("storeInfoDto:" + storeInfoDto);
//    }
//
//    @Test
//    public void index(){
//        StoreInfoDto storeInfoDto = StoreInfoDto.builder()
//                .id(1L)
//                .storeNo("003")
//                .storeName("北京仓")
//                .build();
//        StoreInfoDto result = storeInfoDao.index(storeInfoDto);
//        System.out.println("result:" + result.toString());
//    }
//
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
