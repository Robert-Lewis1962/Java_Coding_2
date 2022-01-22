import junit.framework.TestCase;
/**
 * ByHashFilter test class
 * @author Robert Lewis
 * @version 1.0
 */

public class FindBlockVisitorTest extends TestCase {
    /**
     * test 1 no block 
     */
    public void testByHash1() {
        FindBlockByHashFilter hashFilter = new FindBlockByHashFilter("P"); 
        FindBlockVisitor fbv = new FindBlockVisitor(hashFilter);
        
        assertTrue(fbv.getMatches().isEmpty());
    }
    
    /**
     * test 2 one block 
     */
    public void testByHash2() {
        FindBlockByHashFilter hashFilter = new FindBlockByHashFilter("O"); 
        FindBlockVisitor fbv = new FindBlockVisitor(hashFilter);
        Block block1 = new Block("O");
        
        block1.accept(fbv);
        assertFalse(fbv.getMatches().isEmpty());
        assertEquals(1, fbv.getMatches().size());
        assertEquals("O", fbv.getMatches().get(0).getHash());
    }
}
