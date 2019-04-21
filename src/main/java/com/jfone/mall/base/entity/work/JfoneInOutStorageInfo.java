package com.jfone.mall.base.entity.work;

import javax.persistence.*;
import java.util.Date;

@Table(name = "`jfone_in_out_storage_info`")
public class JfoneInOutStorageInfo {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "`c_address`")
    private String cAddress;

    @Column(name = "`c_description`")
    private String cDescription;

    @Column(name = "`c_operation`")
    private String cOperation;

    @Column(name = "`c_transit_info_id`")
    private Integer cTransitInfoId;

    @Column(name = "`c_in_out_index`")
    private String cInOutIndex;

    @Column(name = "`flag`")
    private int flag=1;

    @Column(name = "`time`")
    private Date time;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        if(flag!=null){
            this.flag=1;
        }else {
            this.flag = flag;
        }   }


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
     * @return c_address
     */
    public String getcAddress() {
        return cAddress;
    }

    /**
     * @param cAddress
     */
    public void setcAddress(String cAddress) {
        this.cAddress = cAddress == null ? null : cAddress.trim();
    }

    /**
     * @return c_description
     */
    public String getcDescription() {
        return cDescription;
    }

    /**
     * @param cDescription
     */
    public void setcDescription(String cDescription) {
        this.cDescription = cDescription == null ? null : cDescription.trim();
    }

    /**
     * @return c_operation
     */
    public String getcOperation() {
        return cOperation;
    }

    /**
     * @param cOperation
     */
    public void setcOperation(String cOperation) {
        this.cOperation = cOperation == null ? null : cOperation.trim();
    }

    /**
     * @return c_transit_info_id
     */
    public Integer getcTransitInfoId() {
        return cTransitInfoId;
    }

    /**
     * @param cTransitInfoId
     */
    public void setcTransitInfoId(Integer cTransitInfoId) {
        this.cTransitInfoId = cTransitInfoId;
    }

    /**
     * @param cInOutIndex
     */
    public void setcInOutIndex(String cInOutIndex) {
        this.cInOutIndex = cInOutIndex;
    }

    /**
     * @return c_in_out_index
     */
    public String getcInOutIndex() {
        return cInOutIndex;
    }
}