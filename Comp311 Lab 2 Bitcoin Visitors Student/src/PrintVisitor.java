/**
 * PrintVistor Class
 * 
 * @author Robert Lewis
 * @version 1.0
 */
public class PrintVisitor extends AbstractVisitor {
    private StringBuffer buff = new StringBuffer();

    @Override
    public void preVisit(Block b) {
        this.buff.append("Block: " + b.getHash() + "\n");
        if (b.getParent() != null) {
            this.buff.append("  ");
            this.buff.append("Parent: " + b.getParent().getHash() + "\n");
        }
    }

    @Override
    public void preVisit(Transaction tx) {
        this.buff.append("  ");
        this.buff.append("Transaction: " + tx.getId() + "\n");
    }

    @Override
    public void postInputVisit(Transaction tx) {
        this.buff.append("    ");
        this.buff.append("Inputs:\n");
    }

    @Override
    public void postVisit(Transaction tx) {
        this.buff.append("    ");
        this.buff.append("Outputs:\n");
    }

    @Override
    public void visit(TxInput input) {
        this.buff.append("      ");
        this.buff.append("Address: " + input.getAddress() + "\n");
        this.buff.append("      ");
        this.buff.append("Amount: " + input.getAmount() + "\n");
    }

    @Override
    public void visit(TxOutput output) {
        this.buff.append("      ");
        this.buff.append("Address: " + output.getAddress() + "\n");
        this.buff.append("      ");
        this.buff.append("Amount: " + output.getAmount() + "\n");
    }

    /**
     * prints out the block chain
     * 
     * @return the block chain
     */
    public String getResult() {
        return buff.toString();
    }

}
