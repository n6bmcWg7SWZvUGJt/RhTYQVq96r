package com.company.market.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "MARKET_PRODUCER")
@Entity(name = "market_Producer")
public class Producer extends StandardEntity {
    private static final long serialVersionUID = -4766679461113164437L;

    @NotNull
    @Column(name = "NAME", nullable = false, unique = true)
    protected String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID")
    protected Address address;

    @Column(name = "FUL_NAME")
    protected String fulName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMMERCIAL_NETWORK_ID")
    protected CommercialNetwork commercialNetwork;

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

    public String getFulName() {
        return fulName;
    }

    public void setFulName(String fulName) {
        this.fulName = fulName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}