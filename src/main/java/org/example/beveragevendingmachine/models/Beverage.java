package org.example.beveragevendingmachine.models;

import lombok.Getter;
import lombok.Setter;
import org.example.beveragevendingmachine.exceptions.InsufficientIngredientException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter
@Setter
public class Beverage extends BaseModel{

    private String beverageName;
    private Map<Ingredient, Integer> ingredientQuantityMap;

    public Beverage(String beverageName){
        this.beverageName = beverageName;
        this.ingredientQuantityMap = new HashMap<>();
    }

    public void addIngredient(Ingredient ingredient, Integer quantity){
        this.ingredientQuantityMap.put(ingredient, quantity);
    }

    public void canBePrepared() throws InsufficientIngredientException {
        for(Map.Entry<Ingredient, Integer> entry : this.ingredientQuantityMap.entrySet()){
            if(entry.getKey().getQuantity() < entry.getValue()){
                throw new InsufficientIngredientException(this.beverageName + " cannot be prepared because " + entry.getKey().getIngredientName() + " is not sufficient");
            }
        }
    }

    public void prepareBeverage(){
        try{
            this.canBePrepared();
            for(Map.Entry<Ingredient, Integer> entry : this.ingredientQuantityMap.entrySet()){
                entry.getKey().setQuantity(entry.getKey().getQuantity() - entry.getValue());
            }
            System.out.println(this.beverageName + " is prepared");
        } catch (InsufficientIngredientException e) {
            System.out.println(e.getMessage());
        }
    }

}
