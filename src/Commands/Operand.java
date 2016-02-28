package Commands;

public class Operand implements Node {
    private String strValue;
    private final String OPERAND = "Operand";
    private boolean operand;

    @Override
    public String setValue (String str) {
        strValue = str;
        return null;
    }

    @Override
    public String getValue () {
        return strValue;
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

    public void setChildren (Node[] children) {
        // TODO Auto-generated method stub
    }

    public Node[] getChildren () {
        // TODO Auto-generated method stub
        return null;
    }
}
