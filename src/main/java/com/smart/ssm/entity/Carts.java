package com.smart.ssm.entity;

public class Carts {
    /**
     *
     */
    private Integer cartsId;

    /**
     * 商品数量
     */
    private Integer quality;

    /**
     * 商品外键
     */
    private Integer productId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 0表示未删除，1表示已删除
     */
    private Integer status;

    public Integer getCartsId() {
        return cartsId;
    }

    public void setCartsId(Integer cartsId) {
        this.cartsId = cartsId;
    }

    public Integer getQuality() {
        return quality;
    }

    public void setQuality(Integer quality) {
        this.quality = quality;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

