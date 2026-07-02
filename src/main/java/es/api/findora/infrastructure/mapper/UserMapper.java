package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.model.User;
import es.api.findora.infrastructure.adapter.in.dto.UserRegisterRequest;
import es.api.findora.infrastructure.adapter.in.dto.UserRegisterResponse;
import es.api.findora.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity toEntity(User user);

    UserRegisterResponse toResponse(User user);

    User toModel(UserRegisterRequest userRegisterRequest);

    User toModel(UserEntity userEntity);

}
