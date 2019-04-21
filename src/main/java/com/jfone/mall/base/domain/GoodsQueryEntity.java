package com.jfone.mall.base.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 *  商品列表请求输入参数
 *
 */

public class GoodsQueryEntity {

    @ApiModelProperty("当前页码")
    private int pageNum;
    @ApiModelProperty("分页数")
    private int pageSize;
    @ApiModelProperty("搜索关键词")
    private String search;
    @ApiModelProperty("排序字段")
    private String order;
    @ApiModelProperty("排序方式")
    private String dir;

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
