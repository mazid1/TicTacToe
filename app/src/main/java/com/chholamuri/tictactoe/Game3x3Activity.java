package com.chholamuri.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Game3x3Activity extends AppCompatActivity {

    public static String EXTRA_MESSAGE;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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
}
