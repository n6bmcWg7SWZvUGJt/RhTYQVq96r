package com.company.market.service;

public interface ProducerService {
    String NAME = "market_ProducerService";

    String productList(int count);

    String shopList(String inputGoodsName);
}