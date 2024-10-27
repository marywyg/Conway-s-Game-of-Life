package pl.polsl.lab1.maria.wyganowska.gameoflife.model;

/**
 * Class representing a single cell in a grid
 * @author Maria Wyganowska
 * @version 1.0
 */
public class Cell {
   boolean AliveStatus;

/**
 * The constructor of a cell which initializes it with a specific status (dead/alive)
 * @param AliveStatus The boolean variable which indicates whether a specific cell is dead or alive
 */
public Cell(boolean AliveStatus) {
        this.AliveStatus = AliveStatus;
    }
/**
 * Method which switches the status of a single cell to an opposite one (alive/dead)
 */
public void switchAliveStatus(){
    AliveStatus = !AliveStatus;
}
/**
 * Method which returns the current status of a specific cell in a grid
 * @return Current status of a specific single cell
 */
public boolean getAliveStatus(){
    return AliveStatus;
}
/**
 * Method which sets the current status of a specific cell on a grid
 * @param AliveStatus The boolean variable which indicates whether a specific cell is dead or alive
 */
    public void setAliveStatus(boolean AliveStatus) {
        this.AliveStatus = AliveStatus;
    }
}