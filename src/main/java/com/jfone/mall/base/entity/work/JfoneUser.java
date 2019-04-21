package com.jfone.mall.base.entity.work;

import java.util.Date;
import javax.persistence.*;

@Table(name = "work..jfone_user")
public class JfoneUser {
    /**
     * 用户表id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 后台登录_用户名
     */
    @Column(name = "u_username")
    private String uUsername;

    /**
     * 后台登录_用户密码，MD5加密
     */
    @Column(name = "u_password")
    private String uPassword;

    /**
     * 用户真实姓名
     */
    @Column(name = "u_nickname")
    private String uNickname;

    /**
     * 注册使用邮箱
     */
    @Column(name = "u_email")
    private String uEmail;

    /**
     * 手机号码
     */
    @Column(name = "u_phone")
    private String uPhone;

    /**
     * 找回密码问题
     */
    @Column(name = "u_question")
    private String uQuestion;

    /**
     * 找回密码答案
     */
    @Column(name = "u_answer")
    private String uAnswer;

    /**
     * 管理人员角色id
     */
    @Column(name = "u_roleid")
    private Integer uRoleid;

    /**
     * 创建时间
     */
    @Column(name = "u_create_time")
    private Date uCreateTime;

    /**
     * 最后一次更新时间
     */
    @Column(name = "u_update_time")
    private Date uUpdateTime;

    /**
     * 获取用户表id
     *
     * @return id - 用户表id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户表id
     *
     * @param id 用户表id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取后台登录_用户名
     *
     * @return u_username - 后台登录_用户名
     */
    public String getuUsername() {
        return uUsername;
    }

    /**
     * 设置后台登录_用户名
     *
     * @param uUsername 后台登录_用户名
     */
    public void setuUsername(String uUsername) {
        this.uUsername = uUsername == null ? null : uUsername.trim();
    }

    /**
     * 获取后台登录_用户密码，MD5加密
     *
     * @return u_password - 后台登录_用户密码，MD5加密
     */
    public String getuPassword() {
        return uPassword;
    }

    /**
     * 设置后台登录_用户密码，MD5加密
     *
     * @param uPassword 后台登录_用户密码，MD5加密
     */
    public void setuPassword(String uPassword) {
        this.uPassword = uPassword == null ? null : uPassword.trim();
    }

    /**
     * 获取用户真实姓名
     *
     * @return u_nickname - 用户真实姓名
     */
    public String getuNickname() {
        return uNickname;
    }

    /**
     * 设置用户真实姓名
     *
     * @param uNickname 用户真实姓名
     */
    public void setuNickname(String uNickname) {
        this.uNickname = uNickname == null ? null : uNickname.trim();
    }

    /**
     * 获取注册使用邮箱
     *
     * @return u_email - 注册使用邮箱
     */
    public String getuEmail() {
        return uEmail;
    }

    /**
     * 设置注册使用邮箱
     *
     * @param uEmail 注册使用邮箱
     */
    public void setuEmail(String uEmail) {
        this.uEmail = uEmail == null ? null : uEmail.trim();
    }

    /**
     * 获取手机号码
     *
     * @return u_phone - 手机号码
     */
    public String getuPhone() {
        return uPhone;
    }

    /**
     * 设置手机号码
     *
     * @param uPhone 手机号码
     */
    public void setuPhone(String uPhone) {
        this.uPhone = uPhone == null ? null : uPhone.trim();
    }

    /**
     * 获取找回密码问题
     *
     * @return u_question - 找回密码问题
     */
    public String getuQuestion() {
        return uQuestion;
    }

    /**
     * 设置找回密码问题
     *
     * @param uQuestion 找回密码问题
     */
    public void setuQuestion(String uQuestion) {
        this.uQuestion = uQuestion == null ? null : uQuestion.trim();
    }

    /**
     * 获取找回密码答案
     *
     * @return u_answer - 找回密码答案
     */
    public String getuAnswer() {
        return uAnswer;
    }

    /**
     * 设置找回密码答案
     *
     * @param uAnswer 找回密码答案
     */
    public void setuAnswer(String uAnswer) {
        this.uAnswer = uAnswer == null ? null : uAnswer.trim();
    }

    /**
     * 获取管理人员角色id
     *
     * @return u_roleid - 管理人员角色id
     */
    public Integer getuRoleid() {
        return uRoleid;
    }

    /**
     * 设置管理人员角色id
     *
     * @param uRoleid 管理人员角色id
     */
    public void setuRoleid(Integer uRoleid) {
        this.uRoleid = uRoleid;
    }

    /**
     * 获取创建时间
     *
     * @return u_create_time - 创建时间
     */
    public Date getuCreateTime() {
        return uCreateTime;
    }

    /**
     * 设置创建时间
     *
     * @param uCreateTime 创建时间
     */
    public void setuCreateTime(Date uCreateTime) {
        this.uCreateTime = uCreateTime;
    }

    /**
     * 获取最后一次更新时间
     *
     * @return u_update_time - 最后一次更新时间
     */
    public Date getuUpdateTime() {
        return uUpdateTime;
    }

    /**
     * 设置最后一次更新时间
     *
     * @param uUpdateTime 最后一次更新时间
     */
    public void setuUpdateTime(Date uUpdateTime) {
        this.uUpdateTime = uUpdateTime;
    }
}