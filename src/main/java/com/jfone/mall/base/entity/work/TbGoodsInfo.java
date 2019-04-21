package com.jfone.mall.base.entity.work;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_goods_info")
public class TbGoodsInfo {
    @Id
    private Integer id;

    @Column(name = "goods_name")
    private String goodsName;

    @Column(name = "goods_description")
    private String goodsDescription;

    @Column(name = "goods_pic")
    private String goodsPic;

    @Column(name = "goods_price")
    private Double goodsPrice;

    @Column(name = "goods_stock")
    private Integer goodsStock;

    @Column(name = "goods_price_off")
    private Double goodsPriceOff;

    @Column(name = "goods_discount")
    private Double goodsDiscount;

    @Column(name = "goods_fatherid")
    private Integer goodsFatherid;

    @Column(name = "goods_parentid")
    private Integer goodsParentid;

    private Integer flag;

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
     * @return goods_name
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * @param goodsName
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * @return goods_description
     */
    public String getGoodsDescription() {
        return goodsDescription;
    }

    /**
     * @param goodsDescription
     */
    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription == null ? null : goodsDescription.trim();
    }

    /**
     * @return goods_pic
     */
    public String getGoodsPic() {
        return goodsPic;
    }

    /**
     * @param goodsPic
     */
    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic == null ? null : goodsPic.trim();
    }

    /**
     * @return goods_price
     */
    public Double getGoodsPrice() {
        return goodsPrice;
    }

    /**
     * @param goodsPrice
     */
    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    /**
     * @return goods_stock
     */
    public Integer getGoodsStock() {
        return goodsStock;
    }

    /**
     * @param goodsStock
     */
    public void setGoodsStock(Integer goodsStock) {
        this.goodsStock = goodsStock;
    }

    /**
     * @return goods_price_off
     */
    public Double getGoodsPriceOff() {
        return goodsPriceOff;
    }

    /**
     * @param goodsPriceOff
     */
    public void setGoodsPriceOff(Double goodsPriceOff) {
        this.goodsPriceOff = goodsPriceOff;
    }

    /**
     * @return goods_discount
     */
    public Double getGoodsDiscount() {
        return goodsDiscount;
    }

    /**
     * @param goodsDiscount
     */
    public void setGoodsDiscount(Double goodsDiscount) {
        this.goodsDiscount = goodsDiscount;
    }

    /**
     * @return goods_fatherid
     */
    public Integer getGoodsFatherid() {
        return goodsFatherid;
    }

    /**
     * @param goodsFatherid
     */
    public void setGoodsFatherid(Integer goodsFatherid) {
        this.goodsFatherid = goodsFatherid;
    }

    /**
     * @return goods_parentid
     */
    public Integer getGoodsParentid() {
        return goodsParentid;
    }

    /**
     * @param goodsParentid
     */
    public void setGoodsParentid(Integer goodsParentid) {
        this.goodsParentid = goodsParentid;
    }

    /**
     * @return flag
     */
    public Integer getFlag() {
        return flag;
    }

    /**
     * @param flag
     */
    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "TbGoodsInfo{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", goodsDescription='" + goodsDescription + '\'' +
                ", goodsPic='" + goodsPic + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsStock=" + goodsStock +
                ", goodsPriceOff=" + goodsPriceOff +
                ", goodsDiscount=" + goodsDiscount +
                ", goodsFatherid=" + goodsFatherid +
                ", goodsParentid=" + goodsParentid +
                ", flag=" + flag +
                '}';
    }
}