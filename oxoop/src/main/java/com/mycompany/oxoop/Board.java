/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oxoop;

/**
 *
 * @author minnie
 */
public class Board {

    private char[][] table = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
    private Player currentPlayer;
    private Player o;
    private Player x;
    private int count;
    public boolean win = false;
    public boolean draw = false;


    public Board(Player o, Player x) {
        this.o = o;
        this.x = x;
        this.currentPlayer = o;
        this.count = 0;
    }

    public char[][] getTable() {
        return table;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getO() {
        return o;
    }

    public Player getX() {
        return x;
    }

    public int getCount() {
        return count;
    }

    private void switchPlayer() {
        if (currentPlayer == o) {
            currentPlayer = x;
        } else {
            currentPlayer = o;
        }
    }

    public boolean isWin() {
        return win;
    }

    public boolean isDraw() {
        return draw;
    }
    
    public boolean setRowCol(int row, int col) {
        if (row > 3 || col > 3 || row < 1 || col < 1) {
            return false;
        }
        if (table[row - 1][col - 1] != '-') {
            return false;
        }
        table[row - 1][col - 1] = currentPlayer.getSymbol();
        if(checkWin(row, col)) {
            updateStat();
            this.win = true;
            return true;
        }
        if(checkDraw()) {
            o.draw();
            x.draw();
            this.draw = true;
            return true;
        }
        count ++;
        switchPlayer();
        return true;
    }

    private void updateStat() {
        if(this.currentPlayer == o) {
            o.win();
            x.loss();
        } else {
            x.win();
            o.loss();
        }
    }
    public boolean checkDraw() {
        if(count==8) return true;
        return false;
    }
    public boolean checkWin(int row, int col) {
        if(checkVertical(col)) {
            return true;
        } else if(checkHorizontal(row)){
            return true;
        } else if(checkX()) {
            return true;
        }
        return false;
    }

    public boolean checkVertical(int col) {
        for(int r=0;r<table.length;r++) {
            if(table[r][col-1]!=currentPlayer.getSymbol()) return false;
        }
        return true;
    }

    private boolean checkHorizontal(int row) {
        for(int c=0;c<table.length;c++) {
            if(table[row-1][c]!=currentPlayer.getSymbol()) return false;
        }
        return true;
    }

    private boolean checkX() { //Parameters
        if(checkX1()) {
            return true;
        } else if(checkX2()) { // Arguments
            return true;
        }
        return false;
    }

    private boolean checkX1() {  // 11, 22, 33
        for(int i=0;i<table.length;i++){
            if(table[i][i] != currentPlayer.getSymbol()) {
                return false;
            }
        }
        return true;
    }

    private boolean checkX2() {  // 13, 22, 31 => 02, 11, 20
        for(int i=0;i<table.length;i++){
            if(table[i][2-i] != currentPlayer.getSymbol()) {
                return false;
            }
        }
        return true;
    }
}


