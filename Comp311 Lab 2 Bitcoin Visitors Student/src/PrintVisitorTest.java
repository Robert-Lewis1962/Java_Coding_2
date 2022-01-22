import junit.framework.TestCase;
/**
 * PrintVisitor Test Class
 * @author K
 * @version 1.0
 */
public class PrintVisitorTest extends TestCase {

    /**
     * test 1 visit to TxInput
     */
    public void testPrintVistor1() {
        PrintVisitor pv = new PrintVisitor();
        TxInput txOne = new TxInput("abc 123", 10);
        
        txOne.accept(pv);
        assertEquals("      Address: abc 123\n"
              + "      Amount: " + txOne.getAmount() + "\n", pv.getResult());
    }
    
    /**
     * test 2 visit to TxInput
     */
    public void testPrintVistor2() {
        PrintVisitor pv = new PrintVisitor();
        TxOutput txOne = new TxOutput("abc 123", 10);
        
        txOne.accept(pv);
        assertEquals("      Address: " + txOne.getAddress() + "\n"
              + "      Amount: " + txOne.getAmount() + "\n", pv.getResult());
    }
    
    /**
     * test 3 visit to Transaction without TxIO
     */
    public void testPrintVistor3() {
        PrintVisitor pv = new PrintVisitor();
        Transaction transOne = new Transaction("1");

        transOne.accept(pv);
        assertEquals("  Transaction: " + transOne.getId() + "\n"
                , pv.getResult());
    }
    
    /**
     * test 4 visit to Transaction with output
     */
    public void testPrintVistor4() {
        PrintVisitor pv = new PrintVisitor();
        Transaction transOne = new Transaction("1");
        TxOutput txOne = new TxOutput("abc 123", 10);
        
        transOne.addOutput(txOne);
        
        transOne.accept(pv);
        assertEquals("  Transaction: " + transOne.getId() + "\n"
                + "    Outputs:\n"
                + "      Address: " + txOne.getAddress() + "\n"
                + "      Amount: " + txOne.getAmount() + "\n"
                , pv.getResult());
    }
    
    /**
     * test 5 visit to Transaction with input
     */
    public void testPrintVistor5() {
        PrintVisitor pv = new PrintVisitor();
        Transaction transOne = new Transaction("1");
        TxInput txOne = new TxInput("abc 123", 10);
        
        transOne.addInput(txOne);
        
        transOne.accept(pv);
        assertEquals("  Transaction: " + transOne.getId() + "\n"
                + "    Inputs:\n"
                + "      Address: " + txOne.getAddress() + "\n"
                + "      Amount: " + txOne.getAmount() + "\n"
                , pv.getResult());
    }
    
    /**
     * test 6 visit to Transaction with input and output
     */
    public void testPrintVistor6() {
        PrintVisitor pv = new PrintVisitor();
        Transaction transOne = new Transaction("1");
        TxInput txOne = new TxInput("abc 123", 10);
        TxOutput txTwo = new TxOutput("jdk 007", 5);
        
        // INPUT
        transOne.addInput(txOne);
        // OUTPUT
        transOne.addOutput(txTwo);
        
        transOne.accept(pv);
        assertEquals("  Transaction: " + transOne.getId() + "\n"
                + "    Inputs:\n"
                + "      Address: " + txOne.getAddress() + "\n"
                + "      Amount: " + txOne.getAmount() + "\n"
                + "    Outputs:\n"
                + "      Address: " + txTwo.getAddress() + "\n"
                + "      Amount: " + txTwo.getAmount() + "\n"
                , pv.getResult());
    }
    
    /**
     * test 7 visit to Block with no Transactions/Children/Parent
     */
    public void testPrintVistor7() {
        PrintVisitor pv = new PrintVisitor();
        Block blockOne = new Block("Q");
        
        blockOne.accept(pv);
        assertEquals("Block: " + blockOne.getHash() + "\n"
            , pv.getResult());
    }
    
    /**
     * test 8 visit to Block with one Transactions
     *  and no Children/Parent
     */
    public void testPrintVistor8() {
        PrintVisitor pv = new PrintVisitor();
        Block blockOne = new Block("Q");
        Transaction transOne = new Transaction("1");
        TxInput txOne = new TxInput("abc 123", 10);
        TxOutput txTwo = new TxOutput("jdk 007", 5);
        
        // INPUT
        transOne.addInput(txOne);
        // OUTPUT
        transOne.addOutput(txTwo);
        // TRANS IN BLOCK
        blockOne.addTransaction(transOne);
        
        blockOne.accept(pv);
        assertEquals("Block: " + blockOne.getHash() + "\n"
            + "  Transaction: " + transOne.getId() + "\n"
            + "    Inputs:\n"
            + "      Address: " + txOne.getAddress() + "\n"
            + "      Amount: " + txOne.getAmount() + "\n"
            + "    Outputs:\n"
            + "      Address: " + txTwo.getAddress() + "\n"
            + "      Amount: " + txTwo.getAmount() + "\n"
            , pv.getResult());
    }
    
    /**
     * test 9 visit to Block with one Transactions
     *  and no Children/Parent
     */
    public void testPrintVistor9() {
        PrintVisitor pv = new PrintVisitor();
        Block blockOne = new Block("Q");
        Block blockTwo = new Block("O");
        Transaction transOne = new Transaction("1");
        TxInput txOne = new TxInput("abc 123", 10);
        TxOutput txTwo = new TxOutput("jdk 007", 5);
        
        // INPUT
        transOne.addInput(txOne);
        // OUTPUT
        transOne.addOutput(txTwo);
        // TRANS IN BLOCK
        blockOne.addTransaction(transOne);
        // Child of block
        blockOne.addChild(blockTwo);
        // Parent of child block
        
        blockOne.accept(pv);
        assertEquals("Block: " + blockOne.getHash() + "\n"
            + "  Transaction: " + transOne.getId() + "\n"
            + "    Inputs:\n"
            + "      Address: " + txOne.getAddress() + "\n"
            + "      Amount: " + txOne.getAmount() + "\n"
            + "    Outputs:\n"
            + "      Address: " + txTwo.getAddress() + "\n"
            + "      Amount: " + txTwo.getAmount() + "\n"
            + "Block: " + blockTwo.getHash() + "\n"
            + "  Parent: " + blockTwo.getParent().getHash() + "\n"
            , pv.getResult());
    }
    
    /**
     * test 10 visit to Block with one Transactions
     *  and no Children/Parent
     */
    public void testPrintVistor10() {
        PrintVisitor pv = new PrintVisitor();
        Block bc1 = new Block("Q");
        Block bc2 = new Block("O");
        Block bc3 = new Block("C");
        Block bc4 = new Block("G");
        Transaction transOne = new Transaction("1");
        TxInput txOne = new TxInput("abc 123", 10);
        TxOutput txTwo = new TxOutput("jdk 007", 5);
        
        // INPUT
        transOne.addInput(txOne);
        // OUTPUT
        transOne.addOutput(txTwo);
        // TRANS IN BLOCK
        bc1.addTransaction(transOne);
        // Child of block
        bc1.addChild(bc2);
        bc1.addChild(bc3);
        bc2.addChild(bc4);
        // Parent of child block
        
        bc1.accept(pv);
        assertEquals("Block: " + bc1.getHash() + "\n"
            + "  Transaction: " + transOne.getId() + "\n"
            + "    Inputs:\n"
            + "      Address: " + txOne.getAddress() + "\n"
            + "      Amount: " + txOne.getAmount() + "\n"
            + "    Outputs:\n"
            + "      Address: " + txTwo.getAddress() + "\n"
            + "      Amount: " + txTwo.getAmount() + "\n"
            + "Block: " + bc2.getHash() + "\n"
            + "  Parent: " + bc2.getParent().getHash() + "\n"
            + "Block: " + bc4.getHash() + "\n"
            + "  Parent: " + bc4.getParent().getHash() + "\n"
            + "Block: " + bc3.getHash() + "\n"
            + "  Parent: " + bc3.getParent().getHash() + "\n"
            , pv.getResult());
    }
}
