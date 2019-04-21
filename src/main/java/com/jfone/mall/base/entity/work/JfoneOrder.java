package com.jfone.mall.base.entity.work;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`jfone_order`")
public class JfoneOrder {
    /**
     * 订单id
     */
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单号
     */
    @Column(name = "`o_order_no`")
    private Long oOrderNo;

    /**
     * 用户id
     */
    @Column(name = "`o_user_id`")
    private Integer oUserId;

    @Column(name = "`o_shipping_id`")
    private Integer oShippingId;

    /**
     * 实际付款金额,单位是元,保留两位小数
     */
    @Column(name = "`o_payment`")
    private BigDecimal oPayment;

    /**
     * 支付类型,1-在线支付
     */
    @Column(name = "`o_payment_type`")
    private Integer oPaymentType;

    /**
     * 运费,单位是元
     */
    @Column(name = "`o_postage`")
    private Integer oPostage;

    /**
     * 订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭
     */
    @Column(name = "`o_status`")
    private Integer oStatus;

    /**
     * 支付时间
     */
    @Column(name = "`o_payment_time`")
    private Date oPaymentTime;

    /**
     * 发货时间
     */
    @Column(name = "`o_send_time`")
    private Date oSendTime;

    /**
     * 交易完成时间
     */
    @Column(name = "`o_end_time`")
    private Date oEndTime;

    /**
     * 交易关闭时间
     */
    @Column(name = "`o_close_time`")
    private Date oCloseTime;

    /**
     * 创建时间
     */
    @Column(name = "`o_create_time`")
    private Date oCreateTime;

    /**
     * 更新时间
     */
    @Column(name = "`o_update_time`")
    private Date oUpdateTime;

    /**
     * 获取订单id
     *
     * @return id - 订单id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置订单id
     *
     * @param id 订单id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取订单号
     *
     * @return o_order_no - 订单号
     */
    public Long getoOrderNo() {
        return oOrderNo;
    }

    /**
     * 设置订单号
     *
     * @param oOrderNo 订单号
     */
    public void setoOrderNo(Long oOrderNo) {
        this.oOrderNo = oOrderNo;
    }

    /**
     * 获取用户id
     *
     * @return o_user_id - 用户id
     */
    public Integer getoUserId() {
        return oUserId;
    }

    /**
     * 设置用户id
     *
     * @param oUserId 用户id
     */
    public void setoUserId(Integer oUserId) {
        this.oUserId = oUserId;
    }

    /**
     * @return o_shipping_id
     */
    public Integer getoShippingId() {
        return oShippingId;
    }

    /**
     * @param oShippingId
     */
    public void setoShippingId(Integer oShippingId) {
        this.oShippingId = oShippingId;
    }

    /**
     * 获取实际付款金额,单位是元,保留两位小数
     *
     * @return o_payment - 实际付款金额,单位是元,保留两位小数
     */
    public BigDecimal getoPayment() {
        return oPayment;
    }

    /**
     * 设置实际付款金额,单位是元,保留两位小数
     *
     * @param oPayment 实际付款金额,单位是元,保留两位小数
     */
    public void setoPayment(BigDecimal oPayment) {
        this.oPayment = oPayment;
    }

    /**
     * 获取支付类型,1-在线支付
     *
     * @return o_payment_type - 支付类型,1-在线支付
     */
    public Integer getoPaymentType() {
        return oPaymentType;
    }

    /**
     * 设置支付类型,1-在线支付
     *
     * @param oPaymentType 支付类型,1-在线支付
     */
    public void setoPaymentType(Integer oPaymentType) {
        this.oPaymentType = oPaymentType;
    }

    /**
     * 获取运费,单位是元
     *
     * @return o_postage - 运费,单位是元
     */
    public Integer getoPostage() {
        return oPostage;
    }

    /**
     * 设置运费,单位是元
     *
     * @param oPostage 运费,单位是元
     */
    public void setoPostage(Integer oPostage) {
        this.oPostage = oPostage;
    }

    /**
     * 获取订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭
     *
     * @return o_status - 订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭
     */
    public Integer getoStatus() {
        return oStatus;
    }

    /**
     * 设置订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭
     *
     * @param oStatus 订单状态:0-已取消-10-未付款，20-已付款，40-已发货，50-交易成功，60-交易关闭
     */
    public void setoStatus(Integer oStatus) {
        this.oStatus = oStatus;
    }

    /**
     * 获取支付时间
     *
     * @return o_payment_time - 支付时间
     */
    public Date getoPaymentTime() {
        return oPaymentTime;
    }

    /**
     * 设置支付时间
     *
     * @param oPaymentTime 支付时间
     */
    public void setoPaymentTime(Date oPaymentTime) {
        this.oPaymentTime = oPaymentTime;
    }

    /**
     * 获取发货时间
     *
     * @return o_send_time - 发货时间
     */
    public Date getoSendTime() {
        return oSendTime;
    }

    /**
     * 设置发货时间
     *
     * @param oSendTime 发货时间
     */
    public void setoSendTime(Date oSendTime) {
        this.oSendTime = oSendTime;
    }

    /**
     * 获取交易完成时间
     *
     * @return o_end_time - 交易完成时间
     */
    public Date getoEndTime() {
        return oEndTime;
    }

    /**
     * 设置交易完成时间
     *
     * @param oEndTime 交易完成时间
     */
    public void setoEndTime(Date oEndTime) {
        this.oEndTime = oEndTime;
    }

    /**
     * 获取交易关闭时间
     *
     * @return o_close_time - 交易关闭时间
     */
    public Date getoCloseTime() {
        return oCloseTime;
    }

    /**
     * 设置交易关闭时间
     *
     * @param oCloseTime 交易关闭时间
     */
    public void setoCloseTime(Date oCloseTime) {
        this.oCloseTime = oCloseTime;
    }

    /**
     * 获取创建时间
     *
     * @return o_create_time - 创建时间
     */
    public Date getoCreateTime() {
        return oCreateTime;
    }

    /**
     * 设置创建时间
     *
     * @param oCreateTime 创建时间
     */
    public void setoCreateTime(Date oCreateTime) {
        this.oCreateTime = oCreateTime;
    }

    /**
     * 获取更新时间
     *
     * @return o_update_time - 更新时间
     */
    public Date getoUpdateTime() {
        return oUpdateTime;
    }

    /**
     * 设置更新时间
     *
     * @param oUpdateTime 更新时间
     */
    public void setoUpdateTime(Date oUpdateTime) {
        this.oUpdateTime = oUpdateTime;
    }
}