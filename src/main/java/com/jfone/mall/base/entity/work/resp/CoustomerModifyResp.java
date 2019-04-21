package com.jfone.mall.base.entity.work.resp;

import io.swagger.annotations.ApiModelProperty;

public class CoustomerModifyResp {

    @ApiModelProperty("成功修改的用户记录数")
    private int result;

    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }
}
