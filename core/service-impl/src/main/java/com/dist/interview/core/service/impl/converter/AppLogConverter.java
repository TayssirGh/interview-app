package com.dist.interview.core.service.impl.converter;

import com.dist.interview.core.dal.entity.AppLogEntity;
import com.dist.interview.core.infra.model.entity.AppLog;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppLogConverter {
    public AppLogConverter INSTANCE = Mappers.getMapper(AppLogConverter.class);
    public AppLogEntity toEntity(AppLog u);
    public AppLog fromEntity(AppLogEntity u);
}
