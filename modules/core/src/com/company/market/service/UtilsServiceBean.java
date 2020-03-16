package com.company.market.service;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.global.MetadataTools;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

@Service(UtilsService.NAME)
public class UtilsServiceBean implements UtilsService {

    @Inject
    private MetadataTools metadataTools;

    @Override
    public String collectionToString(Collection<? extends StandardEntity> list){
        String s = "";
        for (StandardEntity e:list){
            s += (metadataTools.getInstanceName(e) + ", \n");
        }
        return s;
    }

}