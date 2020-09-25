/*
    Toppings.java
    Author: Nick De Luca
    Date: July 30th 2020
    Description
    This Enummeration class defines enums for the 
    toppings on Pizza and their price.
*/
package model;

/**
 * This enumeration defines Toppings 
 * @author nicol
 */
public enum Toppings {
    
    CHEESE (1.00,"Cheese"), 
    MUSHROOM (1.25,"Mushrooms"), 
    OLIVES (1.50,"Olives"),
    PEPPERONI (1.75,"Pepperoni");
   
    private double price;
    private String name;
    /**
     * This constructor instantiates a Toppings enumeration object with a given
     * price and a given name. 
     * @param price the given price to set
     * @param name the given name to set
     */
    private Toppings(double price,String name){
        this.price = price;
        this.name = name;
    }
    /**
     * gets the price of the Toppings enumeration object
     * @return the price of this enumeration object.
     */
    public double getPrice() {
        return price;
    }
    /**
     * gets the name of the Toppings enumeration object
     * @return the name of this enumeration object
     */
    public String getName() {
        return name;
    }
    /**
     * The toString method that uses a formatted string to display the name 
     * and the price.
     * @return 
     */
    @Override
    public String toString() {
        return String.format("%s @ %.2f",this.getName(),this.getPrice());
    }
}
