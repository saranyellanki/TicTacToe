package com.bridgelabz.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public char[] board;
    public String player, bot;
    public boolean isWinner;
    public Scanner sc;
    /*
        constructor for TicTacToe which initializes
        character array board with length 10 as default
     */
    public TicTacToe() {
        this.board = new char[10];
        this.sc = new Scanner(System.in);
        this.isWinner = false;
    }

    public TicTacToe createGameBoard() {
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
        System.out.println(Arrays.toString(board));
        return this;
    }

    /*
        Player is able to choose between X or O
        if Player choose any option between X or O
        Computer will be assigned with the other option
     */

    public TicTacToe playerChoice() {
        while(true){
            System.out.print("Choose a letter X or O : ");
            String option = sc.next();
            if(option.equals("X") || option.equals("O")){
                System.out.println("You have chosen: "+option);
                this.player = option;
                this.bot = (player.equals("X")) ? "O" : "X";
                break;
            }
        }
        return this;
    }


    public TicTacToe printBoard(){
        System.out.println("##########################");
        for(int i=1;i<board.length;i+=3){
            for(int j=i;j<=i+2;j++){
                if(j<i+2)System.out.print(board[j]+" | ");
                else System.out.print(board[i+2]);
            }
            if((i+2)!=board.length-1){
                System.out.print("\n--+---+--");
                System.out.println();
            }
        }
        System.out.println("\n##########################");
        return this;
    }

    /*
        Check whether the input given by player
        Should not exceed length of array
     */
    public boolean isPositionValid(int pos){
        return (pos >= 1 && pos <= 9);
    }

    /*
        The chosen position by player will check with empty char
        returns boolean
     */
    public boolean isPositionFilled(int pos){
        return board[pos]==' ';
    }

    /*
        After position is chosen
        Game board is updated with chosen option
     */
    public void updateBoard(int pos){
        board[pos] = player.charAt(0);
        printBoard();
    }

    /*
        Checks every position in the game board
        if game board is completely filled returns true
     */
    public boolean isBoardFilled(){
        for(int i=1;i<board.length;i++){
            if(board[i]==' ') return false;
        }
        return true;
    }

    /*
        Every time player enters the position
        Game Board will be updated
        Input player chosen option into empty char
     */
    public void playGame(){
        while(!isWinner && !isBoardFilled()){
            System.out.println("Enter the position number");
            int pos = sc.nextInt();
            if(isPositionValid(pos)){
                if(isPositionFilled(pos)) updateBoard(pos);
                else System.out.println("Position is already acquired by opposition");
            }
            else System.out.println("Entered position is invalid please select numbers from 1 to 9");
        }
    }

    public TicTacToe toss(){
        int tossCheck = (int)Math.floor(Math.random()*10)%2;
        switch (tossCheck){
            case 0:
                System.out.println("Player won the toss");
                break;
            case 1:
                System.out.println("Computer won the toss");
                break;
        }
        return this;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to TicTcToe Game");
        TicTacToe ticTacToeObj = new TicTacToe();
        ticTacToeObj
                .createGameBoard()
                .printBoard()
                .playerChoice()
                .toss()
                .playGame();
    }
}
