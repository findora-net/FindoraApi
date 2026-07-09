package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.model.VerificationToken;
import es.api.findora.infrastructure.persistence.entity.VerificationTokenEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VerificationTokenMapper {

    VerificationTokenEntity toEntity(VerificationToken verificationToken);
    VerificationToken toModel (VerificationTokenEntity verificationTokenEntity);
}
