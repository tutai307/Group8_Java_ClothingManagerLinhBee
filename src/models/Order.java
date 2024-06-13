/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Order {
    private int id;
    private String code;
    private String name;
    private String description;
    private String createDate;
    private int sumPrice;
    private List<OrderDetail> details;

    public Order(List<OrderDetail> details) {
        details = new ArrayList<>();
    }

    public Order(int id, String code, String name, String description, String createDate, int sumPrice, List<OrderDetail> details) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.sumPrice = sumPrice;
        this.details = new ArrayList<>();
    }

    public Order(String code, String name, String description, String createDate) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCreateDate() {
        return createDate;
    }

    public double getSumPrice() {
        return sumPrice;
    }

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }

    
}
