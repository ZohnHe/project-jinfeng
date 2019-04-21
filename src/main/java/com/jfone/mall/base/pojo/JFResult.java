package com.jfone.mall.base.pojo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.ir.annotations.Ignore;

import java.math.BigDecimal;
import java.util.List;

/**
 *自定义创建订单时返回的result
 */
public class JFResult {

    @ApiModelProperty("成功状态：1=成功 0=失败")
    private String success;
    @ApiModelProperty("返回订单号")
    private Long oOrderNo;
    @ApiModelProperty("返回订单总金额")
    private BigDecimal total;

    public Long getoOrderNo() {
        return oOrderNo;
    }

    public void setoOrderNo(Long oOrderNo) {
        this.oOrderNo = oOrderNo;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
