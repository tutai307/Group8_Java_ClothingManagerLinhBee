/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Admin
 */
public class Distributor extends Person {
    private String imagePath;
    public Distributor() {
    }

    public Distributor(String imagePath) {
        this.imagePath = imagePath;
    }

    public Distributor(String imagePath, int id, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate) {
        super(id, code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.imagePath = imagePath;
    }

    public Distributor(String imagePath, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate) {
        super(code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    
    
}
