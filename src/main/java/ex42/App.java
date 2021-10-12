package ex42;
/*
 *  UCF COP3330 Fall 2021 Exercise 42 Solution
 *  Copyright 2021 Merrek DeBolt
 */

import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    public static Record[] createRecords(List<String> lines)
    {
        Record[] records = new Record[lines.size()];
        String currentLine;
        for (int index = 0; index < records.length; index++)
        {
            records[index] = new Record();

            currentLine = lines.get(index);

            records[index].LastName = currentLine.substring(0, currentLine.indexOf(","));
            currentLine = currentLine.substring(currentLine.indexOf(",") + 1);

            records[index].FirstName = currentLine.substring(0, currentLine.indexOf(","));
            currentLine = currentLine.substring(currentLine.indexOf(",") + 1);

            records[index].Salary = Integer.parseInt(currentLine);
        }
        return records;
    }

    public static void main(String[] args)
    {
        // Make a list of strings from a text file
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get("src/main/java/ex42/exercise42_input.txt"), StandardCharsets.US_ASCII); }
        catch (Exception e) { System.out.println("File not found."); return; }

        // Make an array of Records
        Record[] records = createRecords(lines);

        // Write output
        System.out.println(String.format("%s %10s %10s\n--------------------------", "Last", "First", "Salary"));
        for (int index = 0; index < records.length; index++)
            System.out.println(String.format("%8s %8s %8s", records[index].LastName, records[index].FirstName, records[index].Salary));
    }
}