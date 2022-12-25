package kg.megacom.serverapp.mappers.impl;

import kg.megacom.serverapp.mappers.CategoryMapper;
import kg.megacom.serverapp.mappers.ProductMapper;
import kg.megacom.serverapp.models.Product;
import kg.megacom.serverapp.models.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryDto(categoryMapper.toDto(product.getCategory()));
        return productDto;
    }

    @Override
    public Product toEntity(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setCategory(categoryMapper.toEntity(productDto.getCategoryDto()));
        return product;
    }

    @Override
    public List<ProductDto> toDtos(List<Product> productList) {
        return productList
                .stream()
                .map(x -> toDto(x))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> toEntities(List<ProductDto> productDtos) {
        return productDtos
                .stream()
                .map(x -> toEntity(x))
                .collect(Collectors.toList());
    }
}
