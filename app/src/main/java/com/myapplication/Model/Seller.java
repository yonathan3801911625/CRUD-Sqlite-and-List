package com.myapplication.Model;

public class Seller {
    private String document;
    private String name;
    private int type;
    private String area;
    private String sucursal;
    private String telephone;
    private String email;

    public Seller() {
    }

    public Seller(String document, String name, int type, String area, String sucursal, String telephone, String email) {
        this.document = document;
        this.name = name;
        this.type = type;
        this.area = area;
        this.sucursal = sucursal;
        this.telephone = telephone;
        this.email = email;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
