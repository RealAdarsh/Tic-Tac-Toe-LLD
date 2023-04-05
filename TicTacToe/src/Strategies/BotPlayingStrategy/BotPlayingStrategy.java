package Strategies.BotPlayingStrategy;

import Models.Board;
import Models.Moves;
import Models.Player;

public interface BotPlayingStrategy {
    Moves decideMove(Player player, Board board);
}
