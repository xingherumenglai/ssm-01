package com.smart.ssm.entity;

public class Product {
    /**
     *
     */
    private Integer productId;

    /**
     * 商品名
     */
    private String name;

    /**
     * 0表示未删除，1表示已删除
     */
    private Integer status;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

