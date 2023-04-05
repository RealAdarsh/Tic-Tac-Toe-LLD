package Models;

import java.util.Scanner;

public class Player {
    private String Name;
    private PlayerType playerType;
    private char playerSymbol;

    public Player(String name, char playerSymbol, PlayerType playerType){
        this.Name=name;
        this.playerSymbol=playerSymbol;
        this.playerType=playerType;
    }

    public Moves decideMove(Board board){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please tell the row, starting froom 0: ");
        int row=sc.nextInt();

        System.out.println("Please tell the col, starting from 0: ");
        int col=sc.nextInt();

        return new Moves(new Cell(row,col), this);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public char getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSymbol(char playerSymbol) {
        this.playerSymbol = playerSymbol;
    }
}
