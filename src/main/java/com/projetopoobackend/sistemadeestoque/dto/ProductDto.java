package com.projetopoobackend.sistemadeestoque.dto;

import java.io.Serializable;

import com.projetopoobackend.sistemadeestoque.domain.Product;
import com.projetopoobackend.sistemadeestoque.enums.ProductType;

public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private Integer quantity;
    private ProductType type;
    private Double buyPrice;
    private Double sellPrice;
    private String whereStored;

    public ProductDto() {
    }

    public ProductDto(Product obj) {
        id = obj.getId();
        name = obj.getName();
        quantity = obj.getQuantity();
        type = obj.getType();
        buyPrice = obj.getBuyPrice();
        sellPrice = obj.getSellPrice();
        whereStored = obj.getWhereStored();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getWhereStored() {
        return whereStored;
    }

    public void setWhereStored(String whereStored) {
        this.whereStored = whereStored;
    }

}
