package ex46;
/*
 *  UCF COP3330 Fall 2021 Exercise 46 Solution
 *  Copyright 2021 Merrek DeBolt
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static ArrayList<Word> createWords(ArrayList<String> wordStrings)
    {
        ArrayList<Word> words = new ArrayList<Word>();
        for (int index = 0; index < wordStrings.size(); index++)
        {
            boolean unique = true;
            for (int index2 = 0; index2 < words.size(); index2++)
            {
                if (words.get(index2).Value.equals(wordStrings.get(index)))
                {
                    words.get(index2).Amount++;
                    unique = false;
                    break;
                }
            }

            if (unique)
            {
                Word word = new Word();
                word.Value = wordStrings.get(index);
                word.Amount = 1;
                words.add(word);
            }
        }

        return words;
    }

    public static void main(String[] args)
    {
        // Make a string from a text file
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get("src/main/java/ex46/exercise46_input.txt"), StandardCharsets.US_ASCII); }
        catch (Exception e) { System.out.println("File not found."); return; }

        ArrayList<String> wordStrings = new ArrayList<String>();
        for (int index = 0; index < lines.size(); index++)
        {
            String[] wordsInLine = lines.get(index).split(" ");
            for (int index2 = 0; index2 < wordsInLine.length; index2++)
                wordStrings.add(wordsInLine[index2]);
        }

        // Make an array of Records
        ArrayList<Word> words = createWords(wordStrings);

        // Write output
        for (int index = 0; index < words.size(); index++)
        {
            System.out.print(String.format("\n%-10s: ", words.get(index).Value));
            for (int index2 = 0; index2 < words.get(index).Amount; index2++)
                System.out.print("*");
        }
    }
}