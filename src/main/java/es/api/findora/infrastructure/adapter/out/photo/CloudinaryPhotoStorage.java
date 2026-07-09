package es.api.findora.infrastructure.adapter.out.photo;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import es.api.findora.domain.port.out.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class CloudinaryPhotoStorage implements PhotoRepository {

    private final Cloudinary cloudinary;

    @Override
    public String upload(MultipartFile file) {
        try {
            var result = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.asMap("folder", "findora/users")
            );
            return result.get("secure_url").toString();
        } catch (Exception e) {
            throw new RuntimeException("Error subiendo imagen a Cloudinary");
        }
    }
}
