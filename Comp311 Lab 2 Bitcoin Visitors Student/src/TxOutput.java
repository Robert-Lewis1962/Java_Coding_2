/**
 * TxOutput subclass of TxIO
 * 
 * @author Robert Lewis
 * @version 1.0
 */
public class TxOutput extends TxIO {

    /**
     * takes in an address and amount
     * 
     * @param address the address
     * @param amount  the amount
     */
    public TxOutput(String address, int amount) {
        super(address, amount);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
