import java.util.ArrayList;

public class Snake {
    private ArrayList<Cell> body;
    private char direction;

    public Snake(ArrayList<Cell> body, char direction) {
        this.body = body;
        this.direction = direction;
    }

    public ArrayList<Cell> getBody() {
        return body;
    }

    public void setBody(ArrayList<Cell> body) {
        this.body = body;
    }

    public char getDirection() {
        return direction;
    }

    public void setDirection(char direction) {
        this.direction = direction;
    }
    
    public void move(char input) {
        int x = body.get(0).getX();
        int y = body.get(0).getY();
        switch (input) {
            case Direction.UP:
                body.add(0,new SnakeHead(x, y + 1));
                setDirection(input);
                break;
            case Direction.DOWN:
                body.add(0,new SnakeHead(x, y - 1));
                setDirection(input);
                break;
            case Direction.LEFT:
                body.add(0,new SnakeHead(x - 1, y));
                setDirection(input);
                break;
            case Direction.RIGHT:
                body.add(0,new SnakeHead(x + 1, y));
                setDirection(input);
                break;
            default:
                break;
            }
            body.set(1, new SnakeBodyCell(x, y));
            body.remove(body.size() - 1);
    }
    public void grow(char input) {
        int x = body.get(0).getX();
        int y = body.get(0).getY();
        switch (input) {
            case Direction.UP:
                body.add(0,new SnakeHead(x, y + 1));
                setDirection(input);
                break;
            case Direction.DOWN:
                body.add(0,new SnakeHead(x, y - 1));
                setDirection(input);
                break;
            case Direction.LEFT:
                setDirection(input);
                body.add(0,new SnakeHead(x - 1, y));
                break;
            case Direction.RIGHT:
                body.add(0,new SnakeHead(x + 1, y));
                setDirection(input);
                break;
            default:
                break;
            }
            body.set(1, new SnakeBodyCell(x, y));
    }
}
