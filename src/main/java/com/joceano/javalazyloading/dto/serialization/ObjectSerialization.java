package com.joceano.javalazyloading.dto.serialization;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class ObjectSerialization {

    public static <T> T toDto(Object object, Class<T> objectClass) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(object, objectClass);
    }

    public static <T> List<T> toDtoList(List<?> objects, Class<T> objectClass) {
        return objects.stream().map(object -> toDto(object, objectClass)).collect(Collectors.toList());
    }

    public static <T> Set<T> toDtoSet(Set<?> objects, Class<T> objectClass) {
        return objects.stream().map(object -> toDto(object, objectClass)).collect(Collectors.toSet());
    }
}
