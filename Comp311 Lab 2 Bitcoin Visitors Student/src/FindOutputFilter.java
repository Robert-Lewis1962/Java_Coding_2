/**
 * FindOutputFilter class
 * @author Robert Lewis
 * @version 1.0
 */
public class FindOutputFilter implements FindBlockFilter {
    private String ads;
    /**
     * takes in an address of output/input
     * @param address of input/output
     */
    public FindOutputFilter(String address) {
        this.ads = address;
    }

    @Override
    public boolean matches(Block b) {
        return false;
    }

    @Override
    public boolean matches(Transaction tx) {
        return false;
    }

    @Override
    public boolean matches(TxInput input) {
        return input.getAddress().equals(this.ads);
    }

    @Override
    public boolean matches(TxOutput output) {
        return output.getAddress().equals(this.ads);
    }

}
