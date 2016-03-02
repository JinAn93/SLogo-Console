package Commands;

import Main.Turtle;


public abstract class TurtleCommand extends Command {

    protected static final int FIRSTCHILD = 0;
    protected static final int PENUP = 0;
    protected static final int PENDOWN = 1;
    protected Turtle myTurtle;
    protected Node[] myChildren;

    public TurtleCommand (Turtle turtle) {
        myTurtle = turtle;
    }

    public String getValue (Turtle turtle) {
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
