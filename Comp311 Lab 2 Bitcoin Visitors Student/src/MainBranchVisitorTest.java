import junit.framework.TestCase;

/**
 * MainBranchVisitor Test Class
 * @author K
 * @version 1.0
 */
public class MainBranchVisitorTest extends TestCase {

    /**
     * test 1 with no tree
     */
    public void testMainBranch1() {
        MainBranchVisitor mbv = new MainBranchVisitor(); 
        assertTrue(mbv.getChain().isEmpty());
    }
    
    /**
     * test 2 with root block
     */
    public void testMainBranch2() {
        MainBranchVisitor mbv = new MainBranchVisitor(); 
        Block block1 = new Block("Q");
        block1.accept(mbv);
        assertEquals(1, mbv.getChain().size());
        assertEquals("Q", mbv.getChain().get(0).getHash());
    }
    
    /**
     * test 3 with root block and one child
     */
    public void testMainBranch3() {
        MainBranchVisitor mbv = new MainBranchVisitor(); 
        Block block1 = new Block("Q");
        Block block2 = new Block("O");
        block1.addChild(block2);
        
        
        block1.accept(mbv);
        assertEquals(2, mbv.getChain().size());
        assertEquals("Q", mbv.getChain().get(0).getHash());
        assertEquals("O", mbv.getChain().get(1).getHash());
    }
    
    
    /**
     * test 4 with root block and two child
     */
    public void testMainBranch4() {
        MainBranchVisitor mbv = new MainBranchVisitor(); 
        Block block1 = new Block("Q");
        Block block2 = new Block("O");
        Block block3 = new Block("P");
        
        // add blocks
        block1.addChild(block2);
        block2.addChild(block3);

        block1.accept(mbv);
        assertEquals(3, mbv.getChain().size());
        assertEquals("Q", mbv.getChain().get(0).getHash());
        assertEquals("O", mbv.getChain().get(1).getHash());
        assertEquals("P", mbv.getChain().get(2).getHash());
    }
    
    /**
     * test 5 with root block and two child
     */
    public void testMainBranch5() {
        MainBranchVisitor mbv = new MainBranchVisitor(); 
        Block block1 = new Block("Q");
        Block block2 = new Block("O");
        Block block3 = new Block("P");
        Block block4 = new Block("K");
        
        
        // add blocks
        block1.addChild(block2);
        block1.addChild(block4);
        block2.addChild(block3);

        block1.accept(mbv);
        assertEquals(3, mbv.getChain().size());
        assertEquals("Q", mbv.getChain().get(0).getHash());
        assertEquals("O", mbv.getChain().get(1).getHash());
        assertEquals("P", mbv.getChain().get(2).getHash());
    }
    
    /**
     * test 6 with root block and two child
     */
    public void testMainBranch6() {
        MainBranchVisitor mbv = new MainBranchVisitor(); 
        Block block1 = new Block("Q");
        Block block2 = new Block("O");
        Block block3 = new Block("P");
        Block block4 = new Block("K");
        Block block5 = new Block("M");
        Block block6 = new Block("U");
        
        // add blocks
        block1.addChild(block2);
        block1.addChild(block4);
        block2.addChild(block3);
        block4.addChild(block5);
        block5.addChild(block6);
        
        block1.accept(mbv);
        assertEquals(4, mbv.getChain().size());
        assertEquals("Q", mbv.getChain().get(0).getHash());
        assertEquals("K", mbv.getChain().get(1).getHash());
        assertEquals("M", mbv.getChain().get(2).getHash());
        assertEquals("U", mbv.getChain().get(3).getHash());
    }
    
    /**
     * test 7 with root block and two child
     */
    public void testMainBranch7() {
        MainBranchVisitor mbv = new MainBranchVisitor(); 
        Block block1 = new Block("Q");
        Block block2 = new Block("O");
        Block block3 = new Block("P");
        Block block4 = new Block("K");
        Block block5 = new Block("M");
        Block block6 = new Block("U");
        
        // add blocks
        block1.addChild(block2);
        block1.addChild(block4);
        block2.addChild(block3);
        block4.addChild(block5);
        block5.addChild(block6);
        
        block2.accept(mbv);
        assertEquals(3, mbv.getChain().size());
        assertEquals("Q", mbv.getChain().get(0).getHash());
        assertEquals("O", mbv.getChain().get(1).getHash());
        assertEquals("P", mbv.getChain().get(2).getHash());
    }
    
    /**
     * test 8 with root block and two child
     */
    public void testMainBranch8() {
        MainBranchVisitor mbv = new MainBranchVisitor(); 
        Block block1 = new Block("Q");
        Block block2 = new Block("O");
        Block block3 = new Block("P");
        Block block4 = new Block("K");
        Block block5 = new Block("M");
        Block block6 = new Block("U");
        
        // add blocks
        block1.addChild(block2);
        block1.addChild(block4);
        block2.addChild(block3);
        block4.addChild(block5);
        block5.addChild(block6);

        block4.accept(mbv);
        assertEquals(4, mbv.getChain().size());
        assertEquals("Q", mbv.getChain().get(0).getHash());
        assertEquals("K", mbv.getChain().get(1).getHash());
        assertEquals("M", mbv.getChain().get(2).getHash());
        assertEquals("U", mbv.getChain().get(3).getHash());
    }
    
    /**
     * test 9 with root block 
     */
    public void testMainBranch9() {
        MainBranchVisitor mbv = new MainBranchVisitor(); 
        Block block1 = new Block("Q");
        Block block2 = new Block("O");
        Block block3 = new Block("P");
        Block block4 = new Block("L");
        Block block5 = new Block("M");
        Block block6 = new Block("W");
        Block block7 = new Block("E");
        Block block8 = new Block("R");
        Block block9 = new Block("T");
        Block block10 = new Block("Y");
        Block block11 = new Block("U");
        Block block12 = new Block("A");
        Block block13 = new Block("S");
        Block block14 = new Block("D");
        Block block15 = new Block("F");
        Block block16 = new Block("G");
        Block block17 = new Block("H");
        Block block18 = new Block("J");
        Block block19 = new Block("K");
        
        // add blocks
        block1.addChild(block2);
        block1.addChild(block3);
        block2.addChild(block4);
        block2.addChild(block5);
        block2.addChild(block6);
        block6.addChild(block7);
        block6.addChild(block8);
        block7.addChild(block9);
        block3.addChild(block10);
        block3.addChild(block11);
        block3.addChild(block12);
        block12.addChild(block13);
        block12.addChild(block14);
        block12.addChild(block15);
        block13.addChild(block16);
        block16.addChild(block17);
        block16.addChild(block18);
        block18.addChild(block19);

        block1.accept(mbv);
        assertEquals(7, mbv.getChain().size());
        assertEquals("Q", mbv.getChain().get(0).getHash());
        assertEquals("P", mbv.getChain().get(1).getHash());
        assertEquals("A", mbv.getChain().get(2).getHash());
        assertEquals("S", mbv.getChain().get(3).getHash());
        assertEquals("G", mbv.getChain().get(4).getHash());
        assertEquals("J", mbv.getChain().get(5).getHash());
        assertEquals("K", mbv.getChain().get(6).getHash());
    }
    
    /**
     * test 10 with root block 
     */
    public void testMainBranch10() {
        MainBranchVisitor mbv = new MainBranchVisitor(); 
        Block block1 = new Block("Q");
        Block block2 = new Block("O");
        Block block3 = new Block("P");
        Block block4 = new Block("L");
        Block block5 = new Block("M");
        Block block6 = new Block("W");
        Block block7 = new Block("E");
        Block block8 = new Block("R");
        Block block9 = new Block("T");
        Block block10 = new Block("Y");
        Block block11 = new Block("U");
        
        // add blocks
        block1.addChild(block2);
        block2.addChild(block3);
        block2.addChild(block4);
        block2.addChild(block5);
        block3.addChild(block6);
        block6.addChild(block7);
        block5.addChild(block8);
        block8.addChild(block9);
        block9.addChild(block10);
        block10.addChild(block11);

        assertEquals("Q", block2.getParent().getHash());
        assertEquals("O", block3.getParent().getHash());
        assertEquals("O", block4.getParent().getHash());
        assertEquals("O", block5.getParent().getHash());
        assertEquals("P", block6.getParent().getHash());
        assertEquals("W", block7.getParent().getHash());
        assertEquals("M", block8.getParent().getHash());
        assertEquals("R", block9.getParent().getHash());
        assertEquals("T", block10.getParent().getHash());
        assertEquals("Y", block11.getParent().getHash());

        
        block1.accept(mbv);
        assertEquals(7, mbv.getChain().size());
        assertEquals("Q", mbv.getChain().get(0).getHash());
        assertEquals("O", mbv.getChain().get(1).getHash());
        assertEquals("M", mbv.getChain().get(2).getHash());
        assertEquals("R", mbv.getChain().get(3).getHash());
        assertEquals("T", mbv.getChain().get(4).getHash());
        assertEquals("Y", mbv.getChain().get(5).getHash());
        assertEquals("U", mbv.getChain().get(6).getHash());
    }
}
