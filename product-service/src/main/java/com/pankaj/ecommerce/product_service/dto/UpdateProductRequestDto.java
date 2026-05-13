package com.pankaj.ecommerce.product_service.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class UpdateProductRequestDto {


    @Size(min = 2,message = "The size of name should be atleast two character")
    private String name ;

    @DecimalMin(value = "0.0",inclusive = true,message = "Price cannot be negative")
    private BigDecimal price ;

    @Size(min = 2, message = "Brand name too short")
    private String brand ;

    @Size(min = 2, message = "Category name too short")
    private String category ;


    private String imageUrl;


    private Boolean active;

    private String description ;





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  
}
