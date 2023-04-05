package Strategies.BotPlayingStrategy;

import Models.*;

public class RandomBotPlayingStrategty implements BotPlayingStrategy {
    @Override
    public Moves decideMove(Player player, Board board) {
        for (int i=0; i<board.getBoard().size(); i++){
            for (int j=0; j<board.getBoard().size(); j++){
                if (board.getBoard().get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    return new Moves(new Cell(i,j), player);
                }
            }
        }

        return null;
    }
}
