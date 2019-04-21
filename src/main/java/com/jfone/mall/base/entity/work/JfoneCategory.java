package com.jfone.mall.base.entity.work;

import java.util.Date;
import javax.persistence.*;

@Table(name = "work..jfone_category")
public class JfoneCategory {
    /**
     * 类别Id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 父类别id当id=0时说明是根节点,一级类别
     */
    @Column(name = "ca_parent_id")
    private Integer caParentId;

    /**
     * 类别名称
     */
    @Column(name = "ca_name")
    private String caName;

    /**
     * 类别状态1-正常,2-已废弃
     */
    @Column(name = "ca_status")
    private Boolean caStatus;

    /**
     * 排序编号,同类展示顺序,数值相等则自然排序
     */
    @Column(name = "ca_sort_order")
    private Integer caSortOrder;

    /**
     * 创建时间
     */
    @Column(name = "ca_create_time")
    private Date caCreateTime;

    /**
     * 更新时间
     */
    @Column(name = "ca_update_time")
    private Date caUpdateTime;

    /**
     * 获取类别Id
     *
     * @return id - 类别Id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置类别Id
     *
     * @param id 类别Id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取父类别id当id=0时说明是根节点,一级类别
     *
     * @return ca_parent_id - 父类别id当id=0时说明是根节点,一级类别
     */
    public Integer getCaParentId() {
        return caParentId;
    }

    /**
     * 设置父类别id当id=0时说明是根节点,一级类别
     *
     * @param caParentId 父类别id当id=0时说明是根节点,一级类别
     */
    public void setCaParentId(Integer caParentId) {
        this.caParentId = caParentId;
    }

    /**
     * 获取类别名称
     *
     * @return ca_name - 类别名称
     */
    public String getCaName() {
        return caName;
    }

    /**
     * 设置类别名称
     *
     * @param caName 类别名称
     */
    public void setCaName(String caName) {
        this.caName = caName == null ? null : caName.trim();
    }

    /**
     * 获取类别状态1-正常,2-已废弃
     *
     * @return ca_status - 类别状态1-正常,2-已废弃
     */
    public Boolean getCaStatus() {
        return caStatus;
    }

    /**
     * 设置类别状态1-正常,2-已废弃
     *
     * @param caStatus 类别状态1-正常,2-已废弃
     */
    public void setCaStatus(Boolean caStatus) {
        this.caStatus = caStatus;
    }

    /**
     * 获取排序编号,同类展示顺序,数值相等则自然排序
     *
     * @return ca_sort_order - 排序编号,同类展示顺序,数值相等则自然排序
     */
    public Integer getCaSortOrder() {
        return caSortOrder;
    }

    /**
     * 设置排序编号,同类展示顺序,数值相等则自然排序
     *
     * @param caSortOrder 排序编号,同类展示顺序,数值相等则自然排序
     */
    public void setCaSortOrder(Integer caSortOrder) {
        this.caSortOrder = caSortOrder;
    }

    /**
     * 获取创建时间
     *
     * @return ca_create_time - 创建时间
     */
    public Date getCaCreateTime() {
        return caCreateTime;
    }

    /**
     * 设置创建时间
     *
     * @param caCreateTime 创建时间
     */
    public void setCaCreateTime(Date caCreateTime) {
        this.caCreateTime = caCreateTime;
    }

    /**
     * 获取更新时间
     *
     * @return ca_update_time - 更新时间
     */
    public Date getCaUpdateTime() {
        return caUpdateTime;
    }

    /**
     * 设置更新时间
     *
     * @param caUpdateTime 更新时间
     */
    public void setCaUpdateTime(Date caUpdateTime) {
        this.caUpdateTime = caUpdateTime;
    }
}