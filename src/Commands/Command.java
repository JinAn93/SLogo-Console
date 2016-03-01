package Commands;

import java.util.ResourceBundle;

public abstract class Command implements Node {
    protected String strValue = "eben";
    private boolean operand;
    private boolean variable;

    @Override
    public String setValue (String str) {
        strValue = str;
        return strValue;
    }

    @Override
    public String getValue () {
        if (isOperand())
            return getValue();
        if (isVariable())
            return getValue();
        return executeCommand();
    }

    public abstract void setChildren (Node[] kids);
    
    
    public String executeCommand () {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean setOperand (boolean bool) {
        operand = bool;
        return operand;
    }

    public boolean isOperand () {
        return operand;
    }
    
    public boolean setVariable (boolean bool){
        variable = bool;
        return variable;
    }
    
    public boolean isVariable(){
        return variable;
    }

    public abstract Node[] getChildren ();
}
