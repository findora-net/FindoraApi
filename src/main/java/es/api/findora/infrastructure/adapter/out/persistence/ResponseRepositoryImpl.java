package es.api.findora.infrastructure.adapter.out.persistence;

import es.api.findora.domain.model.Response;
import es.api.findora.domain.port.out.ResponseRepository;
import es.api.findora.infrastructure.mapper.CommentPersistenceMapper;
import es.api.findora.infrastructure.persistence.entity.ResponseEntity;
import es.api.findora.infrastructure.persistence.repository.ResponseRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ResponseRepositoryImpl implements ResponseRepository {

    private final ResponseRepositoryJPA responseJPA;
    private final CommentPersistenceMapper mapper;

    @Override
    public Response save(Response response) {
        ResponseEntity entity = mapper.toEntity(response);
        ResponseEntity saved = responseJPA.save(entity);
        return mapper.toDomain(saved);
    }
}

