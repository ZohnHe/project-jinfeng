package com.jfone.mall.base.entity.work;

import javax.persistence.*;

@Table(name = "work..jfone_role")
public class JfoneRole {
    /**
     * 角色表id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色描述
     */
    @Column(name = "r_description")
    private String rDescription;

    /**
     * 角色关键字
     */
    @Column(name = "r_keyword")
    private String rKeyword;

    /**
     * 角色名称
     */
    @Column(name = "r_name")
    private String rName;

    /**
     * 获取角色表id
     *
     * @return id - 角色表id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置角色表id
     *
     * @param id 角色表id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色描述
     *
     * @return r_description - 角色描述
     */
    public String getrDescription() {
        return rDescription;
    }

    /**
     * 设置角色描述
     *
     * @param rDescription 角色描述
     */
    public void setrDescription(String rDescription) {
        this.rDescription = rDescription == null ? null : rDescription.trim();
    }

    /**
     * 获取角色关键字
     *
     * @return r_keyword - 角色关键字
     */
    public String getrKeyword() {
        return rKeyword;
    }

    /**
     * 设置角色关键字
     *
     * @param rKeyword 角色关键字
     */
    public void setrKeyword(String rKeyword) {
        this.rKeyword = rKeyword == null ? null : rKeyword.trim();
    }

    /**
     * 获取角色名称
     *
     * @return r_name - 角色名称
     */
    public String getrName() {
        return rName;
    }

    /**
     * 设置角色名称
     *
     * @param rName 角色名称
     */
    public void setrName(String rName) {
        this.rName = rName == null ? null : rName.trim();
    }
}