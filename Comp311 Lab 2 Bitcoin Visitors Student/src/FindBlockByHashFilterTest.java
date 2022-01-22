import junit.framework.TestCase;
/**
 * FindBlockByHashFilter test class
 * @author K
 * @version 1.0
 */
public class FindBlockByHashFilterTest extends TestCase {

    /**
     * test 2 transactionFilter
     */
    public void testTransactionFilter3() {
        FindBlockByHashFilter hashFilter = new FindBlockByHashFilter("O");
        FindBlockVisitor ftv = new FindBlockVisitor(hashFilter);
        Block block1 = new Block("O");
        Transaction trans1 = new Transaction("qwerty");
        TxInput txo = new TxInput("2", 1); 
        TxOutput txi = new TxOutput("3", 5);
        block1.addTransaction(trans1);
        
        block1.accept(ftv);
        assertFalse(ftv.getMatches().isEmpty());
        assertEquals(1, ftv.getMatches().size());
        assertEquals("O", ftv.getMatches().get(0).getHash());
        assertFalse(hashFilter.matches(trans1));
        assertFalse(hashFilter.matches(txo));
        assertTrue(hashFilter.matches(block1));
        assertFalse(hashFilter.matches(txi));
        
    }
    
    
}
