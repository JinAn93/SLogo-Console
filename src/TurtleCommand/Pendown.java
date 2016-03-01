package TurtleCommand;

import java.util.ResourceBundle;
import Commands.Node;
import Commands.TurtleCommand;
import Main.Turtle;


public class Pendown extends TurtleCommand {
    private Node[] myChildren;
    private Turtle myTurtle;
    private static final int PENDOWN = 1;

    public Pendown (Turtle turtle) {
        super(turtle);
        myTurtle = turtle;
    }

    @Override
    public String executeCommand () {
        myTurtle.setPen(PENDOWN);
        return Integer.toString(PENDOWN);
    }

    @Override
    public void setChildren (Node[] kids, ResourceBundle parameters) {
        myChildren = kids;
    }

    @Override
    public Node[] getChildren () {
        return myChildren;
    }
}
