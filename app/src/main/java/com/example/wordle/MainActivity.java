package com.example.wordle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WordleThinker wordleThinker = new WordleThinker();

        LinearLayout overallLayout = new LinearLayout(this);
        overallLayout.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams overallParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        overallLayout.setLayoutParams(overallParams);

        for (int i = 0; i < 6; i++){
            LinearLayout rowOne = new LinearLayout(this);

            LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1);

            EditText rowOneLetterOne = new EditText(this);
            EditText rowOneLetterTwo = new EditText(this);
            EditText rowOneLetterThree = new EditText(this);
            EditText rowOneLetterFour = new EditText(this);
            EditText rowOneLetterFive = new EditText(this);

            rowOneLetterOne.setGravity(Gravity.CENTER_HORIZONTAL);
            rowOneLetterTwo.setGravity(Gravity.CENTER_HORIZONTAL);
            rowOneLetterThree.setGravity(Gravity.CENTER_HORIZONTAL);
            rowOneLetterFour.setGravity(Gravity.CENTER_HORIZONTAL);
            rowOneLetterFive.setGravity(Gravity.CENTER_HORIZONTAL);


            rowOneLetterOne.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            rowOneLetterTwo.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            rowOneLetterThree.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            rowOneLetterFour.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});
            rowOneLetterFive.setFilters(new InputFilter[]{new InputFilter.LengthFilter(1)});

            rowOneLetterOne.setLayoutParams(textParams);
            rowOneLetterTwo.setLayoutParams(textParams);
            rowOneLetterThree.setLayoutParams(textParams);
            rowOneLetterFour.setLayoutParams(textParams);
            rowOneLetterFive.setLayoutParams(textParams);

            Button rowOneSubmitButton = new Button(this);
            rowOneSubmitButton.setText("Submit");
            rowOneSubmitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean letterOneGreen = wordleThinker.isLetterGreen(rowOneLetterOne.getText().toString().toLowerCase(), 0);
                    boolean letterTwoGreen = wordleThinker.isLetterGreen(rowOneLetterTwo.getText().toString().toLowerCase(), 1);
                    boolean letterThreeGreen = wordleThinker.isLetterGreen(rowOneLetterThree.getText().toString().toLowerCase(), 2);
                    boolean letterFourGreen = wordleThinker.isLetterGreen(rowOneLetterFour.getText().toString().toLowerCase(), 3);
                    boolean letterFiveGreen = wordleThinker.isLetterGreen(rowOneLetterFive.getText().toString().toLowerCase(), 4);


                    if (letterOneGreen){
                        rowOneLetterOne.setBackgroundColor(Color.GREEN);
                    } else if (wordleThinker.isLetterYellow(rowOneLetterOne.getText().toString().toLowerCase())){
                        rowOneLetterOne.setBackgroundColor(Color.YELLOW);
                    }

                    if (letterTwoGreen){
                        rowOneLetterTwo.setBackgroundColor(Color.GREEN);
                    } else if (wordleThinker.isLetterYellow(rowOneLetterTwo.getText().toString().toLowerCase())){
                        rowOneLetterTwo.setBackgroundColor(Color.YELLOW);
                    }

                    if (letterThreeGreen){
                        rowOneLetterThree.setBackgroundColor(Color.GREEN);
                    } else if (wordleThinker.isLetterYellow(rowOneLetterThree.getText().toString().toLowerCase())){
                        rowOneLetterThree.setBackgroundColor(Color.YELLOW);
                    }

                    if (letterFourGreen){
                        rowOneLetterFour.setBackgroundColor(Color.GREEN);
                    } else if (wordleThinker.isLetterYellow(rowOneLetterFour.getText().toString().toLowerCase())){
                        rowOneLetterFour.setBackgroundColor(Color.YELLOW);
                    }

                    if (letterFiveGreen){
                        rowOneLetterFive.setBackgroundColor(Color.GREEN);
                    } else if (wordleThinker.isLetterYellow(rowOneLetterFive.getText().toString().toLowerCase())){
                        rowOneLetterFive.setBackgroundColor(Color.YELLOW);
                    }

                    rowOneLetterOne.setKeyListener(null);
                    rowOneLetterTwo.setKeyListener(null);
                    rowOneLetterThree.setKeyListener(null);
                    rowOneLetterFour.setKeyListener(null);
                    rowOneLetterFive.setKeyListener(null);

                    wordleThinker.setYellows();
                }
            });

            rowOne.addView(rowOneLetterOne);
            rowOne.addView(rowOneLetterTwo);
            rowOne.addView(rowOneLetterThree);
            rowOne.addView(rowOneLetterFour);
            rowOne.addView(rowOneLetterFive);
            rowOne.addView(rowOneSubmitButton);

            overallLayout.addView(rowOne);
        }

        setContentView(overallLayout);
    }
}