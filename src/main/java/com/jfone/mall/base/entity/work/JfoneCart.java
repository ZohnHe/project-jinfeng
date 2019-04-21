package com.jfone.mall.base.entity.work;

import com.jfone.mall.base.entity.work.ext.JfoneShopCartProduct;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "jfone_cart")
public class JfoneCart {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_user_id")
    private Integer cUserId;


    /**
     * 商品id
     */
    @Column(name = "c_product_id")
    private Integer cProductId;

    /**
     * 数量
     */
    @Column(name = "c_quantity")
    private Integer cQuantity;

    /**
     * 是否选择,1=已勾选,0=未勾选
     */
    @Column(name = "c_checked")
    private Integer cChecked;

    /**
     * 创建时间
     */
    @Column(name = "c_create_time")
    private Date cCreateTime;

    /**
     * 更新时间
     */
    @Column(name = "c_update_time")
    private Date cUpdateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return c_user_id
     */
    public Integer getcUserId() {
        return cUserId;
    }

    /**
     * @param cUserId
     */
    public void setcUserId(Integer cUserId) {
        this.cUserId = cUserId;
    }

    /**
     * 获取商品id
     *
     * @return c_product_id - 商品id
     */
    public Integer getcProductId() {
        return cProductId;
    }

    /**
     * 设置商品id
     *
     * @param cProductId 商品id
     */
    public void setcProductId(Integer cProductId) {
        this.cProductId = cProductId;
    }

    /**
     * 获取数量
     *
     * @return c_quantity - 数量
     */
    public Integer getcQuantity() {
        return cQuantity;
    }

    /**
     * 设置数量
     *
     * @param cQuantity 数量
     */
    public void setcQuantity(Integer cQuantity) {
        this.cQuantity = cQuantity;
    }

    /**
     * 获取是否选择,1=已勾选,0=未勾选
     *
     * @return c_checked - 是否选择,1=已勾选,0=未勾选
     */
    public Integer getcChecked() {
        return cChecked;
    }

    /**
     * 设置是否选择,1=已勾选,0=未勾选
     *
     * @param cChecked 是否选择,1=已勾选,0=未勾选
     */
    public void setcChecked(Integer cChecked) {
        this.cChecked = cChecked;
    }

    /**
     * 获取创建时间
     *
     * @return c_create_time - 创建时间
     */
    public Date getcCreateTime() {
        return cCreateTime;
    }

    /**
     * 设置创建时间
     *
     * @param cCreateTime 创建时间
     */
    public void setcCreateTime(Date cCreateTime) {
        this.cCreateTime = cCreateTime;
    }

    /**
     * 获取更新时间
     *
     * @return c_update_time - 更新时间
     */
    public Date getcUpdateTime() {
        return cUpdateTime;
    }

    /**
     * 设置更新时间
     *
     * @param cUpdateTime 更新时间
     */
    public void setcUpdateTime(Date cUpdateTime) {
        this.cUpdateTime = cUpdateTime;
    }
}