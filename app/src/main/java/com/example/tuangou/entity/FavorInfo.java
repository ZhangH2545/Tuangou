package com.example.tuangou.entity;

/**
 * Created by layer on 16/11/1.
 */
public class FavorInfo extends BaseModel {
    private boolean isFavor;
    private String goods_id;
    private String imageUrl;
    private String pruduct;
    private String price;
    private String value;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPruduct() {
        return pruduct;
    }

    public void setPruduct(String pruduct) {
        this.pruduct = pruduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isFavor() {
        return isFavor;
    }

    public void setFavor(boolean favor) {
        isFavor = favor;
    }

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }
}
