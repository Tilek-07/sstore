package kg.mega.building_materials_store_v1.controller;

import kg.mega.building_materials_store_v1.models.Category;
import kg.mega.building_materials_store_v1.models.dto.CategoryDto;
import kg.mega.building_materials_store_v1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/save")
    public void save(@RequestBody Category category){
        categoryService.save(category);
    }

    @GetMapping("/get_all")
    public List<CategoryDto> findAll(){
        return categoryService.findAll();
    }

    @PutMapping("/update")
    public Category update(@RequestBody Category category){
        return categoryService.update(category);
    }

    @DeleteMapping("/deleteById")
    public void delete(@RequestParam Long id){
        categoryService.delete(id);
    }
}
