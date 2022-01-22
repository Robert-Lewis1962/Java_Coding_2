import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Block Class
 * 
 * @author Robert Lewis
 * @version 1.0
 */
public class Block implements Visitable {
    private String blockId;
    private ArrayList<Transaction> transAct;
    private LinkedList<Block> blockChain;
    private Block pBlock;


    /**
     * Block takes in a string
     * 
     * @param hash is the id of the block
     */
    public Block(String hash) {
        this.blockId = hash;
        this.transAct = new ArrayList<Transaction>();
        this.blockChain = new LinkedList<Block>();
    }

    /**
     * adds children blocks to this block
     * 
     * @param b children blocks
     */
    public void addChild(Block b) {
        b.setParent(this);
        this.blockChain.add(b);
    }

    /**
     * list of transactions in a block
     * 
     * @param tx each transaction being added to block
     */
    public void addTransaction(Transaction tx) {
        this.transAct.add(tx);
    }

    /**
     * gets the block by the hash
     * 
     * @return the block
     */
    public String getHash() {
        return this.blockId;
    }

    /**
     * gets the parent of this block
     * 
     * @return the parent block
     */
    public Block getParent() {
        return this.pBlock;
    }

    /**
     * sets the parent to this block
     * 
     * @param parent block's parent
     */
    public void setParent(Block parent) {
        this.pBlock = parent;
    }

    @Override
    public void accept(Visitor v) {

        v.preVisit(this);

        for (int i = 0; i < this.transAct.size(); i++) {
            this.transAct.get(i).accept(v);
        }

        for (int i = 0; i < this.blockChain.size(); i++) {
            this.blockChain.get(i).accept(v);
        }
        
        v.postVisit(this);
    }
}
