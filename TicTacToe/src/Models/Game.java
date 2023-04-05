package Models;

import Exceptions.InvalidGameConstructorException;
import Strategies.GameWinningStrategy.GameWinningStrategy;
import Strategies.GameWinningStrategy.OrderOneGameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> player;
    private List<Moves> moves;
    GameState gameState;
    private int nextPlayerIndex;
    private GameWinningStrategy gameWinningStrategy;
    private Player winner;

    private Game(){
    }

    public void undo(){
        return;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public List<Moves> getMoves() {
        return moves;
    }

    public void setMoves(List<Moves> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public GameWinningStrategy getGameWinningStrategy() {
        return gameWinningStrategy;
    }

    public void setGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
        this.gameWinningStrategy = gameWinningStrategy;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void makeNextMove(){
        Player toMovePlayer= player.get(nextPlayerIndex);
        System.out.println("It is "+ toMovePlayer.getName()+"'s  turn.");
        Moves moves=toMovePlayer.decideMove(this.board);

        // validate the moves

        int row= moves.getCell().getRow();
        int col=moves.getCell().getCol();

        System.out.println("Move happened at: "+ row + ", " + col +" .");

        board.getBoard().get(row).get(col).setCellState(CellState.OCCUPIED);
        board.getBoard().get(row).get(col).setPlayer(toMovePlayer);

        Moves finalMove= new Moves(board.getBoard().get(row).get(col), toMovePlayer);

        this.moves.add(finalMove);

        // check the winner

        if(gameWinningStrategy.checkWinner(
                toMovePlayer, board, finalMove.getCell()
        )){
            gameState=GameState.Ended;
            winner=toMovePlayer;
        }

        nextPlayerIndex+=1;
        nextPlayerIndex%=player.size();
    }

    public void displayBoard(){
        this.board.display();
    }



    public static Builder getBuilder(){
        return new Builder();
    }
    public static class Builder {
        int dimension;
        private List<Player> players;

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public boolean isValid() throws InvalidGameConstructorException {
            if (this.dimension<3){
                throw  new InvalidGameConstructorException("Dimension can't be less than 3");
            }
            if (this.players.size()!=dimension-1){
                throw new InvalidGameConstructorException("Players must be dimension -1 ");
            }
            return true;
        }

        public Game build() throws InvalidGameConstructorException {
            try {
                isValid();
            }
            catch(Exception e){
                throw  new InvalidGameConstructorException(e.getMessage());
            }

            Game game= new Game();
            game.setBoard(new Board(dimension));
            game.setGameWinningStrategy(new OrderOneGameWinningStrategy(dimension));
            game.setMoves(new ArrayList<>());
            game.setNextPlayerIndex(0);
            game.setPlayer(players);
            game.setGameState(GameState.Inprogress);

            return game;

        }
    }

}
