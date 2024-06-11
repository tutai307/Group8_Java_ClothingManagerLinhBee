/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Admin
 */
public class Customer extends Person {
    public enum CustomerType {
        VIP, STUDENT, NORMAL
    }
    private String imagePath;
    private CustomerType customerType;

    public Customer(){
        super();
    }
    public Customer(String imagePath, CustomerType customerType) {
        this.imagePath = imagePath;
        this.customerType = customerType;
    }

    public Customer(int id, String imagePath, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate, Customer.CustomerType customerType) {
        super(id, code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.imagePath = imagePath;
        this.customerType = customerType;
    }

    public Customer(String imagePath, Customer.CustomerType customerType, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate) {
        super(code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.imagePath = imagePath;
        this.customerType = customerType;
    }
    
    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Person.count = count;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Customer.CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Customer.CustomerType customerType) {
        this.customerType = customerType;
    }

}
