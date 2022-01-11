package com.example.tictactoeapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Game g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //One instance of Game is created, all buttons share the same instance
        //unless a new game has started
        g = new Game();
    }

    //Helper method: set text on TextView
    public void setContentsOfTextView(int id, String newContents) {
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);
    }

    //Helper method: get text from EditText
    public String getInputOfTextField (int id) {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }

    //Helper method: get text from Spinner
    public String getItemSelected (int id) {
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String string = spinner.getSelectedItem().toString();
        return string;
    }

    //When Start/Restart Game button clicked
    public void startButtonClicked(View view) {
        //Get input from the name entries
        //Get input from spinner, who goes first

        String pxName = getInputOfTextField(R.id.pxNameInput);
        String poName = getInputOfTextField(R.id.poNameInput);
        String goFirst = getItemSelected(R.id.firstPlayerSpinner);

        g = new Game(pxName,poName,goFirst);

        setContentsOfTextView(R.id.outputLabel,g.toString());
    }

    //When Play button clicked
    public void playButtonClicked(View view){
        //Get input for row
        //Get input for column
        //output the board state

        int rowInput = Integer.parseInt(getItemSelected(R.id.rowSpinner));
        int colInput = Integer.parseInt(getItemSelected(R.id.colSpinner));

        g.setPlayerChoice(rowInput,colInput);

        setContentsOfTextView(R.id.outputLabel,g.toString());
    }
}