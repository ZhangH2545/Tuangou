package com.example.tuangou.entity;

import java.util.List;

/**
 * Created by layer on 16/11/1.
 * 商品信息类
 *
 */
public class GoodsInfo {

    private int ret;
    private String msg;

    private ResultBean result;
    private String token;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class ResultBean {
        private String topid;

        private List<GoodlistBean> goodlist;

        public String getTopid() {
            return topid;
        }

        public void setTopid(String topid) {
            this.topid = topid;
        }

        public List<GoodlistBean> getGoodlist() {
            return goodlist;
        }

        public void setGoodlist(List<GoodlistBean> goodlist) {
            this.goodlist = goodlist;
        }

        public static class GoodlistBean {
            private String goods_id;
            private String product;
            private String title;
            private String short_title;
            private String value;
            private String price;
            private int bought;
            private String is_new;
            private int is_appointment;
            private String seven_refund;
            private int time_refund;
            private String goods_type;
            private String is_sell_up;
            private String new_cat;
            private String is_voucher;
            private int left_time;
            private String distance;
            private int l_display;
            private String l_text;
            private String l_price;
            private String l_content;

            private List<ImagesBean> images;

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getProduct() {
                return product;
            }

            public void setProduct(String product) {
                this.product = product;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getShort_title() {
                return short_title;
            }

            public void setShort_title(String short_title) {
                this.short_title = short_title;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public int getBought() {
                return bought;
            }

            public void setBought(int bought) {
                this.bought = bought;
            }

            public String getIs_new() {
                return is_new;
            }

            public void setIs_new(String is_new) {
                this.is_new = is_new;
            }

            public int getIs_appointment() {
                return is_appointment;
            }

            public void setIs_appointment(int is_appointment) {
                this.is_appointment = is_appointment;
            }

            public String getSeven_refund() {
                return seven_refund;
            }

            public void setSeven_refund(String seven_refund) {
                this.seven_refund = seven_refund;
            }

            public int getTime_refund() {
                return time_refund;
            }

            public void setTime_refund(int time_refund) {
                this.time_refund = time_refund;
            }

            public String getGoods_type() {
                return goods_type;
            }

            public void setGoods_type(String goods_type) {
                this.goods_type = goods_type;
            }

            public String getIs_sell_up() {
                return is_sell_up;
            }

            public void setIs_sell_up(String is_sell_up) {
                this.is_sell_up = is_sell_up;
            }

            public String getNew_cat() {
                return new_cat;
            }

            public void setNew_cat(String new_cat) {
                this.new_cat = new_cat;
            }

            public String getIs_voucher() {
                return is_voucher;
            }

            public void setIs_voucher(String is_voucher) {
                this.is_voucher = is_voucher;
            }

            public int getLeft_time() {
                return left_time;
            }

            public void setLeft_time(int left_time) {
                this.left_time = left_time;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }

            public int getL_display() {
                return l_display;
            }

            public void setL_display(int l_display) {
                this.l_display = l_display;
            }

            public String getL_text() {
                return l_text;
            }

            public void setL_text(String l_text) {
                this.l_text = l_text;
            }

            public String getL_price() {
                return l_price;
            }

            public void setL_price(String l_price) {
                this.l_price = l_price;
            }

            public String getL_content() {
                return l_content;
            }

            public void setL_content(String l_content) {
                this.l_content = l_content;
            }

            public List<ImagesBean> getImages() {
                return images;
            }

            public void setImages(List<ImagesBean> images) {
                this.images = images;
            }

            public static class ImagesBean {
                private int width;
                private String image;

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }
            }
        }
    }
}
