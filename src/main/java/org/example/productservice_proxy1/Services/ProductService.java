package org.example.productservice_proxy1.Services;

import org.example.productservice_proxy1.Dtos.ProductDto;
import org.example.productservice_proxy1.Models.Category;
import org.example.productservice_proxy1.Models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    RestTemplateBuilder restTemplateBuilder;

    public ProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public List<Product> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        //First of all show with List<Product> and why it will not work using main2.java
        ResponseEntity<ProductDto[]> responseEntityProductDtos = restTemplate.getForEntity("https://fakestoreapi.com/products", ProductDto[].class);
        List<Product> products = new ArrayList<>();
        for(ProductDto productDto : responseEntityProductDtos.getBody()) {
            products.add(getProduct(productDto));
        }
        //return products.toArray(new Product[0]); //In case, we wanted to return array only and not list , https://stackoverflow.com/questions/4042434/converting-arrayliststring-to-string-in-java
        return products;
    }

    @Override
    public Product getProduct(Long id) {
        //restTemplateBuilder.rootUri("https://fakestoreapi/products"); - just to show why builder is used
        RestTemplate restTemplate = restTemplateBuilder.build();
        //first of all it will be returned like this only
        //return restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",ProductDto.class,id).getBody().toString();

        //second time it will be like this
        //ProductDto ProductDto = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",ProductDto.class,id).getBody();

        //third time
        //Eg for sending headers in input using exchange() - https://riptutorial.com/spring/example/24622/setting-headers-on-spring-resttemplate-request#google_vignette ,  https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html#exchange-java.lang.String-org.springframework.http.HttpMethod-org.springframework.http.HttpEntity-java.lang.Class-java.lang.Object...-
        //Explain difference between getForEntity and getForObject and
        ResponseEntity<ProductDto> responseEntityProductDto = restTemplate.getForEntity("https://fakestoreapi.com/products/{id}",ProductDto.class,id);
        Product product = getProduct(responseEntityProductDto.getBody());
        return product;
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        restTemplate.postForEntity("https://fakestoreapi.com/products",productDto,ProductDto.class);
        return getProduct(productDto);
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
