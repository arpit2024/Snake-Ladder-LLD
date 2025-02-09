import java.util.List;
import java.util.Scanner;

public class Game {

    private Board board;
    private List<Player> playerList;
    private int nextPlayerIndex=0;
    private Dice dice;
    private GameState gameState;
    Scanner scanner;

    public Game(int boardSize, List<Player> playerList, List<Snake> snakes, List<Ladder> ladder){
        this.board = new Board(boardSize,snakes,ladder);
        this.gameState =GameState.IN_PROGRESS;
        this.dice = new Dice();
        this.playerList = playerList;
        this.scanner=new Scanner(System.in);
    }

    public void startGame(){
        while(gameState==GameState.IN_PROGRESS){
            Player currentPlayer= playerList.get(nextPlayerIndex);

            System.out.println("\n" + currentPlayer.getName()+ ", it's your turn! Press ENTER to roll the dice...");
            scanner.nextLine(); // Wait for user input

            int diceRoll= dice.roll();
            System.out.println(currentPlayer.getName()+" rolled a "+diceRoll);

            //check dice roll value befor Move to Position
            int newPosition=currentPlayer.position+diceRoll;
            if(newPosition>Board.size){
                System.out.println(currentPlayer.getName()+" exceeds board size, skipping turn ");
            }
            else{
                newPosition= board.getNewPosition(newPosition);
                currentPlayer.position=newPosition;
                System.out.println(currentPlayer.getName()+" moves to "+currentPlayer.position);
            }

            //check for win condition
            if(currentPlayer.position==Board.size){
                gameState=GameState.SUCCESS;
                System.out.println("\n🎉 " + currentPlayer.getName() + " wins the game! 🎉");
                break;
            }

            nextPlayerIndex=(nextPlayerIndex+1)%playerList.size();
        }
    };
}
