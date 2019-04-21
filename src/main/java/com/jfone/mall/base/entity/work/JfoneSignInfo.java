package com.jfone.mall.base.entity.work;

import java.util.Date;
import javax.persistence.*;

@Table(name = "work..jfone_sign_info")
public class JfoneSignInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "s_description")
    private String sDescription;

    @Column(name = "s_error_remark")
    private String sErrorRemark;

    @Column(name = "s_sign_name")
    private String sSignName;

    @Column(name = "s_sign_time")
    private Date sSignTime;

    @Column(name = "s_sign_type")
    private String sSignType;

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
     * @return s_description
     */
    public String getsDescription() {
        return sDescription;
    }

    /**
     * @param sDescription
     */
    public void setsDescription(String sDescription) {
        this.sDescription = sDescription == null ? null : sDescription.trim();
    }

    /**
     * @return s_error_remark
     */
    public String getsErrorRemark() {
        return sErrorRemark;
    }

    /**
     * @param sErrorRemark
     */
    public void setsErrorRemark(String sErrorRemark) {
        this.sErrorRemark = sErrorRemark == null ? null : sErrorRemark.trim();
    }

    /**
     * @return s_sign_name
     */
    public String getsSignName() {
        return sSignName;
    }

    /**
     * @param sSignName
     */
    public void setsSignName(String sSignName) {
        this.sSignName = sSignName == null ? null : sSignName.trim();
    }

    /**
     * @return s_sign_time
     */
    public Date getsSignTime() {
        return sSignTime;
    }

    /**
     * @param sSignTime
     */
    public void setsSignTime(Date sSignTime) {
        this.sSignTime = sSignTime;
    }

    /**
     * @return s_sign_type
     */
    public String getsSignType() {
        return sSignType;
    }

    /**
     * @param sSignType
     */
    public void setsSignType(String sSignType) {
        this.sSignType = sSignType == null ? null : sSignType.trim();
    }
}