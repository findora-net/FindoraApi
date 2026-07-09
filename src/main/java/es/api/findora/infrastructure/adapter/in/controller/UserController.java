package es.api.findora.infrastructure.adapter.in.controller;


import es.api.findora.domain.model.User;
import es.api.findora.domain.port.in.AddUserRegisterUseCase;
import es.api.findora.domain.port.out.PhotoRepository;
import es.api.findora.infrastructure.adapter.in.dto.UserRegisterRequest;
import es.api.findora.infrastructure.adapter.in.dto.UserRegisterResponse;
import es.api.findora.infrastructure.mapper.UserMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;




@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final AddUserRegisterUseCase addUserRegisterUseCase;
    private final UserMapper userMapper;
    private final PhotoRepository photoStorage;

    @PostMapping(value = "/register", consumes = "multipart/form-data")
    public ResponseEntity<UserRegisterResponse> userRegister(
            @RequestPart("data") @Valid UserRegisterRequest userRegisterRequest,
            BindingResult bindingResult,
            @RequestPart(value = "photo", required = false) MultipartFile photo
    ) throws Exception {
        if(bindingResult.hasErrors()){
            throw new Exception();
        }
        String photoUrl = null;

        if (photo != null && !photo.isEmpty()) {
            photoUrl = photoStorage.upload(photo);
        }

        User user = userMapper.toModel(userRegisterRequest);
        user.setImage(photoUrl);

        
        User saved = addUserRegisterUseCase.execute(user);

        UserRegisterResponse response = userMapper.toResponse(saved);

        return ResponseEntity.ok(response);

    }
}
