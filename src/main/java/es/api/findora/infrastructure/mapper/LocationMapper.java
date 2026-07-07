package es.api.findora.infrastructure.mapper;

import es.api.findora.domain.model.Location;
import es.api.findora.infrastructure.adapter.in.dto.location.LocationResume;
import es.api.findora.infrastructure.persistence.entity.LocationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = PageMapper.class)
public interface LocationMapper {

    LocationResume toResume(Location location);

    Location toModel(LocationEntity locationEntity);
}
