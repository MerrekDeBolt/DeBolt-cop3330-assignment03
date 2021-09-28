package ex41;
/*
 *  UCF COP3330 Fall 2021 Exercise 41 Solution
 *  Copyright 2021 Merrek DeBolt
 */

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args)
    {
        // Must count how many lines there are in the text file.
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get("src/main/java/ex41/exercise41_input.txt"), StandardCharsets.US_ASCII); }
        catch (Exception e) { System.out.println("File not found."); return; }

        // Sort


        // Write output
    }
}