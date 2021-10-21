package com.bridgelabz.tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public char[] board;
    public String player, bot;
    public Scanner sc;
    /*
        constructor for TicTacToe which initializes
        character array board with length 10 as default
     */
    public TicTacToe() {
        this.board = new char[10];
        this.sc = new Scanner(System.in);
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

    public void playerChoice() {
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
    }


    public void printBoard(){
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
    }


    public static void main(String[] args) {
        System.out.println("Welcome to TicTcToe Game");
        TicTacToe ticTacToeObj = new TicTacToe();
        ticTacToeObj.createGameBoard().playerChoice();
        ticTacToeObj.printBoard();
    }
}
