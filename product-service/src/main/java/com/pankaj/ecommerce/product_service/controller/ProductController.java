package com.pankaj.ecommerce.product_service.controller;

import com.pankaj.ecommerce.product_service.dto.ProductRequestDto;
import com.pankaj.ecommerce.product_service.dto.ProductResponseDto;
import com.pankaj.ecommerce.product_service.dto.UpdateProductRequestDto;
import com.pankaj.ecommerce.product_service.service.ProductService;
import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
   private  final ProductService productService ;



    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping
    public ProductResponseDto createProduct(@RequestBody @Valid ProductRequestDto productRequestDto){
      return productService.createProduct(productRequestDto);
    }
    @GetMapping
    public Page<ProductResponseDto> getAllProducts(Pageable pageable){
         return productService.getAllProducts(pageable);
    }
    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id){
        productService.deleteProduct(id);
       return ResponseEntity.noContent().build();
    }
    @PatchMapping("/{id}")
    public ProductResponseDto updateProductById(@PathVariable Long id , @Valid @RequestBody UpdateProductRequestDto updateProductRequestDto){
        return productService.updateProduct(id,updateProductRequestDto);
    }
}
