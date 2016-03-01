package TurtleCommand;

import java.util.ResourceBundle;
import Commands.Node;
import Commands.TurtleCommand;
import Main.Turtle;


public class Penup extends TurtleCommand {

    private Node[] myChildren;
    private Turtle myTurtle;
    private static final int PENUP = 0;
    
    public Penup (Turtle turtle) {
        super(turtle);
        myTurtle = turtle;
    }

    @Override
    public String executeCommand () {
        myTurtle.setPen(PENUP);
        return Integer.toString(PENUP);
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
