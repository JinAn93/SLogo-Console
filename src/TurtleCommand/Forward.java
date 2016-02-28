package TurtleCommand;

import Commands.Node;
import Commands.TurtleCommand;
import Main.Turtle;


public class Forward extends TurtleCommand {
    public final int NUMBEROFCHILDREN = 1;
    private Node[] children = new Node[NUMBEROFCHILDREN];

    @Override
    public String executeCommand (Turtle turtle) {
        return String.valueOf((turtle.getXCor()));
    }

    public String getValue (Turtle turtle) {
        return executeCommand(turtle);
    }

    @Override
    public void setChildren (Node[] kids) {
        for (int i = 0; i < kids.length; i++) {
            children[i] = kids[i];
        }
    }
}
