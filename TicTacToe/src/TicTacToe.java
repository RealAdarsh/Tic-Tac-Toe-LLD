import Controller.GameController;
import Models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        GameController gameController=new GameController();

        System.out.println("What would be dimension of game? ");
        int dimension = sc.nextInt();

        System.out.println("Is there any bot in the game ? (Y/N): ");
        String isBot= sc.next();

        List< Player> players=new ArrayList<>();

        int toIterate= dimension-1;

        if (isBot.equals("Y") || isBot.equals("y")){
            toIterate=dimension-2;
        }

        for (int i=0; i<toIterate; i++){
            System.out.println("What is the name of the player? " + i);
            String playerName = sc.next();

            System.out.println("What is the symbol for this player" + i);
            char playerSymbol = sc.next().charAt(0);

            players.add(new Player(playerName, playerSymbol, PlayerType.HUMAN));
        }

        if (isBot.equals("y") || isBot.equals("Y")){
            System.out.println("Enter the name of bot: ");
            String botName=sc.next();

            System.out.println("What is the symbol of this Bot? ");
            char botSymbol= sc.next().charAt(0);

            players.add(new BOT(botName, botSymbol, DifficultyLevel.Easy));
        }

        Game game=gameController.createGame(dimension, players);

        while (gameController.getGameStatus(game).equals(GameState.Inprogress)){
            System.out.println("This is your current board");

            gameController.displayBoard(game);

//            System.out.println("Does anyone want to undo? y/n");
//            String input = sc.next();

//            if(input.equals("y")){
//                gameController.undo(game);
//            }
//            else{
                gameController.executeNextMove(game);
//            }
        }

        System.out.println("Game has ended. Result was: ");

        if(!game.getGameState().equals(GameState.Draw)){
            System.out.println("Winner is: ." + gameController.getWinner(game).getName());
            gameController.displayBoard(game);
        }



    }
}
