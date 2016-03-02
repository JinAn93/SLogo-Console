package Commands;

import Main.Turtle;


public abstract class TurtleQueriesCommand extends Command {

    protected Turtle myTurtle;
    protected Node[] myChildren;

    public TurtleQueriesCommand (Turtle turtle) {
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

    @Override
    public String executeCommand () {
        // TODO Auto-generated method stub
        return null;
    }
}
