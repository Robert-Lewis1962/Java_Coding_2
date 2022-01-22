/**
 * findTransaction class
 * @author Robert Lewis
 * @version 1.0
 */
public class FindTransactionFilter implements FindBlockFilter {
    private String transId;
    /**
     * takes in the id of a transaction id
     * @param id transaction id
     */
    public FindTransactionFilter(String id) {
        this.transId = id;
    }

    @Override
    public boolean matches(Block b) {
        return false;
    }

    @Override
    public boolean matches(Transaction tx) {
        return tx.getId().equals(this.transId);
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
