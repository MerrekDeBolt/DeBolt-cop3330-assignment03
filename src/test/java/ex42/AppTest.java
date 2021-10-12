package ex42;

import ex42.App;
import ex42.Record;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        try { lines = Files.readAllLines(Paths.get("src/main/java/ex42/exercise46_input.txt"), StandardCharsets.US_ASCII); }
        catch (Exception e) { System.out.println("File not found."); return; }

        assertEquals( "Ling,Mai,55900", lines.get(0));

        Record[] records = App.createRecords(lines);
        assertEquals( "Ling", records[0].LastName);
        assertEquals( "Mai", records[0].FirstName);
        assertEquals( 55900, records[0].Salary);
    }
}
