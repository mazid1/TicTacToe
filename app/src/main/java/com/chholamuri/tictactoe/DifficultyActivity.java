package com.chholamuri.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class DifficultyActivity extends AppCompatActivity {

    public static String EXTRA_MESSAGE;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);

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
        getMenuInflater().inflate(R.menu.menu_difficulty, menu);
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

    public void easy(View view) {
        Intent intent;
        if(message.equals("One player3 x 3")) {
            intent = new Intent(this, Game3x3Activity.class);
        }
        else {//if(message.equals("One Player5 x 5")) {
            intent = new Intent(this, Game5x5Activity.class);
        }

        String newMsg = message + "easy";
        intent.putExtra(EXTRA_MESSAGE, newMsg);
        startActivity(intent);
    }

    public void medium(View view) {
        Intent intent;
        if(message.equals("One player3 x 3") ) {
            intent = new Intent(this, Game3x3Activity.class);
        }
        else {//if(message.equals("One Player5 x 5") ) {
            intent = new Intent(this, Game5x5Activity.class);
        }

        String newMsg = message + "medium";
        intent.putExtra(EXTRA_MESSAGE, newMsg);
        startActivity(intent);
    }

    public void hard(View view) {
        Intent intent;
        if(message.equals("One player3 x 3") ) {
            intent = new Intent(this, Game3x3Activity.class);
        }
        else {//if(message.equals("One Player5 x 5") ) {
            intent = new Intent(this, Game5x5Activity.class);
        }

        String newMsg = message + "hard";
        intent.putExtra(EXTRA_MESSAGE, newMsg);
        startActivity(intent);
    }
}
