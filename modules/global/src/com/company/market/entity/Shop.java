package com.company.market.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s %s|no,name")
@Table(name = "MARKET_SHOP")
@Entity(name = "market_Shop")
public class Shop extends StandardEntity {
    private static final long serialVersionUID = 3759053200993279930L;

    @NotNull
    @Column(name = "NO_", nullable = false, unique = true)
    protected String no;

    @OneToMany(mappedBy = "shop")
    protected List<Shipment> shipments;

    @Column(name = "SHOP_TYPE")
    protected String shopType;

    //@Embedded
    @OnDelete(DeletePolicy.CASCADE)
    @Composition
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "ADDRESS_ID")
    protected Address address;

    @OneToMany(mappedBy = "shop")
    protected List<Goods> goods;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "COMMERCIAL_NETWORK_ID")
    protected CommercialNetwork commercialNetwork;

    public List<Shipment> getShipments() {
        return shipments;
    }

    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }

    public ShopType getShopType() {
        return shopType == null ? null : ShopType.fromId(shopType);
    }

    public void setShopType(ShopType shopType) {
        this.shopType = shopType == null ? null : shopType.getId();
    }

    public List<Goods> getGoods() {
        return goods;
    }

    public void setGoods(List<Goods> goods) {
        this.goods = goods;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public CommercialNetwork getCommercialNetwork() {
        return commercialNetwork;
    }

    public void setCommercialNetwork(CommercialNetwork commercialNetwork) {
        this.commercialNetwork = commercialNetwork;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
}