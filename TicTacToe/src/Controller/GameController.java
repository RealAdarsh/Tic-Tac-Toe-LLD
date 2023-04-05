package Controller;

import Models.Game;
import Models.GameState;
import Models.Player;
import Models.PlayerType;

import java.util.List;

public class GameController {

//    public void undo(Game game){
//        game.undo();
//    }

    public Game createGame(int dimension, List<Player> players){
        try{
            return Game.getBuilder().setDimension(dimension).setPlayers(players).build();
        }
        catch (Exception e){
            System.out.println(e);
        }

        return null;
    }

    public void displayBoard(Game game){
        game.displayBoard();
    }

    public GameState getGameStatus(Game game){
        return game.getGameState();
    }

    public void executeNextMove(Game game){
        game.makeNextMove();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

}
