package Strategies.GameWinningStrategy;

import Models.Board;
import Models.Cell;
import Models.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderOneGameWinningStrategy implements  GameWinningStrategy{

    private List<HashMap<Character, Integer>> rowSymbolCounts= new ArrayList<>();
    private List<HashMap<Character, Integer>> colSymbolCounts=new ArrayList<>();

    private HashMap<Character, Integer> topLeftDiagSymbolCounts= new HashMap<>();
    private HashMap<Character, Integer> topRightDiagSymbolCounts=new HashMap<>();



    public OrderOneGameWinningStrategy(int dimensions){
        for (int i=0; i<dimensions; i++){
            rowSymbolCounts.add(new HashMap<>());
            colSymbolCounts.add(new HashMap<>());
        }
    }

    public boolean isCellOnTopLeftDiag(int row, int col){
        return row==col;
    }

    public boolean isCellOnTopRightDiag(int row, int col, int dimension){
        return row+col==dimension-1;
    }


    @Override
    public boolean checkWinner(Player player, Board board, Cell cell) {
        char symbol= cell.getPlayer().getPlayerSymbol();
        int row=cell.getRow();
        int col=cell.getCol();
        int dimension= board.getBoard().size();

        if (!rowSymbolCounts.get(row).containsKey(symbol)){
            rowSymbolCounts.get(row).put(symbol,0);
        }

        rowSymbolCounts.get(row).put(symbol,
                rowSymbolCounts.get(row).get(symbol)+1);

        if (!colSymbolCounts.get(col).containsKey(symbol)){
            colSymbolCounts.get(col).put(symbol,0);
        }

        colSymbolCounts.get(col).put(symbol,
                colSymbolCounts.get(col).get(symbol)+1);

        if (isCellOnTopLeftDiag(row,col)){
            if (!topLeftDiagSymbolCounts.containsKey(symbol)){
                topLeftDiagSymbolCounts.put(symbol,0);
            }

            topLeftDiagSymbolCounts.put(symbol, topLeftDiagSymbolCounts.get(symbol)+1);

            if (topLeftDiagSymbolCounts.get(symbol)==dimension) return  true;
        }

        if (isCellOnTopRightDiag(row,col, dimension)){
            if (!topRightDiagSymbolCounts.containsKey(symbol)){
                topRightDiagSymbolCounts.put(symbol,0);
            }
            topRightDiagSymbolCounts.put(symbol, topRightDiagSymbolCounts.get(symbol)+1);

            if (topRightDiagSymbolCounts.get(symbol)==dimension) return  true;
        }

        if (rowSymbolCounts.get(row).get(symbol)==dimension ||
            colSymbolCounts.get(col).get(symbol)==dimension ) return true;


        return false;
    }
}
