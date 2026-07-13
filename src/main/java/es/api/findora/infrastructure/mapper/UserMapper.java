package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.model.User;
import es.api.findora.infrastructure.adapter.in.dto.user.UserRegisterRequest;
import es.api.findora.infrastructure.adapter.in.dto.user.UserRegisterResponse;
import es.api.findora.infrastructure.adapter.in.dto.user.UserResume;
import es.api.findora.infrastructure.persistence.entity.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toModel(UserEntity userEntity);

    UserResume toResume(User user);
    UserEntity toEntity(User user);

    UserRegisterResponse toResponse(User user);

    User toModel(UserRegisterRequest userRegisterRequest);


}
