import junit.framework.TestCase;
/**
 * FindOutoutFilter test class
 * @author Robert Lewis
 * @version 1.0
 */
public class FindOutputFilterTest extends TestCase {
    /**
     * test 1 transactionFilter
     */
    public void testOutputFilter1() {
        FindOutputFilter idFilter = new FindOutputFilter("qwerty"); 
        FindBlockVisitor ftv = new FindBlockVisitor(idFilter);
        
        assertTrue(ftv.getMatches().isEmpty());
    }
    
    /**
     * test 2 outputFilter
     */
    public void testOutputFilter2() {
        FindOutputFilter idFilter = new FindOutputFilter("2"); 
        FindBlockVisitor ftv = new FindBlockVisitor(idFilter);
        Block block1 = new Block("O");
        Transaction trans1 = new Transaction("j");
        TxInput txIn = new TxInput("qwerty", 3);
        TxOutput txOut = new TxOutput("2", 1); 
        
        trans1.addOutput(txOut);
        block1.addTransaction(trans1);
        
        block1.accept(ftv);
        assertFalse(ftv.getMatches().isEmpty());
        assertEquals(1, ftv.getMatches().size());
        assertEquals("O", ftv.getMatches().get(0).getHash());
        assertFalse(idFilter.matches(trans1));
        assertTrue(idFilter.matches(txOut));
        assertFalse(idFilter.matches(block1));
        assertFalse(idFilter.matches(txIn));
    }
    
    /**
     * test 2 outputFilter
     */
    public void testOutputFilter3() {
        FindOutputFilter idFilter = new FindOutputFilter("qwerty"); 
        FindBlockVisitor ftv = new FindBlockVisitor(idFilter);
        Block block1 = new Block("O");
        Transaction trans1 = new Transaction("j");
        TxInput txIn = new TxInput("qwerty", 3);
        TxOutput txOut = new TxOutput("2", 1); 
        trans1.addInput(txIn);
        
        block1.addTransaction(trans1);
        
        block1.accept(ftv);
        assertFalse(ftv.getMatches().isEmpty());
        assertEquals(1, ftv.getMatches().size());
        assertEquals("O", ftv.getMatches().get(0).getHash());
        assertFalse(idFilter.matches(trans1));
        assertFalse(idFilter.matches(txOut));
        assertFalse(idFilter.matches(block1));
        assertTrue(idFilter.matches(txIn));
        
    }
    
    /**
     * test 2 outputFilter
     */
    public void testOutputFilter4() {
        FindOutputFilter idFilter = new FindOutputFilter("qwerty"); 
        FindBlockVisitor ftv = new FindBlockVisitor(idFilter);
        Block block1 = new Block("O");
        Transaction trans1 = new Transaction("j");
        TxInput txIn = new TxInput("qwerty", 3);
        TxOutput txOut = new TxOutput("qwerty", 1); 
        trans1.addInput(txIn);
        trans1.addOutput(txOut);
        block1.addTransaction(trans1);
        
        block1.accept(ftv);
        assertFalse(ftv.getMatches().isEmpty());
        assertEquals(1, ftv.getMatches().size());
        assertEquals("O", ftv.getMatches().get(0).getHash());
        assertFalse(idFilter.matches(trans1));
        assertTrue(idFilter.matches(txIn));
        assertTrue(idFilter.matches(txOut));
        assertFalse(idFilter.matches(block1));
        
        
    }
    
    /**
     * test 2 outputFilter
     */
    public void testOutputFilter5() {
        FindOutputFilter idFilter = new FindOutputFilter("qwerty"); 
        FindBlockVisitor ftv = new FindBlockVisitor(idFilter);
        Block block1 = new Block("O");
        Transaction trans1 = new Transaction("j");
        Transaction trans2 = new Transaction("g");
        TxInput txIn = new TxInput("qwerty", 3);
        TxOutput txOut = new TxOutput("k", 1); 
        trans1.addInput(txIn);
        trans1.addOutput(txOut);
        trans2.addInput(txIn);
        trans2.addOutput(txOut);
        block1.addTransaction(trans1);
        block1.addTransaction(trans2);
        
        block1.accept(ftv);
        assertFalse(ftv.getMatches().isEmpty());
        assertEquals(1, ftv.getMatches().size());
        assertEquals("O", ftv.getMatches().get(0).getHash());
        assertFalse(idFilter.matches(trans1));
        assertTrue(idFilter.matches(txIn));
        assertFalse(idFilter.matches(txOut));
        assertFalse(idFilter.matches(block1));
        
        
    }
    
    /**
     * test 2 outputFilter
     */
    public void testOutputFilter6() {
        FindOutputFilter idFilter = new FindOutputFilter("qwerty"); 
        FindBlockVisitor ftv = new FindBlockVisitor(idFilter);
        Block block1 = new Block("O");
        Transaction trans1 = new Transaction("j");
        Transaction trans2 = new Transaction("g");
        TxInput txIn = new TxInput("qwerty", 3);
        TxOutput txOut = new TxOutput("k", 1); 
        trans1.addInput(txIn);
        trans1.addOutput(txOut);
        trans2.addInput(txIn);
        trans2.addOutput(txOut);
        block1.addTransaction(trans1);
        block1.addTransaction(trans2);
        
        block1.accept(ftv);
        assertFalse(ftv.getMatches().isEmpty());
        assertEquals(1, ftv.getMatches().size());
        assertEquals("O", ftv.getMatches().get(0).getHash());
        assertFalse(idFilter.matches(trans1));
        assertTrue(idFilter.matches(txIn));
        assertFalse(idFilter.matches(txOut));
        assertFalse(idFilter.matches(block1));
        
    }
    
    /**
     * test 2 outputFilter
     */
    public void testOutputFilter7() {
        FindOutputFilter idFilter = new FindOutputFilter("qwerty"); 
        FindBlockVisitor ftv = new FindBlockVisitor(idFilter);
        Block block1 = new Block("O");
       // Block block2 = new Block("R");
        Transaction trans1 = new Transaction("j");
        Transaction trans2 = new Transaction("g");
        TxInput txIn = new TxInput("qwerty", 3);
        TxOutput txOut = new TxOutput("k", 1); 
        trans1.addInput(txIn);
        trans1.addOutput(txOut);
        trans2.addInput(txIn);
        trans2.addOutput(txOut);
        block1.addTransaction(trans1);
        block1.addTransaction(trans2);
        
        block1.accept(ftv);
        assertFalse(ftv.getMatches().isEmpty());
        assertEquals(1, ftv.getMatches().size());
        assertEquals("O", ftv.getMatches().get(0).getHash());
        assertFalse(idFilter.matches(trans1));
        assertTrue(idFilter.matches(txIn));
        assertFalse(idFilter.matches(txOut));
        assertFalse(idFilter.matches(block1));
        
    }
}
