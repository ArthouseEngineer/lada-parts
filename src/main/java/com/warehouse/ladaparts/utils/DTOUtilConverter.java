package com.warehouse.ladaparts.utils;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Утильный класс конвертирует Entity в DTO  и из JSON  в  Entity для CRUD операции
 * Используя ModelMapper, чтобы не писать избычтоных конвертеров на каждую сущность
 */
public class DTOUtilConverter {
    private DTOUtilConverter() {
    }

   private static final ModelMapper INSTANCE = new ModelMapper();

    public static <S,T> T map(S source, Class<T> target) {
        return INSTANCE.map(source,target);
    }

    public static <S,T>List<T> mapList(List<S> source, Class<T> targetClass) {
        return source.stream().map(s -> INSTANCE.map(s, targetClass)).collect(Collectors.toList());
    }

}
