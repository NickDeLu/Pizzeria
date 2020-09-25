/*
    Drinks.java
    Author: Nick De Luca
    Date: July 30th 2020
    Description
    This Enummeration class defines enums for types of drinks and their price.
*/
package model;

/**
 * This enumeration defines Drinks
 * @author nicol
 */
public enum Drinks {
    
    COKE (1.25,"Coke"), 
    JUICE (1.95,"Juice"), 
    CHOCOLATE_MILK (2.25,"Chocolate Milk"); 
   
    private double price;
    private String name;
    /**
     * This constructor instantiates a Drinks enumeration object with a given
     * price and a given name. 
     * @param price the given price to set
     * @param name the given name to set
     */
    private Drinks(double price,String name){
        this.price = price;
        this.name = name;
    }
    /**
     * gets the price of the Drinks enumeration object
     * @return the price of this enumeration object.
     */
    public double getPrice() {
        return price;
    }
    /**
     * gets the name of the Drinks enumeration object
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
