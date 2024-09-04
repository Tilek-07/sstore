package kg.mega.building_materials_store_v1.service.impl;

import kg.mega.building_materials_store_v1.enums.ImageType;
import kg.mega.building_materials_store_v1.models.Image;
import kg.mega.building_materials_store_v1.models.Product;
import kg.mega.building_materials_store_v1.models.User;
import kg.mega.building_materials_store_v1.repository.ImageRepo;
import kg.mega.building_materials_store_v1.repository.ProductRepo;
import kg.mega.building_materials_store_v1.service.FileStorageService;
import kg.mega.building_materials_store_v1.service.ProductService;
import kg.mega.building_materials_store_v1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FileStorageServiceImpl implements FileStorageService {
    private final UserService userService;
    private final ProductService productService;
    private final ImageRepo imageRepo;

    @Override
    public void addImageToProduct(MultipartFile image, Long productId) {
        File newFile = new File("/Users/tilekkanybekov/IdeaProjects/building_materials_store_v1/src/main/resources/good_images//"+image.getOriginalFilename());
        try {
            newFile.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(newFile);
            outputStream.write(image.getBytes());
            outputStream.close();
            Product product = productService.getById(productId);
            Image productImage = new Image();
            productImage.setProduct(product);
            productImage.setPath(newFile.getAbsolutePath());
            productImage.setIsActive(true);
            productImage.setType(ImageType.GOOD_IMAGE);
            imageRepo.save(productImage);
        } catch (IOException e) {
            System.out.println("Error creating file");;
        }
    }

    @Override
    public void addUserAvatar(MultipartFile avatar, Long userId) {
        File newFile = new File("/Users/tilekkanybekov/IdeaProjects/building_materials_store_v1/src/main/resources/user_avatars//"+avatar.getOriginalFilename());
        try {
            newFile.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(newFile);
            outputStream.write(avatar.getBytes());
            outputStream.close();
            User user = userService.getById(userId);
            Image userAvatar = new Image();
            userAvatar.setType(ImageType.USER_AVATAR);
            userAvatar.setUser(user);
            userAvatar.setPath(newFile.getAbsolutePath());
            setFalseUserAvatarActivity(user);
            userAvatar.setIsActive(true);
            imageRepo.save(userAvatar);
        } catch (IOException e) {
            System.out.println("Error creating file");
        }
    }
    private void setFalseUserAvatarActivity(User user){
        Optional<Image> avatar = imageRepo.findByUser(user);
        if(avatar.isPresent()){
//            avatar.get().setActive(false);
            imageRepo.save(avatar.get());
        }else {
            System.out.println("User has no avatar yet");
        }

    }
}
