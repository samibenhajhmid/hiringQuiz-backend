package com.smoothalgo.hiringQuiz.services.mapper;


import java.util.List;

public interface EntityMapper <D, E> {

    E toEntity(D dto) ;

    D toDto(E entity);
}

