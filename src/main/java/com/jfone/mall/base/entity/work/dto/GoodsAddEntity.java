package com.jfone.mall.base.entity.work.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import java.math.BigDecimal;

/**
 *  商品添加请求输入参数
 *
 */

public class GoodsAddEntity {

    @ApiModelProperty("商品ID")
    private Integer goodsIdx;         //: "4"
    @ApiModelProperty("商品描述")
    private String pDetail;  //: "亿滋 饼干太平梳打奶盐味100g办公室休闲零食茶点"
    @ApiModelProperty("商品名称")
    @NotEmpty(message = "商品名称不能为空!")
    private String pName;         //: "太平饼干"
    @Min(value = 0,message = "商品价格不能为空!")
    @ApiModelProperty("商品价格")
    private BigDecimal pPrice;        //: "4"
    @ApiModelProperty("商品库存")
    private Integer pStock;       //: "23"
    @ApiModelProperty("商品图片")
    private String pMainImage;
    @ApiModelProperty("商品类别ID")
    private Integer pCategoryId;


    public Integer getGoodsIdx() {
        return goodsIdx;
    }

    public void setGoodsIdx(Integer goodsIdx) {
        this.goodsIdx = goodsIdx;
    }

    public Integer getpCategoryId() {
        return pCategoryId;
    }

    public void setpCategoryId(Integer pCategoryId) {
        this.pCategoryId = pCategoryId;
    }

    public String getpDetail() {
        return pDetail;
    }

    public void setpDetail(String pDetail) {
        this.pDetail = pDetail;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public BigDecimal getpPrice() {
        return pPrice;
    }

    public void setpPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    public Integer getpStock() {
        return pStock;
    }

    public void setpStock(Integer pStock) {
        this.pStock = pStock;
    }

    public String getpMainImage() {
        return pMainImage;
    }

    public void setpMainImage(String pMainImage) {
        this.pMainImage = pMainImage;
    }
}
