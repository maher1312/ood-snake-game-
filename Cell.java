public abstract class Cell {
    private int x;
    private int y;

    public Cell() {
        this.x = 0;
        this.y = 0;
    }

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean checkOverlap(Cell cell) {
        return this.x == cell.getX() && this.y == cell.getY();
    }
    
    public boolean equals(Cell cell) {
        if (cell == null) {
            return false;
        }
        else if (cell.getClass() != this.getClass()) {
            return false;
        }
        else {
            return this.x == cell.getX() && this.y == cell.getY();
        }
    }
}