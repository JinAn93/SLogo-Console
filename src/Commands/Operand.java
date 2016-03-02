package Commands;

public class Operand implements Node {
    private String myStrValue;
    private boolean myOperand;

    @Override
    public String setValue (String str) {
        myStrValue = str;
        return null;
    }

    @Override
    public String getValue () {
        return myStrValue;
    }

    public boolean setOperand (boolean bool) {
        myOperand = bool;
        return myOperand;
    }

    public boolean isOperand () {
        return myOperand;
    }
}
