package com.company.market.jmx;

import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(description = "JMX bean for some settings")
public interface NetworkMethodMBean {
    String productList(int count);
    String shopList(String inputGoodsName);
    String purchaseCount(String shop);
    String npurchaseCount(String networkName);
}