package org.example.productservice_proxy1.Controllers;

import org.example.productservice_proxy1.Dtos.ProductDto;
import org.example.productservice_proxy1.Models.Product;
import org.example.productservice_proxy1.Services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    //Either we can add @Autowired at top of this, or we should have constructor.
    //The extra lines of code (constructor) which we have written
    //will work similar to autowired. It will make sure that productservice object or bean
    //is available while calling constructor of productController.
    //Also after Java9 , in case we just have one constructor , we don't need @Autowired
    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public List<Product> GetAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    //public Product GetProduct(@PathVariable Long id) {
    public ResponseEntity<Product> GetProduct(@PathVariable Long id) {
        try {
            MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
            headers.add("calledBy","StupidFrontendEngineer");
            if(id < 1) {
                throw new IllegalArgumentException("Something went bad");
            }
            Product product = productService.getProduct(id);
            ResponseEntity<Product> responseEntity = new ResponseEntity<>(product,headers,HttpStatus.OK);
            return responseEntity;
        } catch(Exception exception) {
            return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
       return new ResponseEntity<>(productService.createProduct(productDto),HttpStatus.OK);
    }

    @PatchMapping("")
    public String updateProduct(@RequestBody ProductDto productDto) {
        return "updated Product with following details "+productDto;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long productId) {
        return "marking product with id "+productId+" as inactive";
    }
}
