import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnakeAndLadder {
    public static void main(String args[]){

        Scanner sc=new Scanner(System.in);
        List<Player> players=new ArrayList<>();
        players.add(new HumanPlayer(1,"Arpit",Symbol.A));
        players.add(new HumanPlayer(2, "Anagha", Symbol.B));


        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(14, 7));
        snakes.add(new Snake(19, 2));

        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(3, 22));
        ladders.add(new Ladder(5, 8));

        Game game=new Game(50,players,snakes,ladders);
        game.startGame();


    }
}
