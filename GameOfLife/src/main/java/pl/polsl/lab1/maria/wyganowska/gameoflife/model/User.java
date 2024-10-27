package pl.polsl.lab1.maria.wyganowska.gameoflife.model;
/**
 * Class which manages the information given by a user
 * @author Maria Wyganowska
 * @version 1.0
 */

public class User {
   /**
    * The integer storing the user's input (all menus use integers to navigate/set parameters)
    */
    public int input;
    private int desiredSize;
    /**
     * The default constructor of the User class
     */
    public User(){
        input = 0;
        desiredSize = 10;
    }
  /**
   * Method which returns the width of a grid desired by the user
   * @return The width of a grid desired by the user
   */
    public int getDesiredSize(){
        return desiredSize;
    }
/**
 * Method which sets the size of a grid desired by the user
 * @param desiredSize The size of a grid entered by a user represented by an integer
 */
    public void setDesiredSize(int desiredSize) {
        this.desiredSize = desiredSize;
    }
    /**
     * Method which returns the currently saved input entered by the user
     * @return The saved input entered by a user
     */
    public int getInput(){
        return input;
    }
    /**
     * Method which sets given intiger as user's input
     * @param in Integer entered by a user
     */
    public void setInput(int in){
        this.input = in; 
    }
    /**
     * Method which validates whether the input entered by the user is an actual option in a menu
     * @param maxChoice The maximum number that can be selected in a menu
     * @param minChoice The minimum number that can be selected in a menu
     */
    public void validateInput(int maxChoice, int minChoice){
        if(input < minChoice || input > maxChoice){
                        throw new IllegalArgumentException("invalid_choice");
                    }
    }
}