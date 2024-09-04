package kg.mega.building_materials_store_v1.repository;

import kg.mega.building_materials_store_v1.models.Category;
import kg.mega.building_materials_store_v1.models.Product;
import kg.mega.building_materials_store_v1.models.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    Optional<Product> findByName(String name);
    List<ProductDto> findAllByCategoryName(String categoryName);

}
