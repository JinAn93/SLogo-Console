package NodeTypes;

/**
 * Command is a subclass of Node and it serves to store the built-in commands, its parameter
 * children, and values. Once it is executed in getValue method, it will contain string value.
 *
 * @author Jin An
 * @author Sarp Uner
 *
 */
public abstract class Command implements Node {

    protected Node[] myChildren;
    protected String myStrValue;
    protected boolean isChildOperand;
    protected boolean isChildVariable;
    protected boolean isChildUserCommand;
    protected static final int FIRSTCHILD = 0;
    protected static final int SECONDCHILD = 1;

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

    public boolean setUserCommand (boolean bool) {
        isChildUserCommand = bool;
        return isChildUserCommand;
    }

    public boolean isUserCommand () {
        return isChildUserCommand;
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
        if (isOperand()) {
            return getValue();
        }
        if (isVariable()) {
            return getValue();
        }
        if (isUserCommand()) {
            return executeCommand();
        }
        return executeCommand();
    }

}
