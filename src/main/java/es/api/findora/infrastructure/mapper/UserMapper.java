package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.model.User;
import es.api.findora.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(UserEntity userEntity);
}
