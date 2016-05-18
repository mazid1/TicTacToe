package com.chholamuri.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;


public class Game3x3Activity extends AppCompatActivity {

    public static String EXTRA_MESSAGE;
    String message;
    GameState gs;
    int player;
    boolean is2p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        gs = new GameState(3);
        //player = 1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_3x3);

        if (savedInstanceState == null) {
            Bundle intent = getIntent().getExtras();
            if(intent == null) {
                message = null;
            } else {
                message = intent.getString(BoardSizeActivity.EXTRA_MESSAGE);
            }
        } else {
            message = (String) savedInstanceState.getSerializable(BoardSizeActivity.EXTRA_MESSAGE);
        }


        if(message.equals("Two player3 x 3")) {
            is2p = true;
            player = 1;
           // Log.d("DBG", "2player");
            TextView tv = (TextView) findViewById(R.id.p1);
            tv.setText("Player 1: ");
            tv = (TextView) findViewById(R.id.p2);
            tv.setText("Player 2: ");
        } else {
            is2p = false;
            TextView tv = (TextView) findViewById(R.id.p1);
            tv.setText("Computer: ");
            tv = (TextView) findViewById(R.id.p2);
            tv.setText("Human: ");
            Random rand;
            rand = new Random();
            if(rand.nextInt()%2 == 0) {
                player = 1;
                gs.computerStart();
                updateButton(new Point(0,0), -1);
            }
            else {
                player = 1;
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_one_player, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public int getLevel() {
        if(message.equals("One player3 x 3easy")) {
            return 0;
        } else if(message.equals("One player3 x 3medium")) {
            return 1;
        } else {
            return 2;
        }
    }

    public void updateButton(Point p, int pl) {
        ImageButton ib;
        int r = p.getX();
        int c = p.getY();

        if(r==0 && c==0) ib = (ImageButton) findViewById(R.id.button00);
        else if(r==0 && c==1) ib = (ImageButton) findViewById(R.id.button01);
        else if(r==0 && c==2) ib = (ImageButton) findViewById(R.id.button02);
        else if(r==1 && c==0) ib = (ImageButton) findViewById(R.id.button10);
        else if(r==1 && c==1) ib = (ImageButton) findViewById(R.id.button11);
        else if(r==1 && c==2) ib = (ImageButton) findViewById(R.id.button12);
        else if(r==2 && c==0) ib = (ImageButton) findViewById(R.id.button20);
        else if(r==2 && c==1) ib = (ImageButton) findViewById(R.id.button21);
        else ib = (ImageButton) findViewById(R.id.button22);

        if(pl == 1) ib.setImageResource(R.drawable.cross);
        else ib.setImageResource(R.drawable.circle);
    }

    public void updateButtonForWinner(Point p, int pl) {
        ImageButton ib;
        int r = p.getX();
        int c = p.getY();

        if(r==0 && c==0) ib = (ImageButton) findViewById(R.id.button00);
        else if(r==0 && c==1) ib = (ImageButton) findViewById(R.id.button01);
        else if(r==0 && c==2) ib = (ImageButton) findViewById(R.id.button02);
        else if(r==1 && c==0) ib = (ImageButton) findViewById(R.id.button10);
        else if(r==1 && c==1) ib = (ImageButton) findViewById(R.id.button11);
        else if(r==1 && c==2) ib = (ImageButton) findViewById(R.id.button12);
        else if(r==2 && c==0) ib = (ImageButton) findViewById(R.id.button20);
        else if(r==2 && c==1) ib = (ImageButton) findViewById(R.id.button21);
        else ib = (ImageButton) findViewById(R.id.button22);

        if(pl == 1) ib.setImageResource(R.drawable.crosswin);
        else ib.setImageResource(R.drawable.circlewin);
    }

    public void setButtonDisable() {
        ImageButton ib;
        ib = (ImageButton) findViewById(R.id.button00); ib.setClickable(false);
        ib = (ImageButton) findViewById(R.id.button01); ib.setClickable(false);
        ib = (ImageButton) findViewById(R.id.button02); ib.setClickable(false);
        ib = (ImageButton) findViewById(R.id.button10); ib.setClickable(false);
        ib = (ImageButton) findViewById(R.id.button11); ib.setClickable(false);
        ib = (ImageButton) findViewById(R.id.button12); ib.setClickable(false);
        ib = (ImageButton) findViewById(R.id.button20); ib.setClickable(false);
        ib = (ImageButton) findViewById(R.id.button21); ib.setClickable(false);
        ib = (ImageButton) findViewById(R.id.button22); ib.setClickable(false);
        return;
    }

    public void input(int r, int c) {
        Point p = new Point(r, c);
        Point q = gs.next(p, player, getLevel());
        /*Log.d("DBG", " p = ( " + p.getX() + ", " + p.getY() + " )");
        Log.d("DBG", " q = ( " + q.getX() + ", " + q.getY() + " )");*/
        if(!(p.getX() == q.getX() && p.getY() == q.getY())) {
            if (p.getX() >= 0 && p.getX() < 3 && p.getY() >= 0 && p.getY() < 3)
                updateButton(p, player);
            if (q.getX() >= 0 && q.getX() < 3 && q.getY() >= 0 && q.getY() < 3)
                updateButton(q, player * (-1));
        }
        if(gs.check1() != 0) { // win
            GameEnd ge = gs.endState();
            Point[] point = ge.getArr();
            for(int i=0; i<3; i++) {
                updateButtonForWinner(point[i], ge.getPlayer());
                setButtonDisable();
                if(ge.getPlayer() == 1) {
                    TextView tv = (TextView) findViewById(R.id.strEndMsg);
                    tv.setText("You win!!!");
                    tv.setVisibility(View.VISIBLE);
                } else {
                    TextView tv = (TextView) findViewById(R.id.strEndMsg);
                    tv.setText("You lose!!!");
                    tv.setVisibility(View.VISIBLE);
                }
            }
            return;
        }
        else if(q.getX() == 3 && q.getY() == 3 || gs.getMoveCount() >= 3*3) { // draw
            setButtonDisable();
            TextView tv = (TextView) findViewById(R.id.strEndMsg);
            tv.setText("It's a tie!!!");
            tv.setVisibility(View.VISIBLE);
            return;
        }
    }

    public void input2p(int r, int c) {
        boolean b = gs.twoPlayerMove(new Point(r, c), player);
        if(!b) return;
        updateButton(new Point(r, c), player);
        player *= (-1);
        if(gs.check1() != 0) { // win
            GameEnd ge = gs.endState();
            Point[] point = ge.getArr();
            for(int i=0; i<3; i++) {
                updateButtonForWinner(point[i], ge.getPlayer());
                setButtonDisable();
                if(ge.getPlayer() == 1) {
                    TextView tv = (TextView) findViewById(R.id.strEndMsg);
                    tv.setText("Player 1 wins!!!");
                    tv.setVisibility(View.VISIBLE);
                } else {
                    TextView tv = (TextView) findViewById(R.id.strEndMsg);
                    tv.setText("Player 2 wins!!!");
                    tv.setVisibility(View.VISIBLE);
                }
            }
            return;
        }
        else if(gs.getMoveCount() >= 3*3) { // draw
            setButtonDisable();
            TextView tv = (TextView) findViewById(R.id.strEndMsg);
            tv.setText("It's a tie!!!");
            tv.setVisibility(View.VISIBLE);
            return;
        }
    }

    public void btn00(View view) {
        if(is2p) input2p(0, 0);
        else input(0, 0);
    }

    public void btn01(View view) {
        if(is2p) input2p(0, 1);
        else input(0, 1);
    }

    public void btn02(View view) {
        if(is2p) input2p(0, 2);
        else input(0, 2);
    }

    public void btn10(View view) {
        if(is2p) input2p(1, 0);
        else input(1, 0);
    }

    public void btn11(View view) {
        if(is2p) input2p(1, 1);
        else input(1, 1);
    }

    public void btn12(View view) {
        if(is2p) input2p(1, 2);
        else input(1, 2);
    }

    public void btn20(View view) {
        if(is2p) input2p(2, 0);
        else input(2, 0);
    }

    public void btn21(View view) {
        if(is2p) input2p(2, 1);
        else input(2, 1);
    }

    public void btn22(View view) {
        if(is2p) input2p(2, 2);
        else input(2, 2);
    }
}
