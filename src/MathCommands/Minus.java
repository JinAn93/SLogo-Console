package MathCommands;

import Commands.Command;
import Commands.MathOpCommand;
import Commands.Node;


public class Minus extends MathOpCommand {
    public final int NUMBEROFCHILDREN = 1;
    private Node[] children = new Node[NUMBEROFCHILDREN];

    public Minus () {

    }

    @Override
    public String executeCommand () {
        int minus = Integer.parseInt(children[0].getValue());
        return Integer.toString(minus);
    }

    @Override
    public void setChildren (Node[] kids) {
        for (int i = 0; i < kids.length; i++) {
            children[i] = kids[i];

        }
    }

    @Override
    public Node[] getChildren () {
        return children;
    }

}
