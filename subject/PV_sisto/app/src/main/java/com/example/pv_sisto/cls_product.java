package com.example.pv_sisto;

public class cls_product {
    public cls_product(int code, String name, Double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }
    public cls_product() {
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private int code;
    private String name;
    private Double price;

}
