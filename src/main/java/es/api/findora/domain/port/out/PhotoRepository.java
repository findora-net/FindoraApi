package es.api.findora.domain.port.out;

import org.springframework.web.multipart.MultipartFile;

public interface PhotoRepository {
    String upload(MultipartFile file);
}
