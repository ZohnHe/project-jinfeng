package com.jfone.mall.base.entity.work;

import java.util.Date;
import javax.persistence.*;

@Table(name = "jfone_shipping")
public class JfoneShipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "s_user_id")
    private Integer sUserId;

    /**
     * 收货姓名
     */
    @Column(name = "s_receiver_name")
    private String sReceiverName;

    /**
     * 收货固定电话
     */
    @Column(name = "s_receiver_phone")
    private String sReceiverPhone;

    /**
     * 收货移动电话
     */
    @Column(name = "s_receiver_mobile")
    private String sReceiverMobile;

    /**
     * 省份
     */
    @Column(name = "s_receiver_province")
    private String sReceiverProvince;

    /**
     * 城市
     */
    @Column(name = "s_receiver_city")
    private String sReceiverCity;

    /**
     * 区/县
     */
    @Column(name = "s_receiver_district")
    private String sReceiverDistrict;

    /**
     * 详细地址
     */
    @Column(name = "s_receiver_address")
    private String sReceiverAddress;

    /**
     * 邮编
     */
    @Column(name = "s_receiver_zip")
    private String sReceiverZip;

    @Column(name = "s_create_time")
    private Date sCreateTime;

    @Column(name = "s_update_time")
    private Date sUpdateTime;

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
     * @return s_user_id - 用户id
     */
    public Integer getsUserId() {
        return sUserId;
    }

    /**
     * 设置用户id
     *
     * @param sUserId 用户id
     */
    public void setsUserId(Integer sUserId) {
        this.sUserId = sUserId;
    }

    /**
     * 获取收货姓名
     *
     * @return s_receiver_name - 收货姓名
     */
    public String getsReceiverName() {
        return sReceiverName;
    }

    /**
     * 设置收货姓名
     *
     * @param sReceiverName 收货姓名
     */
    public void setsReceiverName(String sReceiverName) {
        this.sReceiverName = sReceiverName == null ? null : sReceiverName.trim();
    }

    /**
     * 获取收货固定电话
     *
     * @return s_receiver_phone - 收货固定电话
     */
    public String getsReceiverPhone() {
        return sReceiverPhone;
    }

    /**
     * 设置收货固定电话
     *
     * @param sReceiverPhone 收货固定电话
     */
    public void setsReceiverPhone(String sReceiverPhone) {
        this.sReceiverPhone = sReceiverPhone == null ? null : sReceiverPhone.trim();
    }

    /**
     * 获取收货移动电话
     *
     * @return s_receiver_mobile - 收货移动电话
     */
    public String getsReceiverMobile() {
        return sReceiverMobile;
    }

    /**
     * 设置收货移动电话
     *
     * @param sReceiverMobile 收货移动电话
     */
    public void setsReceiverMobile(String sReceiverMobile) {
        this.sReceiverMobile = sReceiverMobile == null ? null : sReceiverMobile.trim();
    }

    /**
     * 获取省份
     *
     * @return s_receiver_province - 省份
     */
    public String getsReceiverProvince() {
        return sReceiverProvince;
    }

    /**
     * 设置省份
     *
     * @param sReceiverProvince 省份
     */
    public void setsReceiverProvince(String sReceiverProvince) {
        this.sReceiverProvince = sReceiverProvince == null ? null : sReceiverProvince.trim();
    }

    /**
     * 获取城市
     *
     * @return s_receiver_city - 城市
     */
    public String getsReceiverCity() {
        return sReceiverCity;
    }

    /**
     * 设置城市
     *
     * @param sReceiverCity 城市
     */
    public void setsReceiverCity(String sReceiverCity) {
        this.sReceiverCity = sReceiverCity == null ? null : sReceiverCity.trim();
    }

    /**
     * 获取区/县
     *
     * @return s_receiver_district - 区/县
     */
    public String getsReceiverDistrict() {
        return sReceiverDistrict;
    }

    /**
     * 设置区/县
     *
     * @param sReceiverDistrict 区/县
     */
    public void setsReceiverDistrict(String sReceiverDistrict) {
        this.sReceiverDistrict = sReceiverDistrict == null ? null : sReceiverDistrict.trim();
    }

    /**
     * 获取详细地址
     *
     * @return s_receiver_address - 详细地址
     */
    public String getsReceiverAddress() {
        return sReceiverAddress;
    }

    /**
     * 设置详细地址
     *
     * @param sReceiverAddress 详细地址
     */
    public void setsReceiverAddress(String sReceiverAddress) {
        this.sReceiverAddress = sReceiverAddress == null ? null : sReceiverAddress.trim();
    }

    /**
     * 获取邮编
     *
     * @return s_receiver_zip - 邮编
     */
    public String getsReceiverZip() {
        return sReceiverZip;
    }

    /**
     * 设置邮编
     *
     * @param sReceiverZip 邮编
     */
    public void setsReceiverZip(String sReceiverZip) {
        this.sReceiverZip = sReceiverZip == null ? null : sReceiverZip.trim();
    }

    /**
     * @return s_create_time
     */
    public Date getsCreateTime() {
        return sCreateTime;
    }

    /**
     * @param sCreateTime
     */
    public void setsCreateTime(Date sCreateTime) {
        this.sCreateTime = sCreateTime;
    }

    /**
     * @return s_update_time
     */
    public Date getsUpdateTime() {
        return sUpdateTime;
    }

    /**
     * @param sUpdateTime
     */
    public void setsUpdateTime(Date sUpdateTime) {
        this.sUpdateTime = sUpdateTime;
    }
}