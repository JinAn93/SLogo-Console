package Commands;

public abstract class Command implements Node {
    protected Node[] myChildren;
    protected String myStrValue;
    protected boolean isChildOperand;
    protected boolean isChildVariable;

    public abstract String executeCommand ();

    public boolean setOperand (boolean bool) {
        isChildOperand = bool;
        return isChildOperand;
    }

    public boolean isOperand () {
        return isChildOperand;
    }

    public boolean setVariable (boolean bool) {
        isChildVariable = bool;
        return isChildVariable;
    }

    public boolean isVariable () {
        return isChildVariable;
    }

    public void setChildren (Node[] kids) {
        myChildren = kids;
    }

    public Node[] getChildren () {
        return myChildren;
    }

    @Override
    public String setValue (String str) {
        myStrValue = str;
        return myStrValue;
    }

    @Override
    public String getValue () {
        if (isOperand())
            return getValue();
        if (isVariable())
            return getValue();
        return executeCommand();
    }

}
