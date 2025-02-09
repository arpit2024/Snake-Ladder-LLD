import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    public static int size;
    Map<Integer, Integer> jumps; // Mapping of start position to new position

    public Board(int size, List<Snake> snakes, List<Ladder> ladders) {
        this.size = size;
        this.jumps = new HashMap<>();

        for (Snake snake : snakes) {
            jumps.put(snake.start, snake.end);
        }

        for (Ladder ladder : ladders) {
            jumps.put(ladder.start, ladder.end);
        }
    }

    public int getNewPosition(int position) {
        return jumps.getOrDefault(position, position); // If snake/ladder exists, move; otherwise stay
    }


}

//assign snakes
//assign ladders
//initialize board with cells 1<=size
