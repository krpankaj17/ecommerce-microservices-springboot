package com.pankaj.ecommerce.product_service.dto;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;


public class ProductRequestDto {
    @NotBlank(message = "Enter valid name")
    private String name ;
    @DecimalMin(value = "0.0", inclusive = true , message = "Price cannot be negative")
    @NotNull(message = "Price is required")

    private BigDecimal price ;
    @NotBlank(message = "Brand cannot be blank")
    private String brand ;
    @NotBlank(message = "Category cannot be blank")
    private String category;
    private String imageUrl;
    private String description;
    @NotNull(message = "Active status is required")
    private Boolean active;

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  BigDecimal getPrice() {
        return price;
    }

    public void setPrice( BigDecimal price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand( String brand) {
        this.brand = brand;
    }

    public  String getCategory() {
        return category;
    }

    public void setCategory( String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public  Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
