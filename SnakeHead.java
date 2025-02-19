

public class SnakeHead extends Cell{
    public SnakeHead() {
        super();
    }

    public SnakeHead(int x, int y) {
        super(x, y);
    }

    @Override
    public String toString() {
        return "\u001B[33mS\u001B[0m";
    }
}
