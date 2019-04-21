package com.jfone.mall.base.entity.work.resp;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 *  返回给前端界面渲染用的实体
 *  @author Suoron
 *  2019-02-14
 */

public class VoGoodsInfo {

    /**
     * 商品id
     */
    @ApiModelProperty("商品ID")
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分类id,对应mmall_category表的主键
     */
    @ApiModelProperty("商品名称")
    @Column(name = "p_category_id")
    private Integer pCategoryId;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    @Column(name = "p_name")
    private String pName;

    /**
     * 产品主图,url相对地址
     */
    @ApiModelProperty("产品主图,url相对地址")
    @Column(name = "p_main_image")
    private String pMainImage;

    /**
     * 价格,单位-元保留两位小数
     */
    @ApiModelProperty("商品价格")
    @Column(name = "p_price")
    private BigDecimal pPrice;

    /**
     * 库存数量
     */
    @ApiModelProperty("商品库存")
    @Column(name = "p_stock")
    private Integer pStock;

    /**
     * 商品状态.1-在售 2-下架 3-删除
     */
    @ApiModelProperty("商品状态")
    @Column(name = "p_status")
    private Integer pStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty("商品创建时间")
    @Column(name = "p_create_time")
    private Date pCreateTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("商品更新时间")
    @Column(name = "p_update_time")
    private Date pUpdateTime;

    /**
     * 图片地址,json格式,扩展用
     */
/*    @Column(name = "p_sub_images")
    private String pSubImages;*/

    /**
     * 商品详情
     */
    @ApiModelProperty("商品详情")
    @Column(name = "p_detail")
    private String pDetail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getpStatus() {
        return pStatus;
    }

    public void setpStatus(Integer pStatus) {
        this.pStatus = pStatus;
    }

    public Date getpCreateTime() {
        return pCreateTime;
    }

    public void setpCreateTime(Date pCreateTime) {
        this.pCreateTime = pCreateTime;
    }

    public Date getpUpdateTime() {
        return pUpdateTime;
    }

    public void setpUpdateTime(Date pUpdateTime) {
        this.pUpdateTime = pUpdateTime;
    }

    public String getpDetail() {
        return pDetail;
    }

    public void setpDetail(String pDetail) {
        this.pDetail = pDetail;
    }
}
