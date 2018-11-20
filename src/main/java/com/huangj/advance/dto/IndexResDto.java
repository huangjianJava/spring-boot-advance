package com.huangj.advance.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author huangj
 * @version V1.0
 * @Title:
 * @Description: 首页 res DTO
 * @date 2018/11/14
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IndexResDto {

    /**
     * 累计
     */
    @ApiModelProperty(value = "总销量")
    private long totalSales;

    @ApiModelProperty(value = "总金额")
    private BigDecimal totalAmounts = BigDecimal.ZERO;

    @ApiModelProperty(value = "总品牌数量")
    private int totalBrands;

    @ApiModelProperty(value = "总分类数量")
    private int totalClasses;

    @ApiModelProperty(value = "采购商品总数")
    private int totalGoods;

    @ApiModelProperty(value = "采购金额总数")
    private int totalMoney;

    @ApiModelProperty(value = "在库数量")
    private BigDecimal totalCount = BigDecimal.ZERO;

    @ApiModelProperty(value = "在库成本")
    private BigDecimal totalCostInStock = BigDecimal.ZERO;

    @ApiModelProperty(value = "平均在库时长")
    private int averageTimeInStock;

    @ApiModelProperty(value = "库存周转率")
    private Double inventoryTurnover = 0.0;

    /**
     * 商品报表
     */
    @ApiModelProperty(value = "当天新增sku")
    private int todayProductAddNum;

    @ApiModelProperty(value = "当天新增品类")
    private int todayClassAddNum;

    @ApiModelProperty(value = "当天新增品牌")
    private int todayBrandAddNum;

    /**
     * 采购报表
     */
    @ApiModelProperty(value = "当天采购件数")
    private int todayPurchaseAddNum;

    @ApiModelProperty(value = "当天采购金额")
    private int todayPurchasePrice;

    /**
     * 销售报表
     */
    @ApiModelProperty(value = "当天销售笔数")
    private long sellNum;

    @ApiModelProperty(value = "当天销售总金额")
    private BigDecimal sellMoney = BigDecimal.ZERO;

    @ApiModelProperty(value = "当天销售退货件数")
    private long refundNum;

    /**
     * 入库报表
     */
    @ApiModelProperty(value = "入库数量")
    private long storeImportNum;

    /**
     * 出库报表
     */
    @ApiModelProperty(value = "出库数量")
    private long storeExportNum;

}