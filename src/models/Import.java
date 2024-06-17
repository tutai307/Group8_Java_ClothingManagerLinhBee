/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.ArrayList;
import java.util.List;

public class Import {
    private int id;
    private String code;
    private String name;
    private String description;
    private String createDate;
    private List<ImportDetail> details;
    public Import() {
        details = new ArrayList<>();
    }

    public Import(String code, String name, String description, String createDate) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.details = new ArrayList<>();
    }
    
    public Import(int id, String code, String name, String description, String createDate) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.createDate = createDate;
        this.details = new ArrayList<>();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public List<ImportDetail> getDetails() {
        return details;
    }

    public void setDetails(List<ImportDetail> details) {
        this.details = details;
    }

    public void addDetail(ImportDetail detail) {
        this.details.add(detail);
    }  
}
