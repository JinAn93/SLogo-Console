package MathCommands;

import Commands.MathOpCommand;
import Commands.Node;


public class Remainder extends MathOpCommand {
    public final int NUMBEROFCHILDREN = 2;
    private Node[] children = new Node[NUMBEROFCHILDREN];

    @Override
    public String executeCommand () {
        int remainder = Integer.parseInt(children[0].getValue());
        remainder = remainder % Integer.parseInt(children[1].getValue());
        return Integer.toString(remainder);
    }

    @Override
    public Node[] getChildren () {
        return children;
    }

}
