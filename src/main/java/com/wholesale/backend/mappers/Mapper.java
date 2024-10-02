package com.wholesale.backend.mappers;

public interface Mapper<A, B> {
    
    B mapToDto(A entity);
    
    A mapToEntity(B dto);

    Iterable<B> mapToDto(Iterable<A> entities);

    Iterable<A> mapToEntity(Iterable<B> dtos);

}
