package com.bridgelabz.tictactoe;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public char[] board;
    public char player, bot;
    public boolean isWinner;
    public Scanner sc;
    public int turn;
    public int logic1Counter;
    public int logic2Counter;
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
            char option = sc.next().toUpperCase(Locale.ROOT).charAt(0);
            if(option=='X' || option=='O'){
                System.out.println("You have chosen: "+option);
                this.player = option;
                this.bot = (player=='X') ? 'O' : 'X';
                break;
            }
        }
        return this;
    }
    /*
        This a method which prints game board
     */
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
        return board[pos]!=' ';
    }
    /*
        After position is chosen
        Game board is updated with chosen option
     */
    public void updateBoard(int pos, String playerToMove){
        if(playerToMove.equals("PLAYER")) board[pos] = player;
        else board[pos] = bot;
        printBoard();
        checkWinner();
    }
    /*
        Checks every position in the game board
        if game board is completely filled returns true
     */
    public boolean isBoardNotFilled(){
        for(int i=1;i<board.length;i++){
            if(board[i]==' ') return true;
        }
        return false;
    }
    /*
        Random function for toss
     */
    public TicTacToe toss(){
        Random r = new Random();
        int tossCheck = r.nextInt(2);
        switch (tossCheck) {
            case 0 -> {
                if(player=='X' || player=='O') {
                    System.out.println("You won the toss");
                    turn = 0;
                }
            }
            case 1 -> {
                System.out.println("Computer won the toss");
                turn = 1;
            }
        }
        return this;
    }
    /*
        Sequence maker is a method used for making set of char into string
        Parameters passed are index values of the board
     */
    public String sequenceMaker(int a,int b,int c){
        return board[a] +""+ board[b] +""+ board[c];
    }
    /*
        Check winner checks all the possible cases for winning the game
        if anyone of the condition is satisfied
        declares the result and play stops
     */
    public void checkWinner(){
        for(int i=1;i<9;i++){
            String sequence = switch (i) {
                case 1 -> sequenceMaker(1, 2, 3);
                case 2 -> sequenceMaker(4, 5, 6);
                case 3 -> sequenceMaker(7, 8, 9);
                case 4 -> sequenceMaker(1, 4, 7);
                case 5 -> sequenceMaker(2, 5, 8);
                case 6 -> sequenceMaker(3, 6, 9);
                case 7 -> sequenceMaker(1, 5, 9);
                case 8 -> sequenceMaker(3, 5, 7);
                default -> null;
            };
            if(sequence.equals("XXX")) {
                if (player=='X') System.out.println("You won the game");
                else System.out.println("Computer won the game");
                isWinner = true;
                break;
            }
            else if(sequence.equals("OOO")) {
                if (player=='O') System.out.println("You won the game");
                else System.out.println("Computer won the game");
                isWinner=true;
                break;
            }
        }
    }
    public void botPlay(){
        computerLogic();
        if(logic1Counter==0 && logic2Counter==0) {
            Random r = new Random();
            int posOfBot = r.nextInt(9) + 1;
            if (!isPositionFilled(posOfBot)) {
                System.out.println("Bots turn now");
                updateBoard(posOfBot, "BOT");
            } else botPlay();
        }
    }
    public void computerLogic() {
        logic1Counter = 0;
        logic1(1, 2, 3);
        if (logic1Counter == 0) {
            logic1(4, 5, 6);
        }
        if (logic1Counter == 0) {
            logic1(7, 8, 9);
        }
        if (logic1Counter == 0) {
            logic1(1, 4, 7);
        }
        if (logic1Counter == 0) {
            logic1(2, 5, 8);
        }
        if (logic1Counter == 0) {
            logic1(3, 6, 9);
        }
        if (logic1Counter == 0) {
            logic1(1, 5, 9);
        }
        if (logic1Counter == 0) {
            logic1(3, 5, 7);
        }

        if (logic1Counter == 0) {
            logic2Counter = 0;
            logic2(1, 2, 3);
            if (logic2Counter == 0) {
                logic2(4, 5, 6);
            }
            if (logic2Counter == 0) {
                logic2(7, 8, 9);
            }
            if (logic2Counter == 0) {
                logic2(1, 4, 7);
            }
            if (logic2Counter == 0) {
                logic2(2, 5, 8);
            }
            if (logic2Counter == 0) {
                logic2(3, 6, 9);
            }
            if (logic2Counter == 0) {
                logic2(1, 5, 9);
            }
            if (logic2Counter == 0) {
                logic2(3, 5, 7);
            }
        }
    }
    public void logic1(int x,int y, int z){
        if (board[x]==bot || board[y]==bot || board[z]==bot){
            if (board[x]==board[y] && board[z]==' '){
                board[z]=bot;
                logic1Counter++;
            }else if (board[x]==board[z] && board[y]==' '){
                board[y]=bot;
                logic1Counter++;
            }else if (board[y]==board[z] && board[x]==' '){
                board[x]=bot;
                logic1Counter++;
            }
        }
    }
    public void logic2(int x,int y, int z){
        if (board[x]==player || board[y]==player || board[z]==player){
            if (board[x]==board[y] && board[z]==' '){
                board[z]=player;
                logic2Counter++;
            }else if (board[x]==board[z] && board[y]==' '){
                board[y]=player;
                logic2Counter++;
            }else if (board[y]==board[z] && board[x]==' '){
                board[x]=player;
                logic2Counter++;
            }
        }
    }
    /*
    playerGame is a method for a player to choose his desired position
    Every time player enters the position
    Game Board will be updated
    */
    public void playerGame() {
        System.out.println("Enter the position number");
        int pos = sc.nextInt();
        if (isPositionValid(pos)) {
            if (!isPositionFilled(pos)) updateBoard(pos,"PLAYER");
            else {
                System.out.println("Position is already acquired");
                playerGame();
            }
        } else {
            System.out.println("Entered position is invalid please select numbers from 1 to 9");
            playerGame();
        }
    }
    /*
        Loop the playerGame method till one the condition is reached
        Everytime you need update the position
     */
    public void playGame(){
        while (!isWinner && isBoardNotFilled()){
            if(turn==0){
                playerGame();
                turn=1;
            }
            else if(turn==1){
                botPlay();
                turn=0;
            }
        }
        if(!isWinner) System.out.println("Game tied between you and bot");
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