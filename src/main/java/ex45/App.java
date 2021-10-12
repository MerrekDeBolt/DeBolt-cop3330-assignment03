package ex45;
/*
 *  UCF COP3330 Fall 2021 Exercise 45 Solution
 *  Copyright 2021 Merrek DeBolt
 */

import ex41.Record;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {

    public static String fileToString()
    {
        String text = "";
        try { text = new String(Files.readAllBytes(Paths.get("src/main/java/ex45/exercise45_input.txt"))); return text; }
        catch (IOException ex) { System.out.println("File not found."); return ""; }
    }

    public static String replaceString(String text)
    {
        String newText = text.replace("utilize", "use");
        return newText;
    }

    public static void main(String[] args)
    {
        // Must count how many lines there are in the text file.
        String text = fileToString();

        // Replace substrings
        String newText = replaceString(text);

        // Write output
        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to name the output file? ");
        String fileName = scanner.nextLine();
        FileWriter writer;
        try
        {
            writer = new FileWriter("src/main/java/ex45/" + fileName + ".txt");
            writer.write(newText);
            writer.close();
        }
        catch (Exception e) { System.out.println("File not found."); return; }
    }
}