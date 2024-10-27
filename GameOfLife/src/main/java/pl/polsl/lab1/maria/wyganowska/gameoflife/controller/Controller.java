package pl.polsl.lab1.maria.wyganowska.gameoflife.controller;
import pl.polsl.lab1.maria.wyganowska.gameoflife.model.Grid;
import pl.polsl.lab1.maria.wyganowska.gameoflife.view.ConsoleView;
import pl.polsl.lab1.maria.wyganowska.gameoflife.model.User;
import java.util.Scanner;
/**
 * Class representing the controller which acts as an intermediary between the model classes and the view
 * @author Maria Wyganowska
 * @version 1.0
 */
public class Controller {
    private final Grid grid;
    private final ConsoleView view;
    private final Scanner controllerScanner;
    private final User user;
    private boolean correctInput;
    private int maxChoiceNumber;
    private final int minChoiceNumber;
    /**
     * The constructor of the Controller class, which sets up all elements needed for running the program
     * @param grid The grid used in the program
     * @param view The view used for displaying the application
     */
    public Controller(Grid grid, ConsoleView view) {
        this.grid = grid;
        this.view = view;
        this.controllerScanner = new Scanner(System.in);
        this.user = new User();
        correctInput = false;
        maxChoiceNumber = 3;
        minChoiceNumber = 1;
    }
/**
 * Method which handles the main game loop and communication between the view and the model during playing
 */
    private void runGame() {
        boolean continueGame = true;
        while (continueGame) {
            view.displayGrid();
            view.printGameMenu();
            maxChoiceNumber = 2;
            correctInput = false;
            while(!correctInput){
                try{
                    user.setInput(controllerScanner.nextInt());
                    user.validateInput(maxChoiceNumber, minChoiceNumber);
                    correctInput = true;
                }
                catch(IllegalArgumentException e){
                    view.printInputError();
                    controllerScanner.nextLine();
                }
                catch(Exception e){
                    view.printInputError();
                    controllerScanner.nextLine();
                }
            }
            switch(user.getInput()){
                case 1 -> {
                    grid.updateState(); 
                    continueGame = true;
                }
                case 2 -> {
                    continueGame = false;
                    grid.resetGrid();
                    runMainMenu();
                }
            }
        }
    }
    /**
     * Method which handles showing the main menu of the game and inputs given by user
     */
    public void runMainMenu(){
        maxChoiceNumber = 4;
        view.printMainMenu();
        correctInput = false;
            while(!correctInput){
                try{
                    user.setInput(controllerScanner.nextInt());
                    user.validateInput(maxChoiceNumber, minChoiceNumber);
                    correctInput = true;
                }
                catch(IllegalArgumentException e){
                    view.printInputError();
                    controllerScanner.nextLine();
                }
                catch(Exception e){
                    view.printInputError();
                    controllerScanner.nextLine();
                }
            }
            switch(user.getInput()){
                case 1 -> {
                    runGame();
                }
                case 2 -> {
                    view.printAboutSection();
                    runMainMenu();
                }
                case 3 ->{
                    runOptionsMenu();
                }
                case 4 ->{
                    System.out.println("Exiting program...");
                }
            }
    }
    /**
     * Method which handles running the options menu and what to do with user's input
     */
    private void runOptionsMenu(){
    view.printOptionsSection();
    correctInput = false;
    while(!correctInput){
        try{
            user.setInput(controllerScanner.nextInt());
            user.validateInput(2, 1);
            correctInput = true;
        } catch (Exception e) {
            view.printInputError();
            controllerScanner.nextLine();
        }
    }
    switch(user.getInput()){
        case 1 -> changeGridParameters();
        case 2 -> changeCellPattern();
    }
}
/**
 * Method which handles the submenu where the initial cell pattern can be changed
 */
private void changeCellPattern(){
    view.printChangeCells();
            correctInput = false;
            maxChoiceNumber = 4;
            while(!correctInput){
                try{
                    user.setInput(controllerScanner.nextInt());
                    user.validateInput(maxChoiceNumber, 1);
                    correctInput = true;
                } 
                catch (Exception e) {
                    view.printInputError();
                    controllerScanner.nextLine();
                }   
            }
            changePattern(user.getInput());
            runMainMenu();
}
/**
 * Method which handles the submenu where the grid size can be changed
 */
private void changeGridParameters() {
    view.printChangeGrid();
    correctInput = false;
    maxChoiceNumber = 20;

    while (!correctInput) {
        try {
            user.setInput(controllerScanner.nextInt());
            user.validateInput(maxChoiceNumber, 5);
            user.setDesiredSize(user.getInput());
            correctInput = true;
        } catch (Exception e) {
            view.printInputError();
            controllerScanner.nextLine();
        }
    }
    grid.setSize(user.getDesiredSize());
    runMainMenu();
}
/**
 * Method which changes the initial pattern of cells on a grid
 * @param choice The number of a pattern chosen by the user in options menu
 */
private void changePattern(int choice){
    switch(choice){
        case 1 ->{
        grid.setCellStatus(1, 2, true);
        grid.setCellStatus(2, 3, true);
        grid.setCellStatus(3, 1, true);
        grid.setCellStatus(3, 2, true);
        grid.setCellStatus(3, 3, true);
        }
        case 2 ->{
        grid.setCellStatus(1, 1, true);
        grid.setCellStatus(1, 2, true);
        grid.setCellStatus(2, 1, true);
        grid.setCellStatus(2, 2, true);
        grid.setCellStatus(3, 3, true);
        grid.setCellStatus(3, 4, true);
        grid.setCellStatus(4, 3, true);
        grid.setCellStatus(4, 4, true);
        }
        case 3 ->{
        grid.setCellStatus(2, 2, true);
        grid.setCellStatus(2, 3, true);
        grid.setCellStatus(2, 4, true);
        grid.setCellStatus(3, 1, true);
        grid.setCellStatus(3, 2, true);
        grid.setCellStatus(3, 3, true);
        }
        case 4 ->{
        grid.setCellStatus(3, 2, true);
        grid.setCellStatus(3, 3, true);
        grid.setCellStatus(3, 4, true);
        }
    }
}
}