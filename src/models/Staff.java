/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author Admin
 */
public class Staff extends Person{
    private String imagePath;
    private int accountId;
    private String position;
    public Staff(){
        super();
    }

    public Staff(String imagePath, int accountId, String position) {
        this.imagePath = imagePath;
        this.accountId = accountId;
        this.position = position;
    }

    public Staff(int id, String imagePath, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate, int accountId, String position) {
        super(id, code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.imagePath = imagePath;
        this.accountId = accountId;
        this.position = position;
    }

    public Staff(String imagePath, int accountId, String position, String code, String firstName, String lastName, String address, String phoneNumber, String email, String birthDate) {
        super(code, firstName, lastName, address, phoneNumber, email, birthDate);
        this.imagePath = imagePath;
        this.accountId = accountId;
        this.position = position;
    }

    

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
    
}
