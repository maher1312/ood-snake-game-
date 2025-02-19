public class Obstacle extends Cell{
    public Obstacle() {
        super();
    }
    
    public Obstacle(int x, int y) {
        super(x, y);
    }
    
    @Override
    public String toString() {
        return "\u001B[31mO\u001B[0m";
    }
    
}
