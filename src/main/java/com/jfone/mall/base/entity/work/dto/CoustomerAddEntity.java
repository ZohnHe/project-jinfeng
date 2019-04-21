package com.jfone.mall.base.entity.work.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *  商品添加请求输入参数
 *
 */

public class CoustomerAddEntity {

    @ApiModelProperty("用户ID")
    private Integer coustomerIds;         //: "4"
    @ApiModelProperty("用户名称")
    @NotEmpty(message = "用户名称不能为空!")
    private String cUsername;         //: "太平饼干"
    @ApiModelProperty("用户昵称")
    private String cNickname;        //: "4"
    @ApiModelProperty("用户邮箱")
    private String cEmail;       //: "23"
    @ApiModelProperty("用户状态")
    private String cStatus;
    @ApiModelProperty("用户头像图片")
    private String cImage;


    public String getcImage() {
        return cImage;
    }

    public void setcImage(String cImage) {
        this.cImage = cImage;
    }

    public Integer getCoustomerIdx() {
        return coustomerIds;
    }

    public void setCoustomerIdx(Integer coustomerIds) {
        coustomerIds = coustomerIds;
    }

    public String getcUsername() {
        return cUsername;
    }

    public void setcUsername(String cUsername) {
        this.cUsername = cUsername;
    }

    public String getcNickname() {
        return cNickname;
    }

    public void setcNickname(String cNickname) {
        this.cNickname = cNickname;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcStatus() {
        return cStatus;
    }

    public void setcStatus(String cStatus) {
        this.cStatus = cStatus;
    }
}
