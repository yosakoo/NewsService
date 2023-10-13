package com.example.NewsService.web.mapper;

import java.util.List;
import java.util.Optional;

public interface Mappable<E, D> {

   E toEntity(D d);

    List<E> toEntity(List<D> d);

    D toDto(E e);

    List<D> toDto(List<E> e);

}