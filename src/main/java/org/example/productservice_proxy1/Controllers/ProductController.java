package org.example.productservice_proxy1.Controllers;

import org.example.productservice_proxy1.Dtos.ProductDto;
import org.example.productservice_proxy1.Models.Product;
import org.example.productservice_proxy1.Services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String GetAllProducts() {
        return "returning All Products";
    }

    @GetMapping("/{id}")
    public Product GetProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @PostMapping("")
    public String createProduct(@RequestBody ProductDto productDto) {
        return "created Product with "+productDto;
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
