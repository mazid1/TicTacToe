package com.chholamuri.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class gameModeActivity extends AppCompatActivity {

    public static String EXTRA_MESSAGE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_mode, menu);
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

    public void start1pMatch(View view) {
        Intent intent = new Intent(this, BoardSizeActivity.class);
        String message = "One player";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void start2pMatch(View view) {
        Intent intent = new Intent(this, BoardSizeActivity.class);
        String message = "Two player";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}
