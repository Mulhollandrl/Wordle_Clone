package com.example.wordle;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class WordChooser {
    public String chosenWord = "Happy";

    public void WordChooser (){
        try {
            ArrayList<String> input = new ArrayList<>();

            File file = new File("../data/combined_wordlist.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                input.add(data);
            }

            reader.close();

            Random random = new Random();

            int randomNumber = random.nextInt(input.size());

            String randomWord = input.get(randomNumber);

            chosenWord = randomWord;
        } catch (FileNotFoundException fnf){
            System.out.println("No such file!!");
        }
    }
}
