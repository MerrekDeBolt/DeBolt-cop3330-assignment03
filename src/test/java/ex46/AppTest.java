package ex46;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


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

        ArrayList<String> wordStrings = new ArrayList<String>();
        wordStrings.add("badger");
        wordStrings.add("badger");
        wordStrings.add("badger");
        wordStrings.add("badger");
        wordStrings.add("mushroom");
        wordStrings.add("mushroom");
        wordStrings.add("snake");
        wordStrings.add("badger");
        wordStrings.add("badger");
        wordStrings.add("badger");

        ArrayList<Word> words = App.createWords(wordStrings);

        Assert.assertEquals(7, words.get(0).Amount);
        Assert.assertEquals(2, words.get(1).Amount);
        Assert.assertEquals(1, words.get(2).Amount);
    }
}
