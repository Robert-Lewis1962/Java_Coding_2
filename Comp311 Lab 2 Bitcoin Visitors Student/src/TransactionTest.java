import java.util.List;

import junit.framework.TestCase;

/**
 * TransactionTest class
 * 
 * @author K
 * @version 1.0
 */
public class TransactionTest extends TestCase {

    /**
     * test transaction with no inputs or outputs
     */
    public void testTransaction1() {
        Transaction trans = new Transaction("1");
        assertNotNull(trans);
        assertEquals("1", trans.getId());
    }

    /**
     * test transaction with one input but no outputs
     */
    public void testTransaction2() {
        Transaction trans = new Transaction("1");
        assertNotNull(trans);
        assertEquals("1", trans.getId());

        // TxInput area
        TxInput txOne = new TxInput("123 North", 20);
        assertNotNull(txOne);
        assertEquals("123 North", txOne.getAddress());
        assertEquals(20, txOne.getAmount());

        // adding to transaction
        trans.addInput(txOne);
        assertEquals(1, trans.getInputs().size());
        assertEquals(0, trans.getOutputs().size());
        List<TxIO> list = trans.getInputs();
        TxIO txTwo = list.get(0);
        assertEquals("123 North", txTwo.getAddress());
        assertEquals(20, txTwo.getAmount());
    }

    /**
     * test transaction with no inputs but one outputs
     */
    public void testTransaction3() {
        Transaction trans = new Transaction("1");
        assertNotNull(trans);
        assertEquals("1", trans.getId());

        // TxOutput area
        TxOutput txOne = new TxOutput("123 North", 20);
        assertNotNull(txOne);
        assertEquals("123 North", txOne.getAddress());
        assertEquals(20, txOne.getAmount());

        // adding to transaction
        trans.addOutput(txOne);
        assertEquals(0, trans.getInputs().size());
        assertEquals(1, trans.getOutputs().size());
        List<TxIO> list = trans.getOutputs();
        TxIO txTwo = list.get(0);
        assertEquals("123 North", txTwo.getAddress());
        assertEquals(20, txTwo.getAmount());
    }

    /**
     * test transaction with one input and output
     */
    public void testTransaction4() {
        Transaction trans = new Transaction("1");
        assertNotNull(trans);
        assertEquals("1", trans.getId());

        // TxOutput area
        TxOutput txOne = new TxOutput("456 North", 20);
        assertNotNull(txOne);
        assertEquals("456 North", txOne.getAddress());
        assertEquals(20, txOne.getAmount());

        // TxInput area
        TxInput txTwo = new TxInput("123 North", 20);
        assertNotNull(txTwo);
        assertEquals("123 North", txTwo.getAddress());
        assertEquals(20, txTwo.getAmount());

        // adding to transaction
        trans.addOutput(txOne);
        trans.addInput(txTwo);
        assertEquals(1, trans.getInputs().size());
        assertEquals(1, trans.getOutputs().size());
        List<TxIO> list1 = trans.getInputs();
        List<TxIO> list2 = trans.getOutputs();
        TxIO txTemp1 = list1.get(0);
        TxIO txTemp2 = list2.get(0);
        assertEquals("123 North", txTemp1.getAddress());
        assertEquals(20, txTemp1.getAmount());
        assertEquals("456 North", txTemp2.getAddress());
        assertEquals(20, txTemp2.getAmount());
    }
}
