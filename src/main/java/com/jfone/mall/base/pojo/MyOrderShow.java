package com.jfone.mall.base.pojo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 这是我的订单展示的pojo
 */
public class MyOrderShow {

    private String sReceiverName;
    private BigDecimal oPayment;
    private String oCreateTime;
    private Long oOrderNo;

    public Long getoOrderNo() {
        return oOrderNo;
    }

    public void setoOrderNo(Long oOrderNo) {
        this.oOrderNo = oOrderNo;
    }

    public String getsReceiverName() {
        return sReceiverName;
    }

    public void setsReceiverName(String sReceiverName) {
        this.sReceiverName = sReceiverName;
    }

    public BigDecimal getoPayment() {
        return oPayment;
    }

    public void setoPayment(BigDecimal oPayment) {
        this.oPayment = oPayment;
    }

    public String getoCreateTime() {
        return oCreateTime;
    }

    public void setoCreateTime(String oCreateTime) {
        this.oCreateTime = oCreateTime;
    }
}
