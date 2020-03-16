package com.company.market.service;

import com.haulmont.cuba.core.entity.StandardEntity;

import java.util.Collection;
import java.util.List;

public interface UtilsService {
    String NAME = "market_UtilsService";
    String collectionToString(Collection<? extends StandardEntity> list);
}