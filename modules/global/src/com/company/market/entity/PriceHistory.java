package com.company.market.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@NamePattern("%s %s|priceChangeDate,price")
@Table(name = "MARKET_PRICE_HISTORY")
@Entity(name = "market_PriceHistory")
public class PriceHistory extends StandardEntity {
    private static final long serialVersionUID = 5308256333910731969L;

    @Column(name = "PRICE")
    protected BigDecimal price;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SHOP_ID")
    protected Shop shop;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PRICE_CHANGE_DATE")
    protected Date priceChangeDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GOODS_ID")
    protected Goods goods;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Date getPriceChangeDate() {
        return priceChangeDate;
    }

    public void setPriceChangeDate(Date priceChangeDate) {
        this.priceChangeDate = priceChangeDate;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

}