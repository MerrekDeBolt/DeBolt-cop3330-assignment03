package ex44;

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

        Item item = App.createProducts();

        assertEquals( "Widget", item.products[0].name);
        assertEquals( 25.00, item.products[0].price, 0);
        assertEquals( 5, item.products[0].quantity);

        assertEquals(true, App.isItemNotFound(item, "Jeff"));
        assertEquals(false, App.isItemNotFound(item, "Widget"));
    }
}
