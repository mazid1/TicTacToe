package com.chholamuri.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class BoardSizeActivity extends AppCompatActivity {

    public static String EXTRA_MESSAGE;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_size);

        if (savedInstanceState == null) {
            Bundle intent = getIntent().getExtras();
            if(intent == null) {
                message = null;
            } else {
                message = intent.getString(gameModeActivity.EXTRA_MESSAGE);
            }
        } else {
            message = (String) savedInstanceState.getSerializable(gameModeActivity.EXTRA_MESSAGE);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_board_size, menu);
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

    public void size3x3(View view) {
        Intent intent;

        if(message.equals("One player")) {
            intent = new Intent(this, DifficultyActivity.class);
        }
        else {
            intent = new Intent(this, Game3x3Activity.class);
        }

        String newMsg = message + "3 x 3";
        intent.putExtra(EXTRA_MESSAGE, newMsg);
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void size5x5(View view) {
        Intent intent;

        if(message.equals("One player")) {
            intent = new Intent(this, DifficultyActivity.class);
        }
        else {
            intent = new Intent(this, Game5x5Activity.class); // need to update
        }

        String newMsg = message + "5 x 5";
        intent.putExtra(EXTRA_MESSAGE, newMsg);
        //intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
