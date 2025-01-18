package com.distr.interview.core.service.impl.converter;

import com.distr.interview.core.dal.entity.AppConfEntity;
import com.distr.interview.core.model.entity.AppConf;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppConfConverter {
    public AppConfConverter INSTANCE = Mappers.getMapper(AppConfConverter.class);
    public AppConfEntity toEntity(AppConf u);
    public AppConf fromEntity(AppConfEntity u);
}
