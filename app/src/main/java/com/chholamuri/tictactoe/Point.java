package com.chholamuri.tictactoe;

/**
 * Created by WIN8 on 16-May-16.
 */
public class Point {
    private int x, y, h;

    public Point() {

    }

    public Point(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int h) {
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getH() {
        return h;
    }
}
