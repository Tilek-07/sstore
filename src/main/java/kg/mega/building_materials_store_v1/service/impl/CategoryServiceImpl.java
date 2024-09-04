package kg.mega.building_materials_store_v1.service.impl;

import kg.mega.building_materials_store_v1.mapper.CategoryMapper;
import kg.mega.building_materials_store_v1.models.Category;
import kg.mega.building_materials_store_v1.models.dto.CategoryDto;
import kg.mega.building_materials_store_v1.repository.CategoryRepo;
import kg.mega.building_materials_store_v1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    @Override
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public List<CategoryDto> findAll() {
        return CategoryMapper.INSTANCE.toCategoryDtoList(categoryRepo.findAll());
    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }
}
