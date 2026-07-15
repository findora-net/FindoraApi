package es.api.findora.domain.port.out;

import es.api.findora.domain.model.Response;

public interface ResponseRepository {
    Response save(Response response);
}
