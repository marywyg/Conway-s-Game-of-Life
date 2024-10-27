package pl.polsl.lab1.maria.wyganowska.gameoflife.model;

/**
 * Class representing a grid of alive and dead cells which is drawn on the screen
 * @author Maria Wyganowska
 * @version 1.0
 */
public class Grid {
    private int width;
    private int height;
    private Cell[][] gridOfCells;
    /**
     * The constructor of the Grid class which initializes the grid with default size parameter
     * @param size The default size of the grid
     */
    public Grid(int size) {
        this.width = size;
        this.height = size;
        gridOfCells = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                gridOfCells[i][j] = new Cell(false); // Initialize each cell
            }
        }
    }
    /**
     * Method which allows getting the coordinates of a specific single cell
     * @param y The number of rows in a grid (the height of a grid)
     * @param x The number of columns in a grid (the width of a grid)
     * @return The table representing the grid made of cells
     */
    public Cell getCell(int y, int x){
        return gridOfCells[y][x];
    }
    /**
     * Method which allows setting the status of a specific cell
     * @param y The number of rows in a grid (the height of a grid)
     * @param x The number of columns in a grid (the width of a grid)
     * @param AliveStatus The current status of a single cell (alive/dead)
     */
    public void setCellStatus(int y, int x, boolean AliveStatus){
        gridOfCells[y][x].setAliveStatus(AliveStatus);
    }
    /**
     * Method which counts the amount of specific cell's neighbours' "alive" statuses 
     * @param y The number of rows in a grid (the height of a grid)
     * @param x The number of columns in a grid (the width of a grid)
     * @return The amount of "alive" statuses counted in neighbouring cells
     */
    public int countAliveNeighbours(int y, int x){
        int aliveNeighbors = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int neighborY = y + i;
                int neighborX = x + j;

                if (neighborY >= 0 && neighborY < height && neighborX >= 0 && neighborX < width) {
                    if (gridOfCells[neighborY][neighborX].getAliveStatus()) {
                        aliveNeighbors++;
                    }
                }
            }
        }
        return aliveNeighbors;
    }
/**
 * Method which returns the current height of the grid
 * @return The grid's height (number of rows)
 */
    public int getHeight() {
        return height;
    }
/**
 * Method which returns the current width of the grid
 * @return The grid's width (number of columns)
 */
    public int getWidth() {
        return width;
    }
    /**
     * Method which updates cells in a grid according to the rules of Conway's Game of Life
     */
    public void updateState() {
        Cell[][] nextState = new Cell[height][width];
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                int aliveNeighbors = countAliveNeighbours(row, col);
                boolean isAlive = gridOfCells[row][col].getAliveStatus();
                if (isAlive && (aliveNeighbors < 2 || aliveNeighbors > 3)) {
                    nextState[row][col] = new Cell(false);
                } else if (!isAlive && aliveNeighbors == 3) {
                    nextState[row][col] = new Cell(true);
                } else {
                    nextState[row][col] = new Cell(isAlive);
                }
            }
        }
        gridOfCells = nextState;
    }
    /**
     * Method which resets the grid into a blank one (all of cells' statuses are set to "dead")
     */
    public void resetGrid() {
    for (int row = 0; row < height; row++) {
        for (int col = 0; col < width; col++) {
            gridOfCells[row][col].setAliveStatus(false);
        }
    }
    
}
    /**
     * Method which sets the grid's size
     * @param newSize The desired new size of the grid
     */
public void setSize(int newSize) {
    Cell[][] newGrid = new Cell[newSize][newSize];
        for (int y = 0; y < Math.min(height, newSize); y++) {
        System.arraycopy(gridOfCells[y], 0, newGrid[y], 0, Math.min(width, newSize));
        }
        for (int y = 0; y < newSize; y++) {
            for (int x = 0; x < newSize; x++) {
                if (newGrid[y][x] == null) {
                    newGrid[y][x] = new Cell(false);
                }
            }
        }
        this.gridOfCells = newGrid;
        this.height = newSize;
        this.width = newSize;
}
}
