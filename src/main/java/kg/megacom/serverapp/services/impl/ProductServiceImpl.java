package kg.megacom.serverapp.services.impl;

import kg.megacom.serverapp.dao.ProductRepo;
import kg.megacom.serverapp.exceptions.ResourceNotFound;
import kg.megacom.serverapp.mappers.ProductMapper;
import kg.megacom.serverapp.models.Product;
import kg.megacom.serverapp.models.dto.ProductDto;
import kg.megacom.serverapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        product = productRepo.save(product);
        return productMapper.toDto(product);
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        if(!productRepo.existsById(productDto.getId())) {
            throw new ResourceNotFound("Товар не найден!");
        }
        Product product = productMapper.toEntity(productDto);
        product = productRepo.save(product);
        return productMapper.toDto(product);
    }

    @Override
    public ProductDto findById(Long id) {
        Product product = productRepo.findById(id).orElseThrow(
                () -> new ResourceNotFound("Товар не найден!")
        );
        return productMapper.toDto(product);
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> productList = productRepo.findAll();
        return productMapper.toDtos(productList);
    }
}
