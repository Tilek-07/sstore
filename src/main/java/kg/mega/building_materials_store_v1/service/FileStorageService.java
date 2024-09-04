package kg.mega.building_materials_store_v1.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    void addImageToProduct(MultipartFile image, Long productId);
    void addUserAvatar(MultipartFile avatar,Long userId);
}
