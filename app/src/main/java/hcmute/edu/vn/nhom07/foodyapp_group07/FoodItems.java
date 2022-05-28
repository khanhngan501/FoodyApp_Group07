package hcmute.edu.vn.nhom07.foodyapp_group07;

import java.io.Serializable;

public class FoodItems implements Serializable {
    private String foodName;
    private String foodImg;
    private int foodSalePercent;
    private String foodNormalPrice;
    private String foodSalePrice;
    private boolean isDeal;

    public boolean getIsDeal() {
        return isDeal;
    }

    public void setIsDeal(boolean isDeal) {
        this.isDeal = isDeal;
    }

    public FoodItems(String foodName, String foodImg, int foodSalePercent, String foodNormalPrice, String foodSalePrice, boolean isDeal) {
        this.foodName = foodName;
        this.foodImg = foodImg;
        this.foodSalePercent = foodSalePercent;
        this.foodNormalPrice = foodNormalPrice;
        this.foodSalePrice = foodSalePrice;
        this.isDeal = isDeal;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodImg() {
        return foodImg;
    }

    public void setFoodImg(String foodImg) {
        this.foodImg = foodImg;
    }

    public int getFoodSalePercent() {
        return foodSalePercent;
    }

    public void setFoodSalePercent(int foodSalePercent) {
        this.foodSalePercent = foodSalePercent;
    }

    public String getFoodNormalPrice() {
        return foodNormalPrice;
    }

    public void setFoodNormalPrice(String foodNormalPrice) {
        this.foodNormalPrice = foodNormalPrice;
    }

    public String getFoodSalePrice() {
        return foodSalePrice;
    }

    public void setFoodSalePrice(String foodSalePrice) {
        this.foodSalePrice = foodSalePrice;
    }
}
