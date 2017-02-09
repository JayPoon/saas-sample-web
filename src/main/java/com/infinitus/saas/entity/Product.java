package com.infinitus.saas.entity;

import java.math.BigDecimal;

/**
 * Created by administrator on 17/2/7.
 */
public class Product
{
    private Integer id;
    private String description;
    private String imageUrl;
    private BigDecimal price;

    public String getDescription()
    {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}