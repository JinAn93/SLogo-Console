package Commands;

import java.util.ResourceBundle;

public abstract class Command implements Node {
    protected String strValue = "eben";
    private boolean operand;

    @Override
    public String setValue (String str) {
        strValue = str;
        return strValue;
    }

    @Override
    public String getValue () {
        if (isOperand())
            return getValue();
        return executeCommand();
    }

    public abstract void setChildren (Node[] kids, ResourceBundle parameters);
    
    
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

    public abstract Node[] getChildren ();
}
