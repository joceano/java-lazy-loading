package com.joceano.javalazyloading.dto.serialization;

import org.modelmapper.ModelMapper;

public final class ObjectSerialization {

    public static <T> T toDto(Object object, Class<T> clazz) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(object, clazz);
    }
}
