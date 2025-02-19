public class Map {
    private final int height;
    private final int width;
    private final Cell[][] grid;
    
    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Cell[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[j][i] = new EmptyCell(i, j);
            }
        }
    }
    
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setCell(Cell cell) {
        grid[cell.getX()][cell.getY()] = cell;
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    public boolean cellNotEmpty(int x, int y) {
        return grid[x][y].getClass() != EmptyCell.class;
    }

    public String getCellType(int x, int y) {
        return grid[x][y].getClass().getName();
    }

    @Override
    public String toString() {
        for (int i = height - 1; i >= 0; i--) {
            for (int k = 0; k < width; k++) {
                System.out.print("+---+");
            }
            System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print("| " + grid[j][i] + " |");
            }
            System.out.println();
        }
        for (int i = 0; i < width; i++) {
            System.out.print("+---+");
        }
        System.out.println();
        return "";
    }
}
