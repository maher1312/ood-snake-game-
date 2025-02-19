import java.util.ArrayList;
import java.util.Scanner;
public class Game {
    private int nbOfFood;
    private int nbOfObstacles;
    private Map map;
    private Snake snake;
    private ArrayList<Cell> activeItems;
    private char input;
    private String isOver;

    public void setInput(char input) {
        this.input = input;
    }

    public char getInput() {
        return input;
    }

    public void setIsOver(String isOver) {
        this.isOver = isOver;
    }

    public String getIsOver() {
        return isOver;
    }

    public Game(Map map, Snake snake) {
        this.nbOfFood = 4 * map.getHeight() * map.getWidth() / (map.getWidth()+map.getHeight());
        this.nbOfObstacles = 4 * map.getHeight() * map.getWidth() / (map.getWidth()+map.getHeight());
        this.map = map;
        this.snake = snake;
        this.activeItems = new ArrayList<>();
        for(int i = 0; i < nbOfFood + nbOfObstacles; i++) {
            int x, y;
            Cell cell;
            do {
                x = (int) (Math.random() * map.getWidth());
                y = (int) (Math.random() * map.getHeight());
            } while ( x > map.getWidth()-1 || y >map.getHeight()-1 || map.cellNotEmpty(x, y));
            
            if (i < nbOfFood) {
                cell = new Food(x, y);
            } else {
                cell = new Obstacle(x, y);
            }
            activeItems.add(cell);
            map.setCell(cell);
        }
    }

    public void play() {
        setIsOver("continue");
        System.out.println(map.toString());
        while (isOver == "continue") {
            handleInput();
            checkCollision(input);
            if (noFoodLeft()) {
                System.out.println(map.toString()+"\n\nNo more food left!");
                endGame(true);
            }
            if (isOver == "lose") {
                System.out.println("Game Over!");
                break;
            }
            else if (isOver == "win") {
                System.out.println("You Win!");
                break;
            }
            System.out.println(map.toString());
            
        }
        System.out.println("Let's start of a new game!");
    }
    
    public void checkCollision(char input) { 
        // delay in x and y position
        // update hypothetical position first then check for collision
        int x_tmp = snake.getBody().get(0).getX();
        int y_tmp = snake.getBody().get(0).getY();
        switch (input) {
            case Direction.UP: y_tmp++; break;
            case Direction.DOWN: y_tmp--; break;
            case Direction.LEFT: x_tmp--; break;
            case Direction.RIGHT: x_tmp++; break;
            default: break;
        }
        Cell cell_tmp = new SnakeHead(x_tmp, y_tmp); // temporary cell to check potential collision

        if (noFoodLeft()) {
            System.out.println("No more food left!");
            endGame(true); // if no food left, end game
        }
        else if (cell_tmp.getX() < 0 || cell_tmp.getX() >= map.getWidth() || cell_tmp.getY() < 0 || cell_tmp.getY() >= map.getHeight()) {
            System.out.println("Out of bounds!");
            endGame(false); // if snake hits wall, end game
        }
        else if ( (snake.getDirection() == Direction.UP && input == Direction.DOWN) || 
                    (snake.getDirection() == Direction.DOWN && input == Direction.UP) || 
                    (snake.getDirection() == Direction.LEFT && input == Direction.RIGHT) || 
                    (snake.getDirection() == Direction.RIGHT && input == Direction.LEFT)) {
                        System.out.println("Wrong direction! The Snake ate its head.");
                        endGame(false); // if snake hits itself, end game
                        } 
        else if (map.getCellType(x_tmp, y_tmp) == SnakeBodyCell.class.getName()) {
            System.out.println("Wrong direction! The Snake ate its body.");
            endGame(false); // if snake hits itself, end game
        }
        else if(map.getCellType(x_tmp, y_tmp).equals(EmptyCell.class.getName())){
            System.out.println("The snake is moving to an empty cell.");
            map.setCell(new SnakeHead(x_tmp, y_tmp));
            map.setCell(new SnakeBodyCell(
                snake.getBody().get(0).getX(),
                snake.getBody().get(0).getY()
                ));
                map.setCell(new EmptyCell(snake.getBody().get(snake.getBody().size() - 1).getX(),
                                snake.getBody().get(snake.getBody().size() - 1).getY()));
                snake.move(input); // if snake moves to empty cell, move
                    } 
                    else {
                        for (Cell cell : activeItems) {
                            if (cell_tmp.checkOverlap(cell)) {
                                if (cell.getClass() == Food.class) {
                                    nbOfFood--;
                                    System.out.println("The snake ate the food!"); 
                                    snake.grow(input); // if snake eats food, grow 
                                    
                                    map.setCell(new SnakeHead(cell.getX(), cell.getY()));
                                    map.setCell(new SnakeBodyCell(
                                        snake.getBody().get(1).getX(),
                                        snake.getBody().get(1).getY()
                                        ));
                                } else {
                                    System.out.println("Wrong direction! The Snake hit an obstacle.");
                                    endGame(false); // if snake hits obstacle, end game
                                }
                            }
                        }
                        activeItems.remove(cell_tmp);
                    }
    }

    public void endGame(boolean state){
        if(state){
            setIsOver("win");
        } else {
            setIsOver("lose");
        }
    }

    public boolean noFoodLeft() {
        return nbOfFood == 0;
    }

    public void handleInput() {
        do {
            input = ' ';
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter direction (WASD): ");
            if (scanner.hasNext()) {
                input = scanner.next().charAt(0);
                input = Character.toUpperCase(input);
            } else {
                scanner.close();
                System.out.println("No input provided!");
            }
        } while (input != Direction.UP && input != Direction.DOWN && input != Direction.LEFT && input != Direction.RIGHT);
        setInput(input);
        }        
    }

