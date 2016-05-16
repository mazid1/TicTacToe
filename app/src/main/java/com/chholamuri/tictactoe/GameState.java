package com.chholamuri.tictactoe;

public class GameState {
    private int size, board[][];

    public GameState() {

    }

    public GameState(int size) {
        this.size = size;
        board = new int[size][size];
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                board[i][j] = 0; // board[i][j] = -1 for O move and +1 for X move
            }
        }
        //board[1][2] = 1;
//		board[1][0] = -1;
//		board[0][2] = 1;
    }

    public void printBoard() {
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void drop(Point p, int player) {
        this.board[ p.getX() ][ p.getY() ] = player;
    }

    public int check(int grid[][]) {
        int cnt;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                int val = grid[i][j];
                if(val == 0)continue;

                cnt = 0;
                for(int k=0; k<size && j+k<size; k++) {
                    int x = i;
                    int y = j + k;
                    if( grid[x][y] == val)cnt++;
                }
                if(cnt == size) return val;

                cnt = 0;
                for(int k=0; k<size && i+k<size; k++) {
                    int x = i + k;
                    int y = j;
                    if( grid[x][y] == val)cnt++;
                }
                if(cnt == size)return val;

                cnt = 0;
                for(int k=0; k<size && i+k<size && j+k<size; k++) {
                    int x = i + k;
                    int y = j + k;
                    if( grid[x][y] == val)cnt++;
                }
                if(cnt == size)return val;

                cnt = 0;
                for(int k=0; k<size && i+k<size && j-k>=0; k++) {
                    int x = i + k;
                    int y = j - k;
                    if( grid[x][y] == val)cnt++;
                }
                if(cnt == size)return val;
            }
        }
        return 0;
    }

    Point minimax(int grid[][], int currentPlayer) {
        int here = check(grid);
        if(here != 0) return new Point(here);

        Point nRet = new Point();
        Point pRet = new Point();
        Point dRet = new Point();
        int n=0, p=0, d=0;

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(grid[i][j] == 0) {
                    grid[i][j] = currentPlayer;
                    Point pt = minimax(grid, currentPlayer * (-1));
                    if(pt.getH() == -1) {
                        n++;
                        if(n == 1) nRet = new Point(i, j, -1);
                    }
                    else if(pt.getH() == 1) {
                        p++;
                        if(p == 1) pRet = new Point(i, j, 1);
                    }
                    else {
                        d++;
                        if(d == 1) dRet = new Point(i, j, 0);
                    }
                    grid[i][j] = 0;
                }
            }
        }

        int ret = 0;
        if(currentPlayer == 1) {
            if(p != 0)ret = 1;
            else if(n != 0 && d == 0)ret = -1;
        }
        else {
            if(n != 0)ret = -1;
            else if(p != 0 && d == 0)ret = +1;
        }
        if(ret == 1) return pRet;
        else if(ret == -1) return nRet;
        else return dRet;
    }

    Point generateNextMove(int player) {
        Point p = minimax(board, player);
        this.drop(p, player);
        return p;
    }

    Point next(Point p, int player) {
        if(board[ p.getX() ][ p.getY() ] != 0) return p;
        drop(p, player);
        player *= (-1);
        p = minimax(board, player);
        drop(p, player);
        return p;
    }
}
