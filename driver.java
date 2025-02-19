import java.util.ArrayList;

public class driver {
    public static void main(String[] args) {

        ArrayList<Cell> body = new ArrayList<>();
        Map map = new Map(10, 10);
        body.add(0, new SnakeHead(1, 1));
        body.add(1, new SnakeBodyCell(1, 0));
        body.add(2, new SnakeBodyCell(0, 0)); 
        map.setCell(new SnakeBodyCell(0, 0));
        map.setCell(new SnakeBodyCell(1, 0));
        map.setCell(new SnakeHead(1, 1));
        Snake snake = new Snake(body, Direction.UP);
        Game game = new Game(map, snake);
        game.play();

        // TODO: add exception handling

    }
}