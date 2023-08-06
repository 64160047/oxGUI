/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oxoop;

/**
 *
 * @author minnie
 */
public class Player {
     private char symbol;
    private int win;
    private int loss;
    private int draw;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getWin() {
        return win;
    }

    public void win() {
        this.win++;
    }

    public int getLoss() {
        return loss;
    }

    public void loss() {
        this.loss++;
    }

    public int getDraw() {
        return draw;
    }

    public void draw() {
        this.draw++;
    }

    @Override
    public String toString() {
        return "Player{" + "symbol=" + symbol + ", win=" + win + ", loss=" + loss + ", draw=" + draw + '}';
    }

    
}
