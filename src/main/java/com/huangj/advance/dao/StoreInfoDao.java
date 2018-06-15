package com.huangj.advance.dao;

import com.huangj.advance.dto.StoreInfoDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

/**
 * @author huangj
 * @version V1.0
 * @Title:
 * @Description:
 * @date 2018/6/15
 */
public interface StoreInfoDao extends ElasticsearchRepository<StoreInfoDto,Long> {

    Optional<StoreInfoDto> findByStoreNameLike(String storeName);
}
