/*
    PizzaOrder.java
    Author: Nick De Luca
    Date: July 30th 2020
    Description
    This class defines the properties and attributes of the PizzaOrder object.
*/
package model;

import java.util.ArrayList;

/**
 * This class <enter description>
 * @author Nick De Luca
 */
public class PizzaOrder {

    private int pizzaNum;
    private int drinkNum;
    Drinks drink;
    PizzaSize size;
    ArrayList<Toppings> toppingList= new ArrayList();
    
     /**
     * Constructs an empty PizzaOrder object
     */
    public PizzaOrder() {
    }
    /**
     * Constructs a PizzaOrder of a specific pizzaNum and drinkNum.
     * @param pizzaNum the number of pizzas to add to order
     * @param drinkNum the number of drinks to add to order
     */
    public PizzaOrder(int pizzaNum, int drinkNum) {
            setPizzaNum(pizzaNum);
            setDrinkNum(drinkNum);
        if(pizzaNum ==0 && drinkNum ==0){
            throw new IllegalArgumentException("You must select at least one pizza or drink");  
        }
    }
    /**
     * gets the list of toppings to put on the pizza.
     * @return the topping list of type ArrayList
     */
    public ArrayList<Toppings> getToppingList() {
        return toppingList;
    }
    /**
     * sets the list of toppings to put on the pizza from a given order.
     * @param toppingList the ArrayList of toppings defined by the users order.
     */
    public void setToppingList(ArrayList<Toppings> toppingList) {
        this.toppingList = toppingList;
    }
    /**
     * gets the number of pizzas for the order.
     * @return the integer number of pizzas
     */
    public int getPizzaNum() {
        return pizzaNum;
    }
    /**
     * sets the number of pizzas for this order if user input is positive.
     * @param pizzaNum the given number of pizzas from the users order.
     */
    public void setPizzaNum(int pizzaNum) {
        if(pizzaNum > 0){
            this.pizzaNum = pizzaNum;
        }else if (pizzaNum != 0){
            throw new IllegalArgumentException("Pizza quantity cannot be negative"); 
        }      
    }
    /**
     * gets the number of drinks for the order.
     * @return the integer number of drinks
     */
    public int getDrinkNum() {
        return drinkNum;
    }

    /**
     * sets the number of drinks for this order is user input is positive.
     * @param drinkNum the given number of pizzas from the users order.
     */
    public void setDrinkNum(int drinkNum) {
        if(drinkNum > 0){
            this.drinkNum = drinkNum;
        }else if (drinkNum != 0){
            throw new IllegalArgumentException("Drink quantity cannot be negative"); 
        } 
    }
    /**
     * gets the defined drink enumeration object for this order.
     * @return the defined drink enumeration object 
     */
    public Drinks getDrink() {
        return drink;
    }
    /**
     * sets the defined drink enumeration object for this order.
     * @param drink the given drink enumeration object to set
     */
    public void setDrink(Drinks drink) {
        this.drink = drink;
    }
    /**
     * gets the defined size enumeration object for this order.
     * @return the defined size enumeration object 
     */
    public PizzaSize getSize() {
        return size;
    }
    /**
     * sets the defined size enumeration object for this order.
     * @param size the given size enumeration object to set
     */
    public void setSize(PizzaSize size) {
        this.size = size;
    }
    /**
     * The toString method for the pizzaOrder calculates totals, and 
     * organizes them into the first half of the receipt as a formatted string.
     * @return 
     */
    @Override
    public String toString() {
        String toppings = "";
        String pizzas;
        String drinks;
        String receipt = "";
        if(pizzaNum >0){
            pizzas = String.format("%-10s%25.2f\n   %d %s\n",
                    "Pizza:",
                    size.getPrice()*pizzaNum,
                    pizzaNum,size.toString());
            receipt += pizzas;
           
            double toppingTotal =0;
            for (Toppings pizzaTopping : toppingList) {
                toppings += "   " + pizzaNum + " " + pizzaTopping.toString()+"\n";
                toppingTotal += pizzaTopping.getPrice()*pizzaNum;
            }
            receipt += String.format("%-10s%25.2f\n%s","Toppings:", toppingTotal,toppings);
        }
        if(drinkNum >0){
            drinks = String.format("%-10s%25.2f\n   %d %s\n", 
                    "Drinks:",
                    drink.getPrice()*drinkNum,
                    drinkNum,drink.toString());
            receipt += drinks;
        } 
        return receipt;  
        
    }
}
