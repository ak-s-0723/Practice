package org.example.productservice_proxy1.Services;

import org.example.productservice_proxy1.Dtos.ProductDto;
import org.example.productservice_proxy1.Models.Product;

public interface IProductService {
    String getAllProducts();

    Product getProduct(Long id);

    String createProduct(ProductDto productDto);

    String updateProduct(ProductDto productDto);

    String deleteProduct(Long id);
}
