package com.myapplication.Model;

public class Car {

    private String id;
    private String name;
    private String value;
    private String placa;
    private int model;
    private String color;
    private String type;
    private String document;
    private String url;

    public Car() {
    }

    public Car(String id, String name, String value, String placa, int model, String color, String type, String document, String url) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.placa = placa;
        this.model = model;
        this.color = color;
        this.type = type;
        this.document = document;
        this.url = url;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
