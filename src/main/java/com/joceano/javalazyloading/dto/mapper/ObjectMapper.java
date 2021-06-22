package com.joceano.javalazyloading.dto.mapper;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class ObjectMapper {

    private ObjectMapper() { }

    public static <D> D map(Object source, Class<D> destinationType) {
        var modelMapper = new ModelMapper();
        return modelMapper.map(source, destinationType);
    }

    public static <D> List<D> mapList(List<?> sources, Class<D> destinationType) {
        return sources.stream().map(source -> map(source, destinationType)).collect(Collectors.toList());
    }

    public static <D> Set<D> mapSet(Set<?> sources, Class<D> destinationType) {
        return sources.stream().map(source -> map(source, destinationType)).collect(Collectors.toSet());
    }
}
