package com.jfone.mall.base.entity.work;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "jfone_product")
public class JfoneProduct {
    /**
     * 商品id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 分类id,对应mmall_category表的主键
     */
    @Column(name = "p_category_id")
    private Integer pCategoryId;

    /**
     * 商品名称
     */
    @Column(name = "p_name")
    private String pName;

    /**
     * 商品副标题
     */
    @Column(name = "p_subtitle")
    private String pSubtitle;

    /**
     * 产品主图,url相对地址
     */
    @Column(name = "p_main_image")
    private String pMainImage;

    /**
     * 价格,单位-元保留两位小数
     */
    @Column(name = "p_price")
    private BigDecimal pPrice;

    /**
     * 库存数量
     */
    @Column(name = "p_stock")
    private Integer pStock;

    /**
     * 商品状态.1-在售 2-下架 3-删除
     */
    @Column(name = "p_status")
    private Integer pStatus;

    /**
     * 创建时间
     */
    @Column(name = "p_create_time")
    private Date pCreateTime;

    /**
     * 更新时间
     */
    @Column(name = "p_update_time")
    private Date pUpdateTime;

    /**
     * 图片地址,json格式,扩展用
     */
    @Column(name = "p_sub_images")
    private String pSubImages;

    /**
     * 商品详情
     */
    @Column(name = "p_detail")
    private String pDetail;

    /**
     * 获取商品id
     *
     * @return id - 商品id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置商品id
     *
     * @param id 商品id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取分类id,对应mmall_category表的主键
     *
     * @return p_category_id - 分类id,对应mmall_category表的主键
     */
    public Integer getpCategoryId() {
        return pCategoryId;
    }

    /**
     * 设置分类id,对应mmall_category表的主键
     *
     * @param pCategoryId 分类id,对应mmall_category表的主键
     */
    public void setpCategoryId(Integer pCategoryId) {
        this.pCategoryId = pCategoryId;
    }

    /**
     * 获取商品名称
     *
     * @return p_name - 商品名称
     */
    public String getpName() {
        return pName;
    }

    /**
     * 设置商品名称
     *
     * @param pName 商品名称
     */
    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    /**
     * 获取商品副标题
     *
     * @return p_subtitle - 商品副标题
     */
    public String getpSubtitle() {
        return pSubtitle;
    }

    /**
     * 设置商品副标题
     *
     * @param pSubtitle 商品副标题
     */
    public void setpSubtitle(String pSubtitle) {
        this.pSubtitle = pSubtitle == null ? null : pSubtitle.trim();
    }

    /**
     * 获取产品主图,url相对地址
     *
     * @return p_main_image - 产品主图,url相对地址
     */
    public String getpMainImage() {
        return pMainImage;
    }

    /**
     * 设置产品主图,url相对地址
     *
     * @param pMainImage 产品主图,url相对地址
     */
    public void setpMainImage(String pMainImage) {
        this.pMainImage = pMainImage == null ? null : pMainImage.trim();
    }

    /**
     * 获取价格,单位-元保留两位小数
     *
     * @return p_price - 价格,单位-元保留两位小数
     */
    public BigDecimal getpPrice() {
        return pPrice;
    }

    /**
     * 设置价格,单位-元保留两位小数
     *
     * @param pPrice 价格,单位-元保留两位小数
     */
    public void setpPrice(BigDecimal pPrice) {
        this.pPrice = pPrice;
    }

    /**
     * 获取库存数量
     *
     * @return p_stock - 库存数量
     */
    public Integer getpStock() {
        return pStock;
    }

    /**
     * 设置库存数量
     *
     * @param pStock 库存数量
     */
    public void setpStock(Integer pStock) {
        this.pStock = pStock;
    }

    /**
     * 获取商品状态.1-在售 2-下架 3-删除
     *
     * @return p_status - 商品状态.1-在售 2-下架 3-删除
     */
    public Integer getpStatus() {
        return pStatus;
    }

    /**
     * 设置商品状态.1-在售 2-下架 3-删除
     *
     * @param pStatus 商品状态.1-在售 2-下架 3-删除
     */
    public void setpStatus(Integer pStatus) {
        this.pStatus = pStatus;
    }

    /**
     * 获取创建时间
     *
     * @return p_create_time - 创建时间
     */
    public Date getpCreateTime() {
        return pCreateTime;
    }

    /**
     * 设置创建时间
     *
     * @param pCreateTime 创建时间
     */
    public void setpCreateTime(Date pCreateTime) {
        this.pCreateTime = pCreateTime;
    }

    /**
     * 获取更新时间
     *
     * @return p_update_time - 更新时间
     */
    public Date getpUpdateTime() {
        return pUpdateTime;
    }

    /**
     * 设置更新时间
     *
     * @param pUpdateTime 更新时间
     */
    public void setpUpdateTime(Date pUpdateTime) {
        this.pUpdateTime = pUpdateTime;
    }

    /**
     * 获取图片地址,json格式,扩展用
     *
     * @return p_sub_images - 图片地址,json格式,扩展用
     */
    public String getpSubImages() {
        return pSubImages;
    }

    /**
     * 设置图片地址,json格式,扩展用
     *
     * @param pSubImages 图片地址,json格式,扩展用
     */
    public void setpSubImages(String pSubImages) {
        this.pSubImages = pSubImages == null ? null : pSubImages.trim();
    }

    /**
     * 获取商品详情
     *
     * @return p_detail - 商品详情
     */
    public String getpDetail() {
        return pDetail;
    }

    /**
     * 设置商品详情
     *
     * @param pDetail 商品详情
     */
    public void setpDetail(String pDetail) {
        this.pDetail = pDetail == null ? null : pDetail.trim();
    }
}