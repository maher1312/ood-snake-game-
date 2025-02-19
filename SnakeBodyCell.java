public class SnakeBodyCell extends Cell{
    public SnakeBodyCell() {
        super();
    }
    
    public SnakeBodyCell(int x, int y) {
        super(x, y);
    }
    
    @Override
    public String toString() {
        return "\u001B[32m" + "s" + "\u001B[0m";
    }
    
}
