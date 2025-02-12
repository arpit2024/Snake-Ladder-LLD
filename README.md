# Snake and Ladder - Low-Level Design (LLD)

## Overview
Snake and Ladder is a classic board game played by two players (or one player and a bot). The game consists of a board with 100 cells, numbered from 1 to 100. Players roll a six-sided dice to move forward, encountering snakes and ladders that either move them down or up the board. The player who reaches exactly 100 first wins the game.

## Game Rules
1. The board consists of **100 cells** numbered from **1 to 100**.
2. Players must choose **unique symbols**.
3. **Snakes and Ladders** are placed at specific cells:
   - **Snakes:** Landing on a snake’s head moves the player down to its tail.
   - **Ladders:** Landing at the bottom of a ladder moves the player to the top.
4. Players roll a **6-sided dice** to move forward.
5. A **random player** starts the game.
6. The first player to reach **exactly 100 wins**.
7. The game checks for a winner after each dice roll.

## Class Diagram

![**Class Diagram**](https://github.com/user-attachments/assets/6be8915c-7e07-4d44-9ec1-87b3cb47b8f2)

### 1. **Game**
Manages the game flow, players, board, and dice.
```java
class Game {
    private Board board;
    private List<Player> playerList;
    private int nextPlayerIndex;
    private Dice dice;
    private GameState gameState;
    private Scanner scanner;

    public void startGame();
}
```

### 2. **Board**
Represents the game board with snakes and ladders.
```java
class Board {
    private int size;
    private Map<Integer, Integer> jumps;

    public int getNewPosition(int currentPosition);
}
```

### 3. **Player**
Represents a player in the game.
```java
class Player {
    private int id;
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private int position;
}
```

#### **HumanPlayer (Extends Player)**
```java
class HumanPlayer extends Player {}
```

#### **BotPlayer (Extends Player)**
```java
class BotPlayer extends Player {}
```

### 4. **Symbol**
Represents the symbol chosen by a player.
```java
class Symbol {
    char A;
    char B;
}
```

### 5. **PlayerType (Enum)**
Defines the type of player (Human or Bot).
```java
enum PlayerType {
    HUMAN,
    BOT
}
```

### 6. **GameState (Enum)**
Tracks the game status.
```java
enum GameState {
    IN_PROGRESS,
    SUCCESS
}
```

### 7. **Dice**
Simulates the rolling of a dice.
```java
class Dice {
    public int roll();
}
```

### 8. **Snake**
Represents a snake on the board.
```java
class Snake {
    private int start;
    private int end;
}
```

### 9. **Ladder**
Represents a ladder on the board.
```java
class Ladder {
    private int start;
    private int end;
}
```

### 10. **Cell**
Represents a single cell on the board.
```java
class Cell {
    private int number;
    private int jumpTo;
}
```

### 11. **SnakeAndLadder (Main Class)**
```java
class SnakeAndLadder {
    public static void main(String[] args);
}
```

## Class Associations
- **Game** aggregates **Board**, **Dice**, and manages **Players**.
- **Player** has a composition with **Symbol** and **PlayerType**.
- **Board** contains **Cells**, **Snakes**, **Ladders**, and uses **Dice**.
- **Cell** references **Symbol**.

## How to Run the Game
1. Create instances of **Game**, **Board**, **Dice**, and **Players**.
2. Call the `startGame()` method to begin.
3. The game continues until a player reaches cell **100**.

## Future Enhancements
- Allow multiple players (more than 2).
- Implement a GUI-based version.
- Add difficulty levels for bot players.
