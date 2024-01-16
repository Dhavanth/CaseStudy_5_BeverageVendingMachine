package org.example.beveragevendingmachine;

import org.example.beveragevendingmachine.models.Beverage;
import org.example.beveragevendingmachine.models.Ingredient;
import org.example.beveragevendingmachine.models.Outlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeverageVendingMachineApplication {

    public static void main(String[] args) {
        Ingredient water = new Ingredient("Hot Water", 500, 100);
        Ingredient milk = new Ingredient("Hot Milk", 500, 100);
        Ingredient teaPowder = new Ingredient("Tea powder", 100, 10);
        Ingredient coffeeBeans = new Ingredient("Coffee beans", 100, 10);

        Beverage hotTea = new Beverage("Hot Tea");
        hotTea.addIngredient(water, 100);
        hotTea.addIngredient(milk, 100);
        hotTea.addIngredient(teaPowder, 50);

        Beverage hotCoffee = new Beverage("Hot Coffee");
        hotCoffee.addIngredient(water, 100);
        hotCoffee.addIngredient(milk, 400);
        hotCoffee.addIngredient(coffeeBeans, 50);

        Outlet outlet1 = new Outlet(1);
        Outlet outlet2 = new Outlet(2);

        outlet1.serveBeverage(hotTea);
        outlet2.serveBeverage(hotCoffee);

        // If ingredients are of low quantity, alert the user
        if(water.checkLowQuantity()){
            water.alertLowQuantity();
            water.refillIngredient(500);
        }
        if(milk.checkLowQuantity()){
            milk.alertLowQuantity();
            milk.refillIngredient(500);
        }
        if(teaPowder.checkLowQuantity()){
            teaPowder.alertLowQuantity();
            teaPowder.refillIngredient(100);
        }
        if(coffeeBeans.checkLowQuantity()){
            coffeeBeans.alertLowQuantity();
            coffeeBeans.refillIngredient(100);
        }

        SpringApplication.run(BeverageVendingMachineApplication.class, args);
    }

}
