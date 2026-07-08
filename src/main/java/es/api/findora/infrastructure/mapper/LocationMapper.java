package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.model.Location;
import es.api.findora.infrastructure.adapter.in.dto.CreateLocationRequest;

public interface LocationMapper {

    Location toDomain(CreateLocationRequest createLocationRequest);

}
