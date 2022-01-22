import junit.framework.TestCase;


/**
 * Block Class Tests
 * @author Robert Lewis
 * @version 1.0
 */
public class BlockTest extends TestCase {
    /**
     * test one create a empty block
     */
    public void testBlock1() {
        Block bcOne = new Block("3s1");
        assertNotNull(bcOne);
        assertEquals("3s1", bcOne.getHash());
    }
    
    /**
     * test two create a block with a transaction
     */
    public void testBlock2() {
        Block bcOne = new Block("3s1");
        assertNotNull(bcOne);
        assertEquals("3s1", bcOne.getHash());
        
        //Transaction Area
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
        
        //Back to Block
        bcOne.addTransaction(trans);
    }
    
    /**
     * test three create parent block and child block
     */
    public void testBlock3() {
        Block bcOne = new Block("3s1");
        assertNotNull(bcOne);
        assertEquals("3s1", bcOne.getHash());
        Block bcTwo = new Block("5s1");
        assertNotNull(bcTwo);
        assertEquals("5s1", bcTwo.getHash());
        
        // adding child to block
        bcOne.addChild(bcTwo);
        assertEquals(bcOne, bcTwo.getParent());
    }
    
    /**
     * test three create parent block and child block
     */
    public void testBlock4() {
        Block bcOne = new Block("P");
        assertEquals("P", bcOne.getHash());
        Block bcTwo = new Block("O");
        assertEquals("O", bcTwo.getHash());
        Block bcThree = new Block("L");

        
        // adding child to block
        bcOne.addChild(bcTwo);
        bcOne.addChild(bcThree);
    }
    
    /**
     * test 5 create parent block and child block
     */
    public void testBlock5() {
        Block bcOne = new Block("P");
        assertEquals("P", bcOne.getHash());
        Block bcTwo = new Block("O");
        assertEquals("O", bcTwo.getHash());
        Block bcThree = new Block("L");
        Block bcFour = new Block("K");
        
        // adding child to block
        bcOne.addChild(bcTwo);
        bcOne.addChild(bcThree);
        bcTwo.addChild(bcFour);
    }
    
    /**
     * test 6 create parent block and child block
     */
    public void testBlock6() {
        Block bcOne = new Block("P");
        assertEquals("P", bcOne.getHash());
        Block bcTwo = new Block("O");
        assertEquals("O", bcTwo.getHash());
        Block bcThree = new Block("L");
        Block bcFour = new Block("K");
        Block bc5 = new Block("N");
        
        // adding child to block
        bcOne.addChild(bcTwo);
        bcOne.addChild(bcThree);
        bcTwo.addChild(bcFour);
        bcFour.addChild(bc5);
    }
    
    /**
     * test 7 create parent block and child block
     */
    public void testBlock7() {
        Block bcOne = new Block("P");
        assertEquals("P", bcOne.getHash());
        Block bcTwo = new Block("O");
        assertEquals("O", bcTwo.getHash());
        Block bcThree = new Block("L");
        Block bcFour = new Block("K");
        Block bc5 = new Block("N");
        Block bc6 = new Block("X");
        
        // adding child to block
        bcOne.addChild(bcTwo);
        bcOne.addChild(bcThree);
        bcTwo.addChild(bcFour);
        bcFour.addChild(bc5);
        bc5.addChild(bc6);
    }
}
