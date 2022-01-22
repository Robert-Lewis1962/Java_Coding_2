/**
 * FindBlockByHashFilter class
 * @author Robert Lewis
 * @version 1.0
 *
 */
public class FindBlockByHashFilter implements FindBlockFilter {
    private String blockHash;
    /**
     * takes in a hash of a block
     * @param hash the block's hash
     */
    public FindBlockByHashFilter(String hash) {
        this.blockHash = hash;
    }

    @Override
    public boolean matches(Block b) {
        return b.getHash().equals(this.blockHash);
        
        
    }

    @Override
    public boolean matches(Transaction tx) {
        return false;
    }

    @Override
    public boolean matches(TxInput input) {
        return false;
    }

    @Override
    public boolean matches(TxOutput output) {
        return false;
    }

}
