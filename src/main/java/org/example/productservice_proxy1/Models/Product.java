package org.example.productservice_proxy1.Models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private String title;
    private String description;
    private String imageUrl;
    private Double price;
    private Category category;
}
