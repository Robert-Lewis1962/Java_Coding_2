import java.util.ArrayList;
import java.util.List;

/**
 * FindBlockVisitor class
 * 
 * @author Robert Lewis
 * @version 1.0
 */

public class FindBlockVisitor extends AbstractVisitor {
    private ArrayList<Block> list = new ArrayList<Block>();
    private FindBlockFilter newFilter;
    private Block block;

    /**
     * takes in a find-block-filter
     * 
     * @param filter takes in a filter
     */
    public FindBlockVisitor(FindBlockFilter filter) {
        this.newFilter = filter;
    }

    @Override
    public void preVisit(Block b) {
        this.block = b;
        if (this.newFilter.matches(b)) {
            list.add(this.block);
        }
    }
    
    @Override
    public void preVisit(Transaction tx) {
        if (this.newFilter.matches(tx)) {
            list.add(this.block);
        }
    }
    
    @Override
    public void visit(TxInput input) {
        if (this.newFilter.matches(input) && !this.list.contains(this.block) ) {
            System.out.println("Yess");
            list.add(this.block);
        }
    }

    @Override
    public void visit(TxOutput output) {
        if (this.newFilter.matches(output) && !this.list.contains(this.block)) {
            System.out.println("YeSs");
            list.add(this.block);
        }
    }

    /**
     * returns a list of blocks that match filters
     * 
     * @return list of blocks matches
     */
    public List<Block> getMatches() {
        return this.list;
    }
}
