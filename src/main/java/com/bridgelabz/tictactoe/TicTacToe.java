package com.bridgelabz.tictactoe;

import java.util.Arrays;

public class TicTacToe {
    public char[] board;
    /*
        constructor for TicTacToe which initializes
        character array board with length 10 as default
     */
    public TicTacToe() {
        this.board = new char[10];
    }

    public void createGameBoard() {
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
        System.out.println(Arrays.toString(board));
    }

    public static void main(String[] args) {
        System.out.println("Welcome to TicTcToe Game");
        TicTacToe ticTacToeObj = new TicTacToe();
        ticTacToeObj.createGameBoard();
    }
}
