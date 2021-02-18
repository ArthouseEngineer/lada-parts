package com.warehouse.ladaparts.exceptions;

import java.util.Map;

public class EntityNotFoundException  extends RuntimeException {
    public EntityNotFoundException(Class<?> clazz, Map<String, String> searchParamsMap) {
        super(String.format("Для %s Не найдено по заданном  критериям поиска %s",  clazz.getSimpleName(), searchParamsMap));
    }

    public EntityNotFoundException(Class<?> clazz, String searchParam) {
        super(String.format("Для %s Не найдено по заданном  ID=[%s]", clazz.getSimpleName(),searchParam));
    }

    private static String generateMessage(String entity, Map<String, String> searchParams) {
        return String.format("Для %s Не найдено по заданном  критериям поиска %s",  entity, searchParams);
    }

}
