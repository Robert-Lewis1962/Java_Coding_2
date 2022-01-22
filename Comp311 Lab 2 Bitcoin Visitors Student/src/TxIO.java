/**
 * TxIO base class of TxInput and TxOutput
 * 
 * @author Robert Lewis
 * @version 1.0
 */
public abstract class TxIO implements Visitable {
    private String ipAddress;
    private int bitAmount;

    /**
     * takes in an address and amount
     * 
     * @param address the address
     * @param amount  the amount
     */
    public TxIO(String address, int amount) {
        this.ipAddress = address;
        this.bitAmount = amount;
    }

    /**
     * returns the address
     * 
     * @return the address
     */
    public String getAddress() {
        return this.ipAddress;
    }

    /**
     * returns the amount
     * 
     * @return the amount
     */
    public int getAmount() {
        return this.bitAmount;
    }
}
