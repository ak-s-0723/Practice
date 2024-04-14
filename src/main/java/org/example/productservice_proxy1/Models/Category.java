package org.example.productservice_proxy1.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Category extends BaseModel {
    private String name;
    private String description;
    private List<Product> products;
}
