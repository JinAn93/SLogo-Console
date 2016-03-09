package NodeTypes;

public class Variable implements Node {

    private String myValue, myName;
    private boolean IsVariable;

    public void setName (String str) {
        myName = str;
    }

    public String getName () {
        return myName;
    }

    public boolean isVariable () {
        return IsVariable;
    }

    public boolean setVariable (boolean bool) {
        IsVariable = bool;
        return IsVariable;
    }

    @Override
    public String setValue (String str) {
        myValue = str;
        return null;
    }

    @Override
    public String getValue () {
        return myValue;
    }
}
