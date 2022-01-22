import junit.framework.TestCase;

/**
 * Test input and output from the base class
 * @author Robert Lewis
 * @version 1.0
 *
 */
public class TxIOTest extends TestCase {

    /**
     * test 1 test both input and output class
     */
    public void testTxIo() {
        TxIO txOne = new TxInput("123 North", 20);
        assertNotNull(txOne);
        assertEquals("123 North", txOne.getAddress());
        assertEquals(20, txOne.getAmount());

        TxIO txTwo = new TxOutput("123 North", 20);
        assertNotNull(txTwo);
        assertEquals("123 North", txTwo.getAddress());
        assertEquals(20, txTwo.getAmount());
    }

}
