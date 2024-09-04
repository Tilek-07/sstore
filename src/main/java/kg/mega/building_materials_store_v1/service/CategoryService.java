package kg.mega.building_materials_store_v1.service;

import kg.mega.building_materials_store_v1.models.Category;
import kg.mega.building_materials_store_v1.models.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    void save (Category category);
    List<CategoryDto> findAll();
    Category update(Category category);
    void delete(Long id);
}
