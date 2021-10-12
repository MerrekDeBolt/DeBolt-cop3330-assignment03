package ex45;

import org.junit.Assert;
import org.junit.Test;

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

        String oldText = App.fileToString();
        String newText = App.replaceString(oldText);

        Assert.assertFalse(oldText.indexOf("utilize") == -1);
        Assert.assertFalse(newText.indexOf("use") == -1);
    }
}
