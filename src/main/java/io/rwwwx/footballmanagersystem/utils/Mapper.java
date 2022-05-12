package io.rwwwx.footballmanagersystem.utils;

public interface Mapper <D, E> {

    E convertToEntity(D dto);
    D convertToDto(E entity);

}
