package Commands;

public abstract class MathOpCommand extends Command {

    protected static final int FIRSTCHILD = 0;
    protected static final int SECONDCHILD = 1;
    protected Node[] myChildren;

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
