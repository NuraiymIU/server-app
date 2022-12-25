package kg.megacom.serverapp.mappers;

import java.util.List;

public interface BaseMapperMethods<S, T> {

    S toDto(T t);

    T toEntity(S s);

    List<S> toDtos(List<T> t);

    List<T> toEntities(List<S> s);

}
