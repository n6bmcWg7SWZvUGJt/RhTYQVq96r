package com.company.market.entity;

import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

//@Embeddable
@Table(name = "MARKET_ADDRESS")
@Entity(name = "market_Address")
public class Address extends StandardEntity {
    private static final long serialVersionUID = -6291976230549343030L;

    @Column(name = "TOWN")
    protected String town;

    @Column(name = "STREET")
    protected String street;

    @Column(name = "HOUSE")
    protected String house;

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}