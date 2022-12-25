package kg.megacom.serverapp.mappers.impl;

import kg.megacom.serverapp.mappers.CategoryMapper;
import kg.megacom.serverapp.models.Category;
import kg.megacom.serverapp.models.dto.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryDto toDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        categoryDto.setActive(category.isActive());
        return categoryDto;
    }

    @Override
    public Category toEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setActive(categoryDto.isActive());
        return category;
    }

    @Override
    public List<CategoryDto> toDtos(List<Category> t) {
        return t.stream().map(x -> toDto(x)).collect(Collectors.toList());
    }

    @Override
    public List<Category> toEntities(List<CategoryDto> categoryDtos) {
        return categoryDtos.stream().map(x -> toEntity(x)).collect(Collectors.toList());
    }
}
