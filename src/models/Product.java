/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Admin
 */
public class Product {
    private int id;
    private String code;
    private String name;
    private double priceSell;
    private String description;
    private String imagePath;
    private int quantity;
    private int categoryId;

    public Product(int id, String imagePath, String code,  String name, String description, double priceSell, int quantity, int categoryId) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.priceSell = priceSell;
        this.description = description;
        this.imagePath = imagePath;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public Product(String imagePath, String code, String name, double priceSell, String description,  int quantity, int categoryId) {
        this.code = code;
        this.name = name;
        this.priceSell = priceSell;
        this.description = description;
        this.imagePath = imagePath;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPriceSell() {
        return priceSell;
    }

    public void setPriceSell(double priceSell) {
        this.priceSell = priceSell;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        return true;
    }

}

