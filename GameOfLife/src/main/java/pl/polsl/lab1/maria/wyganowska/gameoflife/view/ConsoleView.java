package pl.polsl.lab1.maria.wyganowska.gameoflife.view;
import pl.polsl.lab1.maria.wyganowska.gameoflife.model.Grid;
/**
 * Class representing the view of the game which prints out the interface in a console
 * @version 1.0
 * @author Maria Wyganowska
 */
public class ConsoleView {
    private final Grid ConsoleGrid;
    /**
     * The constructor of ConsoleView, which sets up the initial grid
     * @param ConsoleGrid The initial grid
     */
    public ConsoleView(Grid ConsoleGrid){
        this.ConsoleGrid = ConsoleGrid;
    }
    /**
     * Method which displays the game's grid on the screen
     */
    public void displayGrid(){
        for (int row = 0; row < ConsoleGrid.getHeight(); row++) {
            for (int col = 0; col < ConsoleGrid.getWidth(); col++) {
                if (ConsoleGrid.getCell(row, col).getAliveStatus()) {
                    System.out.print("O");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
    /**
     * Method which displays the main menu of the game
     */
    public void printMainMenu(){
        System.out.println("Choose one of the following:");
        System.out.println("1. Start game 2. About 3. Change parameters 4. Exit");
        System.out.print("Your choice: ");
    }
    /**
     * Method which displays the menu after one iteration of applying the game's rules on grid's cells
     */
    public void printGameMenu(){
        System.out.println("1. Continue 2. Exit");
        System.out.print("Your choice: ");
    }
    /***
     * Method which displays an error message shown after entering incorrect data in one of the menus
     */
    public void printInputError(){
        System.out.print("Incorrect input, please try again: ");
    }
    /**
     * Method which displays the 'about' section in the options menu, containig basic information about the game's origin and rules
     */
    public void printAboutSection(){
        System.out.println("""
                           The Game of Life, also known as Conway's Game of Life or simply Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970.
                           It is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input.
                           Every cell interacts with its eight neighbors, which are the cells that are horizontally, vertically, or diagonally adjacent. At each step in time, the following transitions occur:
                           
                           1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
                           2. Any live cell with two or three live neighbours lives on to the next generation.
                           3. Any live cell with more than three live neighbours dies, as if by overpopulation.
                           4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
                           The initial pattern constitutes the seed of the system. The first generation is created by applying the above rules simultaneously to every cell in the seed, live or dead; births and deaths occur simultaneously.""");
    }
    /**
     * Method which displays the options menu
     */
    public void printOptionsSection(){
        System.out.println("1. Change grid's parameters 2. Change initial cells");
        System.out.print("Your choice: ");
    }
    /**
     * Method which displays the option's submenu, where the grid's parameters can be changed
     */
    public void printChangeGrid(){
        System.out.print("Please select the grid's width and height (max. 20): ");
    }
    /**
     * Method which displays the option's submenu, where the initial cell pattern can be changed
     */
    public void printChangeCells(){
        System.out.println("""
                           Please select one of the following (due to the console's limitations, only exemplificatory patterns are available):
                           1. Glider 2. Beacon 3. Toad 4. Blinker""");
        System.out.print("Your choice: ");
    }
}
