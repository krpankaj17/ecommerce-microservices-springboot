package com.pankaj.ecommerce.product_service.service;

import com.pankaj.ecommerce.product_service.dto.ProductRequestDto;
import com.pankaj.ecommerce.product_service.dto.ProductResponseDto;
import com.pankaj.ecommerce.product_service.dto.UpdateProductRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
    ProductResponseDto createProduct (ProductRequestDto productRequestDto);


    Page<ProductResponseDto> getAllProducts(Pageable pageable);

    ProductResponseDto getProductById(Long id);

    void deleteProduct(Long id);

   ProductResponseDto updateProduct(Long id , UpdateProductRequestDto updateProductRequestDto);

}
