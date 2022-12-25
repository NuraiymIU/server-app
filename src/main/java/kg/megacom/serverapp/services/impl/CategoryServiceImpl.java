package kg.megacom.serverapp.services.impl;

import kg.megacom.serverapp.dao.CategoryRepo;
import kg.megacom.serverapp.exceptions.CategoryNotFound;
import kg.megacom.serverapp.mappers.CategoryMapper;
import kg.megacom.serverapp.models.Category;
import kg.megacom.serverapp.models.dto.CategoryDto;
import kg.megacom.serverapp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        category = categoryRepo.save(category);
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        if (!categoryRepo.existsById(categoryDto.getId())) {
            throw new CategoryNotFound("Категория не найдена!");
        }
        Category category = categoryMapper.toEntity(categoryDto);
        category = categoryRepo.save(category);
        return categoryMapper.toDto(category);
    }


    @Override
    public CategoryDto findById(Long id) {
        Category category = categoryRepo.findById(id).orElseThrow(() -> new CategoryNotFound("Категория не найдена!"));
        return categoryMapper.toDto(category);
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> subscribers = categoryRepo.findAll();
        List<CategoryDto> categoryDtos = subscribers.stream().map(x -> categoryMapper.toDto(x)).collect(Collectors.toList());
        return categoryDtos;
    }
}
