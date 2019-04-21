package com.jfone.mall.base.entity.work;

import java.util.Date;
import javax.persistence.*;

@Table(name = "jfone_coustomer")
public class JfoneCoustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "c_username")
    private String cUsername;

    @Column(name = "c_password")
    private String cPassword;

    @Column(name = "c_nickname")
    private String cNickname;

    @Column(name = "c_email")
    private String cEmail;

    @Column(name = "c_question")
    private String cQuestion;

    @Column(name = "c_answer")
    private String cAnswer;

    @Column(name = "c_create_time")
    private Date cCreateTime;

    @Column(name = "c_update_time")
    private Date cUpdateTime;

    @Column(name = "`c_status`")
    private String cStatus;

    @Column(name = "`c_image`")
    private String cImage;

    public String getcStatus() {
        return cStatus;
    }

    public void setcStatus(String cStatus) {
        this.cStatus = cStatus;
    }

    public String getcImage() {
        return cImage;
    }

    public void setcImage(String cImage) {
        this.cImage = cImage;
    }

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
     * @return c_username
     */
    public String getcUsername() {
        return cUsername;
    }

    /**
     * @param cUsername
     */
    public void setcUsername(String cUsername) {
        this.cUsername = cUsername == null ? null : cUsername.trim();
    }

    /**
     * @return c_password
     */
    public String getcPassword() {
        return cPassword;
    }

    /**
     * @param cPassword
     */
    public void setcPassword(String cPassword) {
        this.cPassword = cPassword == null ? null : cPassword.trim();
    }

    /**
     * @return c_nickname
     */
    public String getcNickname() {
        return cNickname;
    }

    /**
     * @param cNickname
     */
    public void setcNickname(String cNickname) {
        this.cNickname = cNickname == null ? null : cNickname.trim();
    }

    /**
     * @return c_email
     */
    public String getcEmail() {
        return cEmail;
    }

    /**
     * @param cEmail
     */
    public void setcEmail(String cEmail) {
        this.cEmail = cEmail == null ? null : cEmail.trim();
    }

    /**
     * @return c_question
     */
    public String getcQuestion() {
        return cQuestion;
    }

    /**
     * @param cQuestion
     */
    public void setcQuestion(String cQuestion) {
        this.cQuestion = cQuestion == null ? null : cQuestion.trim();
    }

    /**
     * @return c_answer
     */
    public String getcAnswer() {
        return cAnswer;
    }

    /**
     * @param cAnswer
     */
    public void setcAnswer(String cAnswer) {
        this.cAnswer = cAnswer == null ? null : cAnswer.trim();
    }

    /**
     * @return c_create_time
     */
    public Date getcCreateTime() {
        return cCreateTime;
    }

    /**
     * @param cCreateTime
     */
    public void setcCreateTime(Date cCreateTime) {
        this.cCreateTime = cCreateTime;
    }

    /**
     * @return c_update_time
     */
    public Date getcUpdateTime() {
        return cUpdateTime;
    }

    /**
     * @param cUpdateTime
     */
    public void setcUpdateTime(Date cUpdateTime) {
        this.cUpdateTime = cUpdateTime;
    }
}