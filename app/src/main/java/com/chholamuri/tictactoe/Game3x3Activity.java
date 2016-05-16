package com.chholamuri.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class Game3x3Activity extends AppCompatActivity {

    public static String EXTRA_MESSAGE;
    String message;
    GameState gs;
    int player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        gs = new GameState(3);
        player = 1;
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

    public void input(int r, int c) {
        Point p = new Point(r, c);
        Point q = gs.next(p, player * (-1));
        if(!(p.getX() == q.getX() && p.getY() == q.getY())) {
            updateButton(p, player);
            updateButton(q, player * (-1));
        }
    }

    public void btn00(View view) {
        input(0, 0);
    }

    public void btn01(View view) {
        input(0, 1);
    }

    public void btn02(View view) {
        input(0, 2);
    }

    public void btn10(View view) {
        input(1, 0);
    }

    public void btn11(View view) {
        input(1, 1);
    }

    public void btn12(View view) {
        input(1, 2);
    }

    public void btn20(View view) {
        input(2, 0);
    }

    public void btn21(View view) {
        input(2, 1);
    }

    public void btn22(View view) {
        input(2, 2);
    }
}
