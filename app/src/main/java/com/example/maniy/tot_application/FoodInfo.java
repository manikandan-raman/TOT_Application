package com.example.maniy.tot_application;


public class FoodInfo {

    private String id;
    private String foodName1;
    private String foodName2;
    private String foodName3;
    private String foodQuantity1;
    private String foodQuantity2;
    private String foodQuantity3;


    public FoodInfo() {
    }

    public FoodInfo(String id, String foodName1, String foodName2, String foodName3, String foodQuantity1, String foodQuantity2, String foodQuantity3) {
        this.id = id;
        this.foodName1 = foodName1;
        this.foodName2 = foodName2;
        this.foodName3 = foodName3;
        this.foodQuantity1 = foodQuantity1;
        this.foodQuantity2 = foodQuantity2;
        this.foodQuantity3 = foodQuantity3;
    }

    public String getFoodName1() {
        return foodName1;
    }

    public String getFoodName2() {
        return foodName2;
    }

    public String getFoodName3() {
        return foodName3;
    }

    public String getFoodQuantity1() {
        return foodQuantity1;
    }

    public String getFoodQuantity2() {
        return foodQuantity2;
    }

    public String getFoodQuantity3() {
        return foodQuantity3;
    }
}
