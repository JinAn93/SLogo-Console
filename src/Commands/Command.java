package Commands;

public abstract class Command implements Node {
    protected String strValue = "eben";
    private boolean operand;
    private final String OPERAND = "Operand";
    protected Node[] children;

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

    public void setChildren (Node[] kids) {
        children = new Node[kids.length];
        for (int i = 0; i < kids.length; i++) {
            children[i] = kids[i];
        }
    }

    public Node[] getChildren () {
        // TODO Auto-generated method stub
        return null;
    }

    public int numberOfChildren () {
        // TODO Auto-generated method stub
        return 0;
    }
}
