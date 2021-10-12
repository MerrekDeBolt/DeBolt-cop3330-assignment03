package ex43;

import ex43.Website;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
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
        Website website = new Website("awesomeco", "Max Powers", "y", "y");

        Path path = Paths.get("src/main/java/ex43/website/" + website.SiteName);
        try { Files.deleteIfExists(path); } catch (IOException ex) { }

        App.createWebsite(website);

        assertEquals( true, Files.exists(path));
        path = Paths.get("src/main/java/ex43/website/" + website.SiteName + "/index.html");
        assertEquals( true, Files.exists(path));
        path = Paths.get("src/main/java/ex43/website/" + website.SiteName + "/js");
        assertEquals( true, Files.exists(path));
        path = Paths.get("src/main/java/ex43/website/" + website.SiteName + "/css");
        assertEquals( true, Files.exists(path));
    }
}
