public class EmptyCell extends Cell{
    public EmptyCell() {
        super();
    }
    
    public EmptyCell(int x, int y) {
        super(x, y);
    }
    
    @Override
    public String toString() {
        return " ";
    }

}