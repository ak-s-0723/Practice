package org.example.productservice_proxy1.Dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.productservice_proxy1.Models.Category;

@Getter
@Setter
@ToString
public class ProductDto {
    private String title;
    private String description;
    private String imageUrl;
    private Double price;
    private Category category;
}
