import java.util.ArrayList;
import java.util.List;

/**
 * MainBranchVisitor class
 * 
 * @author Robert Lewis
 * @version 1.0
 */

public class MainBranchVisitor extends AbstractVisitor {
    private ArrayList<Block> list = new ArrayList<Block>();
    private int value = -1;
    private int max = 0;
    private Block temp;

    @Override
    public void preVisit(Block b) {
        ++value;
        if (value >= max) {
            max = value;
            temp = b;
        }
        
    }

    @Override
    public void postVisit(Block b) {
        --value;
    }

    /**
     * returns the longest block-chain in the tree
     * 
     * @return the list
     */
    public List<Block> getChain() {
        if (temp == null) {
            return list;
        }
        list.add(temp);
        while (temp.getParent() != null) {
            temp = temp.getParent();
            list.add(0, temp);
        }

        return list;
    }
}
