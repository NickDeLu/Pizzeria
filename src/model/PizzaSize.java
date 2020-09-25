/*
    PizzaSize.java
    Author: Nick De Luca
    Date: July 30th 2020
    Description
    This Enummeration class defines enums for sizes of Pizza and their prices.
*/
package model;

/**
 * This enumeration defines PizzaSizes
 * @author nicol
 */
public enum PizzaSize {
   
    SMALL (5.25,"Small"), 
    MEDIUM (7.50, "Medium"), 
    LARGE (9.95, "Large"); 
   
    private double price;
    private String name;
    /**
     * This constructor instantiates a PizzaSize enumeration object with a given
     * price and a given name. 
     * @param price the given price to set
     * @param name the given name to set
     */
    private PizzaSize(double price,String name){
        this.price = price;
        this.name = name;
    }
    /**
     * gets the price of the PizzaSize enumeration object
     * @return the price of this enumeration object.
     */
    public double getPrice() {
        return price;
    }
    /**
     * gets the name of the PizzaSize enumeration object
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
