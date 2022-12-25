package kg.megacom.serverapp.controllers;

import kg.megacom.serverapp.models.dto.ProductDto;
import kg.megacom.serverapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController implements BaseCrudController<ProductDto, Long>{

    @Autowired
    private ProductService productService;

    @Override
    public ProductDto save(ProductDto productDto) {
        return productService.save(productDto);
    }

    @Override
    public ProductDto update(ProductDto productDto) {
        return productService.update(productDto);
    }

    @Override
    public ProductDto findById(Long id) {
        return productService.findById(id);
    }

    @Override
    public List<ProductDto> findAll() {
        return productService.findAll();
    }
}
