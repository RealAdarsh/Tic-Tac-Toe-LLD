package Models;

import java.util.List;
import java.util.ArrayList;

public class Board {
    private List <List<Cell>> board;

    Board(int dimension){
        this.board=new ArrayList<>();

        for (int i=0; i<dimension; i++){
            this.board.add(new ArrayList<>());
            for (int j=0; j<dimension; j++){
                this.board.get(i).add(new Cell(i,j));
            }
        }
    }

    public List<List<Cell>> getBoard(){
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }

    public void display(){
        for (int i=0; i<board.size(); i++){
            for (int j=0; j<board.size(); j++){
                if (board.get(i).get(j).getCellState().equals(CellState.EMPTY)){
                    System.out.printf("|   |");
                }
                else{
                    System.out.printf("| " + board.get(i).get(j).getPlayer().getPlayerSymbol() + " |");
                }
            }
            System.out.println("\n");
        }
    }
}
