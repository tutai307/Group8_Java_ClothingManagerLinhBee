/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Admin
 */
public class OrderDetail {
    private String orderCode;
    private String customerCode;
    private String staffCode;
    private String productCode;
    private int quantity;


    public OrderDetail(String orderCode, String customerCode, String staffCode, String productCode, int quantity) {
        this.orderCode = orderCode;
        this.customerCode = customerCode;
        this.staffCode = staffCode;
        this.productCode = productCode;
        this.quantity = quantity;

    }

    public String getOrderCode() {
        return orderCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public String getStaffCode() {
        return staffCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public void setStaffCode(String staffCode) {
        this.staffCode = staffCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
