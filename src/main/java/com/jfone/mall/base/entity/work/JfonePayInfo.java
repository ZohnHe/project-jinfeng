package com.jfone.mall.base.entity.work;

import java.util.Date;
import javax.persistence.*;

@Table(name = "work..jfone_pay_info")
public class JfonePayInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "pi_user_id")
    private Integer piUserId;

    /**
     * 订单号
     */
    @Column(name = "pi_order_no")
    private Long piOrderNo;

    /**
     * 支付平台:1-支付宝,2-微信
     */
    @Column(name = "pi_pay_platform")
    private Integer piPayPlatform;

    /**
     * 支付宝支付流水号
     */
    @Column(name = "pi_platform_number")
    private String piPlatformNumber;

    /**
     * 支付宝支付状态
     */
    @Column(name = "pi_platform_status")
    private String piPlatformStatus;

    /**
     * 创建时间
     */
    @Column(name = "pi_create_time")
    private Date piCreateTime;

    /**
     * 更新时间
     */
    @Column(name = "pi_update_time")
    private Date piUpdateTime;

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
     * 获取用户id
     *
     * @return pi_user_id - 用户id
     */
    public Integer getPiUserId() {
        return piUserId;
    }

    /**
     * 设置用户id
     *
     * @param piUserId 用户id
     */
    public void setPiUserId(Integer piUserId) {
        this.piUserId = piUserId;
    }

    /**
     * 获取订单号
     *
     * @return pi_order_no - 订单号
     */
    public Long getPiOrderNo() {
        return piOrderNo;
    }

    /**
     * 设置订单号
     *
     * @param piOrderNo 订单号
     */
    public void setPiOrderNo(Long piOrderNo) {
        this.piOrderNo = piOrderNo;
    }

    /**
     * 获取支付平台:1-支付宝,2-微信
     *
     * @return pi_pay_platform - 支付平台:1-支付宝,2-微信
     */
    public Integer getPiPayPlatform() {
        return piPayPlatform;
    }

    /**
     * 设置支付平台:1-支付宝,2-微信
     *
     * @param piPayPlatform 支付平台:1-支付宝,2-微信
     */
    public void setPiPayPlatform(Integer piPayPlatform) {
        this.piPayPlatform = piPayPlatform;
    }

    /**
     * 获取支付宝支付流水号
     *
     * @return pi_platform_number - 支付宝支付流水号
     */
    public String getPiPlatformNumber() {
        return piPlatformNumber;
    }

    /**
     * 设置支付宝支付流水号
     *
     * @param piPlatformNumber 支付宝支付流水号
     */
    public void setPiPlatformNumber(String piPlatformNumber) {
        this.piPlatformNumber = piPlatformNumber == null ? null : piPlatformNumber.trim();
    }

    /**
     * 获取支付宝支付状态
     *
     * @return pi_platform_status - 支付宝支付状态
     */
    public String getPiPlatformStatus() {
        return piPlatformStatus;
    }

    /**
     * 设置支付宝支付状态
     *
     * @param piPlatformStatus 支付宝支付状态
     */
    public void setPiPlatformStatus(String piPlatformStatus) {
        this.piPlatformStatus = piPlatformStatus == null ? null : piPlatformStatus.trim();
    }

    /**
     * 获取创建时间
     *
     * @return pi_create_time - 创建时间
     */
    public Date getPiCreateTime() {
        return piCreateTime;
    }

    /**
     * 设置创建时间
     *
     * @param piCreateTime 创建时间
     */
    public void setPiCreateTime(Date piCreateTime) {
        this.piCreateTime = piCreateTime;
    }

    /**
     * 获取更新时间
     *
     * @return pi_update_time - 更新时间
     */
    public Date getPiUpdateTime() {
        return piUpdateTime;
    }

    /**
     * 设置更新时间
     *
     * @param piUpdateTime 更新时间
     */
    public void setPiUpdateTime(Date piUpdateTime) {
        this.piUpdateTime = piUpdateTime;
    }
}