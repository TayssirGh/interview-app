package com.distr.interview.core.service.impl.converter;

import com.distr.interview.core.dal.entity.AppUserRoleEntity;
import com.distr.interview.core.model.entity.AppUserRole;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AppUserRoleConverter {
    public AppUserRoleConverter INSTANCE = Mappers.getMapper(AppUserRoleConverter.class);
    public AppUserRoleEntity toEntity(AppUserRole u);
    public AppUserRole fromEntity(AppUserRoleEntity u);

}
