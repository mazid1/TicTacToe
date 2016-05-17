package com.chholamuri.tictactoe;

public class GameEnd {
    private Point arr[];
    private int player, key;
    private boolean isDraw, isResult;

    public GameEnd() {
        arr = new Point[3];
    }

    public GameEnd(Point a, Point b, Point c, int player) {
        arr = new Point[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public Point[] getArr() {
        return arr;
    }

    public boolean getIsDraw() {
        return isDraw;
    }

    public boolean getIsResult() {
        return isResult;
    }

    public void setIsDraw(boolean isDraw) {
        this.isDraw = isDraw;
    }

    public void setIsResult(boolean isResult) {
        this.isResult = isResult;
    }

    public void Push(Point p, int player) {
        arr[key++] = p;
        this.player = player;
    }

    public void Reset() {
        key = 0;
        this.player = 0;
    }

    public void print() {
        System.out.println("isDraw = " + isDraw);
        System.out.println("isResult = " + isResult);
        System.out.println("arr[0] = " + arr[0].getX() + " " + arr[0].getY());
        System.out.println("arr[1] = " + arr[1].getX() + " " + arr[1].getY());
        System.out.println("arr[2] = " + arr[2].getX() + " " + arr[2].getY());
        System.out.println("player " + player);
    }
}