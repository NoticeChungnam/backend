package com.backend.Meal.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MealMapper {

    MealMapper INSTANCE = Mappers.getMapper(MealMapper.class);

}