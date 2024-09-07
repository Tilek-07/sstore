package kg.mega.building_materials_store_v1.service.impl;

import kg.mega.building_materials_store_v1.exception.CategoryNotFoundException;
import kg.mega.building_materials_store_v1.mapper.ProductMapper;
import kg.mega.building_materials_store_v1.models.Product;
import kg.mega.building_materials_store_v1.models.dto.ProductDto;
import kg.mega.building_materials_store_v1.repository.ProductRepo;
import kg.mega.building_materials_store_v1.service.CategoryService;
import kg.mega.building_materials_store_v1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final CategoryService categoryService;


    @Override
    public void saveProduct(ProductDto productDto) throws CategoryNotFoundException {
        Product product = ProductMapper.INSTANCE.toProduct(productDto);// Преобразование DTO в сущность
        if (categoryService.findByName(productDto.getCategory().getName()).isPresent()) {
            product.setCategory(categoryService.findByName(productDto.getCategory().getName()).get());
            Product savedProduct = productRepo.save(product); // Сохранение продукта в базе данных
        } else {
            throw new CategoryNotFoundException("Category " + productDto.getCategory().getName() + " not found!");
        }

//        ProductMapper.INSTANCE.toProductDto(savedProduct);            // Преобразование сохраненной сущности обратно в DTO
    }

    @Override
    public Product getById(Long id) {
        return productRepo.findById(id).get();
    }

    @Override
    public ProductDto findById(Long id) {
        return ProductMapper.INSTANCE.toProductDto(productRepo.findById(id).orElse(null));
    }

//    @Override
//    public List<ProductDto> getProductsByCategoryName(String categoryName) {
//        return productRepo.findAllByCategoryName(categoryName).stream()
//                .map(productMapper::toProductDto)
//                .collect(Collectors.toList());
//    }


    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public void delete(Long id) {
        if (productRepo.existsById(id)) {
            productRepo.deleteById(id);
        } else {
            throw new RuntimeException("Product not found whith id:" + id);
        }

    }
}
