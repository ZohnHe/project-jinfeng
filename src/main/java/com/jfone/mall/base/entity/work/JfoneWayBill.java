package com.jfone.mall.base.entity.work;

import javax.persistence.*;

@Table(name = "work..jfone_way_bill")
public class JfoneWayBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "w_shipping_id")
    private Integer wShippingId;

    @Column(name = "w_order_id")
    private Integer wOrderId;

    @Column(name = "w_sign_status")
    private String wSignStatus;

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
     * @return w_shipping_id
     */
    public Integer getwShippingId() {
        return wShippingId;
    }

    /**
     * @param wShippingId
     */
    public void setwShippingId(Integer wShippingId) {
        this.wShippingId = wShippingId;
    }

    /**
     * @return w_order_id
     */
    public Integer getwOrderId() {
        return wOrderId;
    }

    /**
     * @param wOrderId
     */
    public void setwOrderId(Integer wOrderId) {
        this.wOrderId = wOrderId;
    }

    /**
     * @return w_sign_status
     */
    public String getwSignStatus() {
        return wSignStatus;
    }

    /**
     * @param wSignStatus
     */
    public void setwSignStatus(String wSignStatus) {
        this.wSignStatus = wSignStatus == null ? null : wSignStatus.trim();
    }
}