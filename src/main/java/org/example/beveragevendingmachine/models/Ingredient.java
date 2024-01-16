package org.example.beveragevendingmachine.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingredient extends BaseModel{

    private String ingredientName;
    private Integer quantity;
    private Integer threshold;

    public Ingredient(String ingredientName, Integer quantity, Integer threshold) {
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.threshold = threshold;
    }

    public boolean checkLowQuantity(){
        return this.quantity <= this.threshold;
    }

    public void alertLowQuantity(){
        if(this.checkLowQuantity()){
            System.out.println(this.ingredientName + " is running low. Current quantity is " + this.quantity);
        }
    }

    public void refillIngredient(Integer quantity){
        this.quantity += quantity;
        System.out.println(this.ingredientName + " is refilled. Current quantity is " + this.quantity);
    }
}
