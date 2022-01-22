import java.util.ArrayList;
import java.util.List;

/**
 * Transaction class
 * 
 * @author Robert Lewis
 * @version 1.0
 */
public class Transaction implements Visitable {
    private String transId;
    private ArrayList<TxIO> inputList;
    private List<TxIO> outputList;

    /**
     * Transaction takes in an id
     * 
     * @param id id of the transaction
     */
    public Transaction(String id) {
        this.transId = id;
        this.inputList = new ArrayList<TxIO>();
        this.outputList = new ArrayList<TxIO>();
    }

    /**
     * adds the input into the transaction
     * 
     * @param input TxInputs
     */
    public void addInput(TxInput input) {
        this.inputList.add(input);
    }
    
    /**
     * adds the outputs into the transaction
     * @param output TxOutputs
     */
    public void addOutput(TxOutput output) {
        this.outputList.add(output);
    }

    /**
     * returns the id of the transaction
     * 
     * @return id
     */
    public String getId() {
        return this.transId;
    }

    /**
     * gets the list of inputs
     * 
     * @return list of inputs
     */
    public List<TxIO> getInputs() {
        return this.inputList;
    }
    
    /**
     * gets the list of outputs
     * @return list of outputs
     */
    public List<TxIO> getOutputs() {
        return this.outputList;
    }

    @Override
    public void accept(Visitor v) {
        v.preVisit(this);
        
        if (!this.inputList.isEmpty()) {
            v.postInputVisit(this);
        }
        
        for (int i = 0; i < this.getInputs().size(); i++) {
            this.inputList.get(i).accept(v);
        }
        
        if (!this.outputList.isEmpty()) {
            v.postVisit(this);
        }
        
        for (int i = 0; i < this.getOutputs().size(); i++) {
            this.outputList.get(i).accept(v);
        }
        
    }

}
