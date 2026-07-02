package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.model.User;
import es.api.findora.infrastructure.adapter.in.dto.UserRegisterRequest;
import es.api.findora.infrastructure.adapter.in.dto.UserRegisterResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserRegisterRequest dto);

    UserRegisterResponse toResponse(User user);
}
