package com.company.market.config;

import com.haulmont.cuba.core.config.Config;
import com.haulmont.cuba.core.config.Property;
import com.haulmont.cuba.core.config.Source;
import com.haulmont.cuba.core.config.SourceType;
import com.haulmont.cuba.core.config.defaults.Default;

@Source(type = SourceType.DATABASE)
public interface CssConfig extends Config {

    String x = "10";

//    default void setFrom(int x){
//        xx[0] = String.valueOf(x);
//    }

    @Property("shopManager.deficit")
    @Default(x)
    int getFrom();
}