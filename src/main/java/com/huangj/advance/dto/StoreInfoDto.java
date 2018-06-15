package com.huangj.advance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;


/**
 * @author huangj
 * @Description: es 测试 DTO
 * @date 2018/6/15
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "advance",type = "store")
public class StoreInfoDto {

    private Long id;

    private String storeNo;

    private String storeName;

}
