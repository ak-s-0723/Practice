package org.example.productservice_proxy1.Services;

import org.example.productservice_proxy1.Dtos.ProductDto;
import org.example.productservice_proxy1.Models.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();

    Product getProduct(Long id);

    Product createProduct(ProductDto productDto);

    String updateProduct(ProductDto productDto);

    String deleteProduct(Long id);
}
