package Strategies.GameWinningStrategy;

import Models.Board;
import Models.Cell;
import Models.Player;

public interface GameWinningStrategy {
    boolean checkWinner(Player player, Board board, Cell cell);
}
