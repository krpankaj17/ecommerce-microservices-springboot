package com.pankaj.ecommerce.product_service.service;

import com.pankaj.ecommerce.product_service.dto.ProductRequestDto;
import com.pankaj.ecommerce.product_service.dto.ProductResponseDto;
import com.pankaj.ecommerce.product_service.dto.UpdateProductRequestDto;
import com.pankaj.ecommerce.product_service.entity.Product;
import com.pankaj.ecommerce.product_service.exception.ProductNotFoundException;
import com.pankaj.ecommerce.product_service.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    private  final ProductRepository productRepository;
    public ProductServiceImpl (ProductRepository productRepository){
        this.productRepository = productRepository;
    }


    @Override
    public ProductResponseDto createProduct(ProductRequestDto dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setActive(dto.getActive());
        product.setCategory(dto.getCategory());
        product.setBrand(dto.getBrand());
        product.setImageUrl(dto.getImageUrl());
        product.setPrice(dto.getPrice());
        product.setDescription(dto.getDescription());
       return mapToResponseDto(productRepository.save(product))  ;

    }

    @Override
    public Page<ProductResponseDto> getAllProducts(Pageable pageable) {
        Page<Product> page = productRepository.findAll(pageable);

        return page.map(this::mapToResponseDto);
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
       return mapToResponseDto(productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id))) ;

    }

    @Override
    public void deleteProduct(Long id) {
        if(!productRepository.existsById(id)){
            throw new ProductNotFoundException(id);
        }

        productRepository.deleteById(id);
    }

    @Override
    public ProductResponseDto updateProduct(Long id, UpdateProductRequestDto dto) {
        Product product =  productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        if (dto.getName()!=null){
            product.setName(dto.getName());
        }
        if (dto.getActive()!=null){
            product.setActive(dto.getActive());
        }
        if (dto.getCategory()!=null){
            product.setCategory(dto.getCategory());
        }
        if (dto.getBrand()!=null){
            product.setBrand(dto.getBrand());
        }
         if (dto.getImageUrl()!=null){
             product.setImageUrl(dto.getImageUrl());
         }
         if (dto.getPrice()!=null){
             product.setPrice(dto.getPrice());
         }
         if (dto.getDescription()!=null){
             product.setDescription(dto.getDescription());
         }

        return mapToResponseDto(productRepository.save(product));
        

    }
    private ProductResponseDto mapToResponseDto (Product product){
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(product.getId());
        dto.setActive(product.getActive());
        dto.setBrand(product.getBrand());
        dto.setCategory(product.getCategory());
        dto.setDescription(product.getDescription());
        dto.setImageUrl(product.getImageUrl());
        dto.setPrice(product.getPrice());
        dto.setCreatedAt(product.getCreatedAt());
        dto.setUpdatedAt(product.getUpdatedAt());
        dto.setName(product.getName());
        return dto;
    }

}
