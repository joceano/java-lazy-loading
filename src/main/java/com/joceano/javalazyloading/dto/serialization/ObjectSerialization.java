package com.joceano.javalazyloading.dto.serialization;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class ObjectSerialization {

    private ObjectSerialization() { }

    public static <D> D toDto(Object source, Class<D> destinationType) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(source, destinationType);
    }

    public static <D> List<D> toDtoList(List<?> sources, Class<D> destinationType) {
        return sources.stream().map(source -> toDto(source, destinationType)).collect(Collectors.toList());
    }

    public static <D> Set<D> toDtoSet(Set<?> sources, Class<D> destinationType) {
        return sources.stream().map(source -> toDto(source, destinationType)).collect(Collectors.toSet());
    }
}
