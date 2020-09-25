/*
    PizzeriaController.java
    Author: Nick De Luca
    Date: July 30th 2020
    Description
    This class controls the FXML nodes by accessing their fx:id values
    and implements Initializable
*/
package delunico;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.Drinks;
import model.PizzaOrder;
import model.PizzaSize;
import model.Toppings;

/**
 * FXML Controller class
 *
 * @author nicol
 */
public class PizzeriaController implements Initializable {

    @FXML
    private ToggleGroup grpSizes;
    @FXML
    private ToggleGroup grpDrinks;
    
    @FXML
    private MenuBar menuBar;
    @FXML
    private RadioButton optSmall;
    @FXML
    private RadioButton optMedium;
    @FXML
    private RadioButton optLarge;
    
    @FXML
    private CheckBox chkCheese;
    @FXML
    private CheckBox chkPep;
    @FXML
    private CheckBox chkMush;
    @FXML
    private CheckBox chkOlives;
    
    @FXML
    private RadioButton optCoke;
    @FXML
    private RadioButton optJuice;
    @FXML
    private RadioButton optChMilk;
   
    @FXML
    private VBox pnlSize;
    @FXML
    private VBox pnlToppings;
    @FXML
    private VBox pnlDrinks;
    @FXML
    private HBox pnlButtons;
    
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblSize;
    @FXML
    private Label lblToppings;
    @FXML
    private Label lblDrinks;
    @FXML
    private Label lblItems;
    
    @FXML
    private Button btnOk;
    @FXML
    private Button btnCancel;
    
    @FXML
    private TextField txfPizzaNum;
    @FXML
    private TextField txfDrinkNum;
    @FXML
    private TextArea txaOrder;
    
    ArrayList<Toppings> toppingList = new ArrayList();
    final double TAX_RATE = 0.13;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         pnlSize.getStyleClass().add("vbox");
         pnlToppings.getStyleClass().add("vbox");
         pnlDrinks.getStyleClass().add("vbox");    
         
         pnlButtons.getStyleClass().add("padButtons");
         lblSize.getStyleClass().add("padBottom");
         lblToppings.getStyleClass().add("padBottom");
         lblDrinks.getStyleClass().add("padBottom");         
    }    
    /**
     * This methods handles the action event for the exit button
     * @param event comes from the object that calls this action
     */
    @FXML
    private void handleExitAction(ActionEvent event) {
        System.exit(0);
    }
    /**
     * This method receives input, makes the PizzaOrder object and displays it
     * to the text-area.
     * @param event comes from the object that calls this action
     */
    @FXML
    private void makeOrder(ActionEvent event) {
        try {   
            int pizzaNum = 0;
            int drinkNum = 0;
            
            if(!txfPizzaNum.getText().trim().isEmpty()) { 
                pizzaNum = Integer.parseInt(txfPizzaNum.getText());
            }
            if(!txfDrinkNum.getText().trim().isEmpty()){     
                drinkNum = Integer.parseInt(txfDrinkNum.getText());
            }

            PizzaOrder order = new PizzaOrder(pizzaNum,drinkNum);
            order.getToppingList().clear();
            Drinks drink = getDrink();
            order.setDrink(drink);
            PizzaSize size = getSize();
            order.setSize(size);
            order.setToppingList(getToppings());
            System.out.println(order.toString());
            txaOrder.setText(order.toString()+calculate(order));
            
        }catch (NumberFormatException e){
            txaOrder.setText("Error: value entered must be a number");
        } catch (IllegalArgumentException i) {
            txaOrder.setText(i.getMessage());
        }
    }
    /**
     * This method clears all the values of 
     * pizza, toppings, drinks, and text-area
     * @param event comes from the object that calls this action
     */
    @FXML
    private void clearOrder(ActionEvent event) {
        chkPep.setSelected(false);
        chkMush.setSelected(false);
        chkCheese.setSelected(false);
        chkOlives.setSelected(false);

        optCoke.setSelected(false);
        optJuice.setSelected(false);
        optChMilk.setSelected(false);
        optSmall.setSelected(false);
        optMedium.setSelected(false);
        optLarge.setSelected(false);
        
        txfPizzaNum.clear();
        txfDrinkNum.clear();
        txaOrder.clear();
    }
    /**
     * This method gets the selected size of the size toggle group
     * @return the selected size enumeration object chosen by the user
     */
    private PizzaSize getSize(){
        PizzaSize size = null;
        if(grpSizes.getSelectedToggle()!=null){
            if(grpSizes.getSelectedToggle()==optSmall){
                size = PizzaSize.SMALL;
            }else if(grpSizes.getSelectedToggle()==optMedium){
                size = PizzaSize.MEDIUM;
            }else if(grpSizes.getSelectedToggle()==optLarge){
                size = PizzaSize.LARGE;
            }
        }
        return size;
    }
    /**
     * This method gets the selected drink of the drink toggle group
     * @return the selected drink enumerations chosen by the user
     */
    private Drinks getDrink(){
        Drinks drink = null;
        if(grpDrinks.getSelectedToggle()!=null){
            if(grpDrinks.getSelectedToggle()==optCoke){
                drink = Drinks.COKE;
            }else if(grpDrinks.getSelectedToggle()==optJuice){
                drink = Drinks.JUICE;
            }else if(grpDrinks.getSelectedToggle()==optChMilk){
                drink = Drinks.CHOCOLATE_MILK;
            }
        }
        return drink;
    }
    /**
     * This method gets all the selected toppings from the topping check-boxes
     * and returns them together in an ArrayList.
     * @return an ArrayList of all the selected toppings
     */
    private ArrayList<Toppings> getToppings() {
        toppingList.clear();
        if(chkPep.isSelected()){
            Toppings pepperoni = Toppings.PEPPERONI;
            toppingList.add(pepperoni);
        }
        if(chkMush.isSelected()){
            Toppings mushroom = Toppings.MUSHROOM;
            toppingList.add(mushroom);
        } 
        if(chkCheese.isSelected()){
            Toppings cheese = Toppings.CHEESE;
            toppingList.add(cheese);
        }
        if(chkOlives.isSelected()){
            Toppings olives = Toppings.OLIVES;
            toppingList.add(olives);
        }
        return toppingList;
    }
    /**
     * This method calculates the subtotal, hst, and total for the second half 
     * of the receipt
     * Afterwards it organizes them into a formatted string.
     * @param order the pizzaOrder object to use for calculations
     * @return a formatted string containing all the calculations 
     */
    private String calculate (PizzaOrder order){
        double subTotal =0;
        if(order.getPizzaNum()>0){
            subTotal = order.getPizzaNum()*order.getSize().getPrice();
        }
        if (order.getDrinkNum()>0) {
            subTotal += order.getDrinkNum()*order.getDrink().getPrice();
        }
        if (order.getToppingList().size() > 0) {  
            for (Toppings toppings : toppingList) {
                subTotal += toppings.getPrice()*order.getPizzaNum();
            }
        }
        double hst = subTotal * TAX_RATE;
        String calculate = String.format("%s\n%-10s%25.2f\n%-10s%25.2f\n%-10s%25.2f",
                "===================================","Subtotal:",subTotal,"HST:",hst,"Total:",subTotal+hst);
        
        return calculate;
    }
}
