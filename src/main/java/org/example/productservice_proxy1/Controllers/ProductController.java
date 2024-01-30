package org.example.productservice_proxy1.Controllers;

import org.example.productservice_proxy1.Dtos.ProductDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("")
    public String GetAllProducts() {
        return "returning All Products";
    }

    @GetMapping("{id}")
    public String GetProduct(@PathVariable Long id) {
        return "returning product with Id "+id;
    }

    @PostMapping("")
    public String createProduct(@RequestBody ProductDto productDto) {
        return "created Product with "+productDto;
    }

    @PatchMapping("")
    public String updateProduct(@RequestBody ProductDto productDto) {
        return "updated Product with following details "+productDto;
    }

    @DeleteMapping("{id}")
    public String deleteProduct(@PathVariable("id") Long productId) {
        return "marking product with id "+productId+" as inactive";
    }
}
