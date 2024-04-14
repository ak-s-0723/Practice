package org.example.productservice_proxy1.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseModel {
    private String title;
    private String description;
    private String imageUrl;
    private Double price;
    private Category category;
}
