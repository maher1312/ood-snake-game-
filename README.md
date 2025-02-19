# Snake Game

This is a console-based implementation of the classic **Snake Game** in Java. The game is designed to provide a simple yet engaging experience by combining object-oriented principles with clean design. It includes features like food, obstacles, a movable snake, and collision detection.

---

## Features

- **Dynamic Game Map:** A customizable grid that hosts the game.
- **Snake Mechanics:** A snake that moves across the map, grows upon consuming food, and ends the game on collision.
- **Interactive Gameplay:** Players control the snake using keyboard inputs.
- **Game Items:** Includes food (`F`), obstacles (`O`), and empty cells (` `).
- **Collision Logic:** Detects interactions between the snake and other items.
- **Win/Loss States:** The game ends with either a win or a loss message.

---

## Class Descriptions

### Core Classes
1. **`Cell` (Abstract Class):**  
   Represents a generic grid cell with x, y coordinates and overlap checking.
   - Subclasses: `EmptyCell`, `Food`, `Obstacle`, `SnakeHead`, `SnakeBodyCell`.

2. **`EmptyCell`:**  
   Represents an empty space on the map (` `).

3. **`Food`:**  
   Represents food items (`F`) that the snake consumes to grow.

4. **`Obstacle`:**  
   Represents obstacles (`O`) that end the game upon collision.

5. **`SnakeHead` and `SnakeBodyCell`:**  
   Represent the snake's head (`S`) and body (`s`).

---

### Gameplay Classes
1. **`Map`:**  
   Represents the game grid with methods to manage cells, check occupancy, and display the current map state.

2. **`Snake`:**  
   Handles the snake's body, direction, and movement.

3. **`Game`:**  
   Manages the gameplay, including item placement, collision handling, and game states.

4. **`driver`:**  
   The entry point for the application. Currently contains placeholder code for testing.

---

## How to Run

1. **Requirements:**
   - Java Development Kit (JDK) installed.
   - A terminal or IDE to run the program.

2. **Steps:**
   - Compile all the Java files:
     ```bash
     javac *.java
     ```
   - Run the `driver` class:
     ```bash
     java driver
     ```

---

## How to Play

- Use the keyboard to control the snake's movement (input integration in progress).
- Consume food (`F`) to grow.
- Avoid obstacles (`O`) and collisions with the snake's body.
- The game ends when:
  - The snake consumes all food items (win condition).
  - The snake collides with itself or an obstacle (loss condition).

---

## Future Enhancements

- Implement snake growth logic.
- Enable keyboard-based directional input.
- Add a scoring system.
- Enhance collision and boundary checks.
- Add graphical user interface (GUI) for better visualization.

---

## Project Files

- **Core Classes:**
  - [`Cell.java`](Cell.java) - Base class for all grid cells.
  - [`EmptyCell.java`](EmptyCell.java) - Represents an empty cell.
  - [`Food.java`](Food.java) - Represents food cells.
  - [`Obstacle.java`](Obstacle.java) - Represents obstacle cells.
  - [`SnakeHead.java`](SnakeHead.java) - Represents the snake's head.
  - [`SnakeBodyCell.java`](SnakeBodyCell.java) - Represents the snake's body.

- **Gameplay Classes:**
  - [`Game.java`](Game.java) - Core gameplay logic.
  - [`Map.java`](Map.java) - Game grid implementation.
  - [`Snake.java`](Snake.java) - Handles snake mechanics.

- **Driver:**
  - [`driver.java`](driver.java) - The entry point of the application.

---

## Authors

Developed as part of an educational or personal project.
- Madeleine FARAH
- Maher HALABI
- Elias-Charbel SALANEH

Feel free to contribute or modify the game as needed!
