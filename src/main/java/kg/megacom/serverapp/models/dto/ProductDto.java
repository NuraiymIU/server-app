package kg.megacom.serverapp.models.dto;

import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String name;
    private double price;
    private CategoryDto categoryDto;

}
