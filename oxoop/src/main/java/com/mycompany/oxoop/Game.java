/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oxoop;

import java.util.Scanner;

/**
 *
 * @author minnie
 */
public class Game {
     private Player o;
    private Player x;
    private int row;
    private int col;
    private Board board;
    Scanner sc = new Scanner(System.in);

    public Game() {
        this.o = new Player('O');
        this.x = new Player('X');
    }
    public void newBoard() {
        this.board = new Board(o, x);
    }
    
    public void showWelcome() {
        System.out.println("Welcome to OX Game");
    }
    public void showTurn() {
        Player player = board.getCurrentPlayer();
        System.out.println("Turn " + player.getSymbol());
    }
    public void showTable() {
        char[][] table = this.board.getTable();
        for (int r = 0; r < table.length; r++) {
            for (int c = 0; c < table[r].length; c++) {
                System.out.print(table[r][c]);
            }
            System.out.println("");
        }
    }
    public void inputRowCol() {
        while(true) {
            System.out.print("Please input row, col:");
            row = sc.nextInt();
            col = sc.nextInt();
            if(board.setRowCol(row, col)) {
                return;
            }
        }
    }
    
    public boolean isFinish() {
        if(board.isDraw()|| board.isWin()) {
            return true;
        }
        return false;
    }
    public void showStat() {
        System.out.println(o);
        System.out.println(x);
    }
    public void showResult() {
        if(board.isDraw()) {
            System.out.println("Draw!!!");
        } else if(board.isWin()) {
            System.out.println(board.getCurrentPlayer().getSymbol() + " Win");
        }
    }

}
