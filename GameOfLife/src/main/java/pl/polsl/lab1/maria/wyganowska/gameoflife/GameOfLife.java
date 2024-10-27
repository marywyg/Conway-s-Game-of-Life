package pl.polsl.lab1.maria.wyganowska.gameoflife;
import pl.polsl.lab1.maria.wyganowska.gameoflife.view.ConsoleView;
import pl.polsl.lab1.maria.wyganowska.gameoflife.controller.Controller;
import pl.polsl.lab1.maria.wyganowska.gameoflife.model.Grid;
import java.util.Scanner;

/**
 * The main class for Game of Life program
 * @author Maria Wyganowska
 * @version 1.0
 */
public class GameOfLife {
    /**
     * Main method of the application
     * @param args Command line arguments, args[0] being the size of the grid represented by an intiger
     */
    public static void main(String[] args) {
        int gridSize = 02;
        if (args.length == 1) {
            try {
                gridSize = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid grid size provided as command line argument. Please enter an integer value.");
            }
        }
        if (gridSize <= 0) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.print("Please enter a valid grid size (positive integer): ");
                while (true) {
                    if (scanner.hasNextInt()) {
                        gridSize = scanner.nextInt();
                        if (gridSize > 0) {
                            break;
                        } else {
                            System.out.print("Invalid input. Please enter a positive integer: ");
                        }
                    } else {
                        System.out.print("Invalid input. Please enter a positive integer: ");
                        scanner.next();
                    }
                }
            }
        }
        Grid grid = new Grid(10);
        ConsoleView view = new ConsoleView(grid);
        Controller controller = new Controller(grid, view);
        controller.runMainMenu();
        
    }
}
