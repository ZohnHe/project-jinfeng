package com.jfone.mall.base.entity.work;

import javax.persistence.*;

@Table(name = "work..jfone_transit_info")
public class JfoneTransitInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "t_outlet_address")
    private String tOutletAddress;

    @Column(name = "t_status")
    private String tStatus;

    @Column(name = "t_delivery_info_id")
    private Integer tDeliveryInfoId;

    @Column(name = "t_sign_info_id")
    private Integer tSignInfoId;

    @Column(name = "t_waybill_id")
    private Integer tWaybillId;

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
     * @return t_outlet_address
     */
    public String gettOutletAddress() {
        return tOutletAddress;
    }

    /**
     * @param tOutletAddress
     */
    public void settOutletAddress(String tOutletAddress) {
        this.tOutletAddress = tOutletAddress == null ? null : tOutletAddress.trim();
    }

    /**
     * @return t_status
     */
    public String gettStatus() {
        return tStatus;
    }

    /**
     * @param tStatus
     */
    public void settStatus(String tStatus) {
        this.tStatus = tStatus == null ? null : tStatus.trim();
    }

    /**
     * @return t_delivery_info_id
     */
    public Integer gettDeliveryInfoId() {
        return tDeliveryInfoId;
    }

    /**
     * @param tDeliveryInfoId
     */
    public void settDeliveryInfoId(Integer tDeliveryInfoId) {
        this.tDeliveryInfoId = tDeliveryInfoId;
    }

    /**
     * @return t_sign_info_id
     */
    public Integer gettSignInfoId() {
        return tSignInfoId;
    }

    /**
     * @param tSignInfoId
     */
    public void settSignInfoId(Integer tSignInfoId) {
        this.tSignInfoId = tSignInfoId;
    }

    /**
     * @return t_waybill_id
     */
    public Integer gettWaybillId() {
        return tWaybillId;
    }

    /**
     * @param tWaybillId
     */
    public void settWaybillId(Integer tWaybillId) {
        this.tWaybillId = tWaybillId;
    }
}