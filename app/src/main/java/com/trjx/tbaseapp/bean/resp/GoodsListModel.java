package com.trjx.tbaseapp.bean.resp;

import com.trjx.tlibs.bean.resp.RespBaseInfo;

import java.math.BigDecimal;

public class GoodsListModel extends RespBaseInfo {
    /**
     * 主键id
     */
    private Integer id;
    private String goodsName;
    /**
     * 普通价格
     */
    private float sellPrice;
    /**
     * 会员价格
     */
    private float sellPriceDiscount;
    /**
     * 缩略图
     */
    private String goodsImage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public float getSellPriceDiscount() {
        return sellPriceDiscount;
    }

    public void setSellPriceDiscount(float sellPriceDiscount) {
        this.sellPriceDiscount = sellPriceDiscount;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

}
