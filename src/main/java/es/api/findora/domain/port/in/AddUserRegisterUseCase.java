package es.api.findora.domain.port.in;

import es.api.findora.domain.model.User;
import org.springframework.web.multipart.MultipartFile;

public interface AddUserRegisterUseCase {

    User execute(User user, MultipartFile photo);

}
