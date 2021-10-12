package ex41;
/*
 *  UCF COP3330 Fall 2021 Exercise 41 Solution
 *  Copyright 2021 Merrek DeBolt
 */

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.io.FileWriter;

public class App {

    public static Record[] createRecords(List<String> lines)
    {
        Record[] records = new Record[lines.size()];
        for (int index = 0; index < lines.size(); index++)
        {
            records[index] = new Record();
            records[index].Value = lines.get(index);
        }

        return records;
    }

    public static Record[] sortRecords(List<String> lines)
    {
        Collections.sort(lines);
        return createRecords(lines);
    }

    public static void main(String[] args)
    {
        // Must count how many lines there are in the text file.
        List<String> lines;
        FileWriter writer;
        try { lines = Files.readAllLines(Paths.get("src/main/java/ex41/exercise41_input.txt"), StandardCharsets.US_ASCII); }
        catch (Exception e) { System.out.println("File not found."); return; }

        // Sort
        sortRecords(lines);

        // Write output
        try
        {
            writer = new FileWriter("src/main/java/ex41/exercise41_output.txt");

            writer.write("Total of 7 names\n-----------------\n");
            for (int index = 0; index < lines.size(); index++)
                writer.write(lines.get(index) + "\n");

            writer.close();
        }
        catch (Exception e) { System.out.println("File not found."); return; }
    }
}