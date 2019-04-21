package com.jfone.mall.base.entity.work.ext;

import com.jfone.mall.base.entity.work.JfoneCart;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * com.jfone.mall.base.entity.work
 * Author:lris DELL
 *
 * @Date:Created in 11:34 2019/2/21
 */
public class JfoneShopCartProduct extends JfoneCart {

    private Integer pCategoryId;

    /**
     * 商品名称
     */
    private String pName;

    /**
     * 商品副标题
     */
    private String pSubtitle;

    /**
     * 产品主图,url相对地址
     */
    private String pMainImage;

    /**
     * 价格,单位-元保留两位小数
     */
    private BigDecimal pPrice;

    /**
     * 库存数量
     */
    private Integer pStock;

    /**
     * 图片地址,json格式,扩展用
     */
    private String pSubImages;

    /**
     * 商品详情
     */
    private String pDetail;

    public Integer getpCategoryId() {
        return pCategoryId;
    }

    public void setpCategoryId(Integer pCategoryId) {
        this.pCategoryId = pCategoryId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpSubtitle() {
        return pSubtitle;
    }

    public void setpSubtitle(String pSubtitle) {
        this.pSubtitle = pSubtitle;
    }

    public String getpMainImage() {
        return pMainImage;
    }

    public void setpMainImage(String pMainImage) {
        this.pMainImage = pMainImage;
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

    public String getpSubImages() {
        return pSubImages;
    }

    public void setpSubImages(String pSubImages) {
        this.pSubImages = pSubImages;
    }

    public String getpDetail() {
        return pDetail;
    }

    public void setpDetail(String pDetail) {
        this.pDetail = pDetail;
    }
}
