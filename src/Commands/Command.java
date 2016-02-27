package Commands;

public abstract class Command implements Node{
    protected String strValue = "eben";
    private boolean operand;
    private final String OPERAND = "Operand";


    @Override
    public String setValue (String str) {
        strValue = str;
        return strValue;
    }

    @Override
    public String getValue () {
        if(isOperand()) return getValue();
        return executeCommand();
        
    }

    public String executeCommand () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean setOperand (boolean bool) {
        operand = bool;
        return operand;
    }

    @Override
    public boolean isOperand () {
        return operand;
    }

    @Override
    public String traverseDown () {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int numberOfChildren () {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setChildren (Node[] children) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Node[] getChildren () {
        // TODO Auto-generated method stub
        return null;
    }

 
    
}
