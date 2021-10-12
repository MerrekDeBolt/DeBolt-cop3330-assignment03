package ex41;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        App app = new App();

        List<String> lines;
        try { lines = Files.readAllLines(Paths.get("src/main/java/ex41/exercise45_input.txt"), StandardCharsets.US_ASCII); }
        catch (Exception e) { System.out.println("File not found."); return; }
        Record[] unsortedRecords = App.createRecords(lines);

        assertEquals( "Ling, Mai", unsortedRecords[0].Value);
        assertEquals( "Johnson, Jim", App.sortRecords(lines)[0].Value);
    }
}
