package com.jfone.mall.base.entity.work;

import javax.persistence.*;

@Table(name = "work..jfone_permission")
public class JfonePermission {
    /**
     * 权限表id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 权限描述
     */
    @Column(name = "p_description")
    private String pDescription;

    /**
     * 权限关键字
     */
    @Column(name = "p_keyword")
    private String pKeyword;

    /**
     * 权限名
     */
    @Column(name = "p_name")
    private String pName;

    /**
     * 获取权限表id
     *
     * @return id - 权限表id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置权限表id
     *
     * @param id 权限表id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取权限描述
     *
     * @return p_description - 权限描述
     */
    public String getpDescription() {
        return pDescription;
    }

    /**
     * 设置权限描述
     *
     * @param pDescription 权限描述
     */
    public void setpDescription(String pDescription) {
        this.pDescription = pDescription == null ? null : pDescription.trim();
    }

    /**
     * 获取权限关键字
     *
     * @return p_keyword - 权限关键字
     */
    public String getpKeyword() {
        return pKeyword;
    }

    /**
     * 设置权限关键字
     *
     * @param pKeyword 权限关键字
     */
    public void setpKeyword(String pKeyword) {
        this.pKeyword = pKeyword == null ? null : pKeyword.trim();
    }

    /**
     * 获取权限名
     *
     * @return p_name - 权限名
     */
    public String getpName() {
        return pName;
    }

    /**
     * 设置权限名
     *
     * @param pName 权限名
     */
    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }
}