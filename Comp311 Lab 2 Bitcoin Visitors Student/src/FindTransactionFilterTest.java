import junit.framework.TestCase;
/**
 * TransactionFilter test class
 * @author Robert Lewis
 *@version 1.0
 */
public class FindTransactionFilterTest extends TestCase {

    /**
     * test 1 transactionFilter
     */
    public void testTransactionFilter1() {
        FindTransactionFilter idFilter = new FindTransactionFilter("qwerty"); 
        FindBlockVisitor ftv = new FindBlockVisitor(idFilter);
        
        assertTrue(ftv.getMatches().isEmpty());
    }
    
    /**
     * test 2 transactionFilter
     */
    public void testTransactionFilter2() {
        FindTransactionFilter idFilter = new FindTransactionFilter("qwerty"); 
        FindBlockVisitor ftv = new FindBlockVisitor(idFilter);
        Block block1 = new Block("O");
        Transaction trans1 = new Transaction("qwerty");
        
        block1.addTransaction(trans1);
        
        block1.accept(ftv);
        assertFalse(ftv.getMatches().isEmpty());
        assertEquals(1, ftv.getMatches().size());
        assertEquals("O", ftv.getMatches().get(0).getHash());
    }
    
    /**
     * test 2 transactionFilter
     */
    public void testTransactionFilter3() {
        FindTransactionFilter idFilter = new FindTransactionFilter("qwerty"); 
        FindBlockVisitor ftv = new FindBlockVisitor(idFilter);
        Block block1 = new Block("O");
        Transaction trans1 = new Transaction("qwerty");
        TxInput txo = new TxInput("2", 1); 
        TxOutput txi = new TxOutput("3", 5);
        block1.addTransaction(trans1);
        
        block1.accept(ftv);
        assertFalse(ftv.getMatches().isEmpty());
        assertEquals(1, ftv.getMatches().size());
        assertEquals("O", ftv.getMatches().get(0).getHash());
        assertTrue(idFilter.matches(trans1));
        assertFalse(idFilter.matches(txo));
        assertFalse(idFilter.matches(block1));
        assertFalse(idFilter.matches(txi));
        
    }
}
