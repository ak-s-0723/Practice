package org.example.productservice_proxy1.Services;

import org.example.productservice_proxy1.Dtos.ProductDto;
import org.example.productservice_proxy1.Models.Category;
import org.example.productservice_proxy1.Models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService implements IProductService {
    RestTemplateBuilder restTemplateBuilder;

    public ProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public String getAllProducts() {
        return null;
    }

    @Override
    public Product getProduct(Long id) {
        //restTemplateBuilder.rootUri("https://fakestoreapi/products"); - just to show why builder is used
        RestTemplate restTemplate = restTemplateBuilder.build();
        //first of all it will be returned like this only
        //return restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",ProductDto.class,id).getBody().toString();

        ProductDto productDto = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",ProductDto.class,id).getBody();
        Product product = getProduct(productDto);
        return product;
    }

    @Override
    public String createProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public String updateProduct(ProductDto productDto) {
        return null;
    }

    @Override
    public String deleteProduct(Long id) {
        return null;
    }

    private Product getProduct(ProductDto productDto) {
        Product product = new Product();
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImage());
        product.setPrice(productDto.getPrice());
        product.setId(productDto.getId());
        Category category = new Category();
        category.setName(productDto.getCategory());
        product.setCategory(category);
        return product;
    }
}
