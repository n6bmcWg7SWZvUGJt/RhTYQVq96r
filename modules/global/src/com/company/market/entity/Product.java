package com.company.market.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@NamePattern("%s|name")
@Table(name = "MARKET_PRODUCT")
@Entity(name = "market_Product")
public class Product extends StandardEntity {
    private static final long serialVersionUID = -3680929349815884771L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    protected String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCER_ID")
    protected Producer producer;

    @NotNull
    @Column(name = "PRODUCER_PRICE", nullable = false)
    protected BigDecimal producerPrice;

    public BigDecimal getProducerPrice() {
        return producerPrice;
    }

    public void setProducerPrice(BigDecimal producerPrice) {
        this.producerPrice = producerPrice;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}