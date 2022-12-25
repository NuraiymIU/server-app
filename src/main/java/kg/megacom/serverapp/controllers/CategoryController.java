package kg.megacom.serverapp.controllers;

import kg.megacom.serverapp.models.dto.CategoryDto;
import kg.megacom.serverapp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController implements BaseCrudController<CategoryDto, Long> {

    @Autowired
    private CategoryService categoryService;

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        return categoryService.update(categoryDto);
    }

    @Override
    public CategoryDto findById(Long id) {
        return categoryService.findById(id);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }
}
