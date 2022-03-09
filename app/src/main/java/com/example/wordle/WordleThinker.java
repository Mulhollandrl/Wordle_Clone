package com.example.wordle;

import java.util.ArrayList;
import java.util.Locale;

public class WordleThinker {
    private String chosenWord;
    private char[] chosenWordChar;
    private ArrayList<Pair> listOfLetters = new ArrayList<>();

    public WordleThinker (){
        WordChooser wordChooser = new WordChooser();
        chosenWord = wordChooser.chosenWord.toLowerCase();

        chosenWordChar = chosenWord.toCharArray();

        setYellows();
    }

    public void setYellows (){
        for (char currentLetter = 'a'; currentLetter <= 'z'; currentLetter++){
            Integer amountOfLetter = 0;

            for (char letterInArray : chosenWordChar){
                if (letterInArray == currentLetter){
                    amountOfLetter++;
                }
            }

            Pair storedLetterValues = new Pair(currentLetter, amountOfLetter);

            listOfLetters.add(storedLetterValues);
        }
    }

    public boolean isLetterGreen(String letter, int position){
        char charAtPosition = chosenWordChar[position];
        char letterChar = letter.toCharArray()[0];

        if (letterChar == charAtPosition){
            for (int letterIndex = 0; letterIndex < listOfLetters.size(); letterIndex++){
                Pair currentLetterInfo = listOfLetters.get(letterIndex);

                if (currentLetterInfo.character == letterChar){
                    currentLetterInfo.integer--;
                }
            }

            return true;
        }

        return false;
    }

    public boolean isLetterYellow(String letter){
        char letterChar = letter.toCharArray()[0];
        int yellowsRemaining = 0;

        for (int letterIndex = 0; letterIndex < listOfLetters.size(); letterIndex++) {
            Pair currentLetterInfo = listOfLetters.get(letterIndex);

            if (currentLetterInfo.character == letterChar) {
                yellowsRemaining = currentLetterInfo.integer;
            }
        }

        for (char c : chosenWordChar) {
            if (letterChar == c && yellowsRemaining > 0) {
                for (int letterIndex = 0; letterIndex < listOfLetters.size(); letterIndex++) {
                    Pair currentLetterInfo = listOfLetters.get(letterIndex);

                    if (currentLetterInfo.character == letterChar) {
                        currentLetterInfo.integer--;
                    }
                }

                return true;
            }
        }

        return false;
    }
}
