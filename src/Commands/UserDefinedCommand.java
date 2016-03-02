package Commands;

public abstract class UserDefinedCommand extends Command {

    protected Node[] myChildren;
    protected static final int NAME = 0;
    protected static final int VALUE = 1;
    protected static final int numRepeatIndex = 0;
    
    public String getValue () {
        return executeCommand();
    }

    @Override
    public void setChildren (Node[] kids) {
        myChildren = kids;
    }

    @Override
    public Node[] getChildren () {
        return myChildren;
    }
}
