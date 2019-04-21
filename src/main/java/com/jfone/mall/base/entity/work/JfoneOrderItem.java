package com.jfone.mall.base.entity.work;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`jfone_order_item`")
public class JfoneOrderItem {
    /**
     * 订单子表id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "`oi_user_id`")
    private Integer oiUserId;

    @Column(name = "`oi_order_no`")
    private Long oiOrderNo;

    /**
     * 商品id
     */
    @Column(name = "`oi_product_id`")
    private Integer oiProductId;

    /**
     * 商品名称
     */
    @Column(name = "`oi_product_name`")
    private String oiProductName;

    /**
     * 商品图片地址
     */
    @Column(name = "`oi_product_image`")
    private String oiProductImage;

    /**
     * 生成订单时的商品单价，单位是元,保留两位小数
     */
    @Column(name = "`oi_current_unit_price`")
    private BigDecimal oiCurrentUnitPrice;

    /**
     * 商品数量
     */
    @Column(name = "`oi_quantity`")
    private Integer oiQuantity;

    /**
     * 商品总价,单位是元,保留两位小数
     */
    @Column(name = "`oi_total_price`")
    private BigDecimal oiTotalPrice;

    @Column(name = "`oi_create_time`")
    private Date oiCreateTime;

    @Column(name = "`oi_update_time`")
    private Date oiUpdateTime;

    /**
     * 获取订单子表id
     *
     * @return id - 订单子表id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置订单子表id
     *
     * @param id 订单子表id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return oi_user_id
     */
    public Integer getOiUserId() {
        return oiUserId;
    }

    /**
     * @param oiUserId
     */
    public void setOiUserId(Integer oiUserId) {
        this.oiUserId = oiUserId;
    }

    /**
     * @return oi_order_no
     */
    public Long getOiOrderNo() {
        return oiOrderNo;
    }

    /**
     * @param oiOrderNo
     */
    public void setOiOrderNo(Long oiOrderNo) {
        this.oiOrderNo = oiOrderNo;
    }

    /**
     * 获取商品id
     *
     * @return oi_product_id - 商品id
     */
    public Integer getOiProductId() {
        return oiProductId;
    }

    /**
     * 设置商品id
     *
     * @param oiProductId 商品id
     */
    public void setOiProductId(Integer oiProductId) {
        this.oiProductId = oiProductId;
    }

    /**
     * 获取商品名称
     *
     * @return oi_product_name - 商品名称
     */
    public String getOiProductName() {
        return oiProductName;
    }

    /**
     * 设置商品名称
     *
     * @param oiProductName 商品名称
     */
    public void setOiProductName(String oiProductName) {
        this.oiProductName = oiProductName == null ? null : oiProductName.trim();
    }

    /**
     * 获取商品图片地址
     *
     * @return oi_product_image - 商品图片地址
     */
    public String getOiProductImage() {
        return oiProductImage;
    }

    /**
     * 设置商品图片地址
     *
     * @param oiProductImage 商品图片地址
     */
    public void setOiProductImage(String oiProductImage) {
        this.oiProductImage = oiProductImage == null ? null : oiProductImage.trim();
    }

    /**
     * 获取生成订单时的商品单价，单位是元,保留两位小数
     *
     * @return oi_current_unit_price - 生成订单时的商品单价，单位是元,保留两位小数
     */
    public BigDecimal getOiCurrentUnitPrice() {
        return oiCurrentUnitPrice;
    }

    /**
     * 设置生成订单时的商品单价，单位是元,保留两位小数
     *
     * @param oiCurrentUnitPrice 生成订单时的商品单价，单位是元,保留两位小数
     */
    public void setOiCurrentUnitPrice(BigDecimal oiCurrentUnitPrice) {
        this.oiCurrentUnitPrice = oiCurrentUnitPrice;
    }

    /**
     * 获取商品数量
     *
     * @return oi_quantity - 商品数量
     */
    public Integer getOiQuantity() {
        return oiQuantity;
    }

    /**
     * 设置商品数量
     *
     * @param oiQuantity 商品数量
     */
    public void setOiQuantity(Integer oiQuantity) {
        this.oiQuantity = oiQuantity;
    }

    /**
     * 获取商品总价,单位是元,保留两位小数
     *
     * @return oi_total_price - 商品总价,单位是元,保留两位小数
     */
    public BigDecimal getOiTotalPrice() {
        return oiTotalPrice;
    }

    /**
     * 设置商品总价,单位是元,保留两位小数
     *
     * @param oiTotalPrice 商品总价,单位是元,保留两位小数
     */
    public void setOiTotalPrice(BigDecimal oiTotalPrice) {
        this.oiTotalPrice = oiTotalPrice;
    }

    /**
     * @return oi_create_time
     */
    public Date getOiCreateTime() {
        return oiCreateTime;
    }

    /**
     * @param oiCreateTime
     */
    public void setOiCreateTime(Date oiCreateTime) {
        this.oiCreateTime = oiCreateTime;
    }

    /**
     * @return oi_update_time
     */
    public Date getOiUpdateTime() {
        return oiUpdateTime;
    }

    /**
     * @param oiUpdateTime
     */
    public void setOiUpdateTime(Date oiUpdateTime) {
        this.oiUpdateTime = oiUpdateTime;
    }
}