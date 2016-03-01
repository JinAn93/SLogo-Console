package MathCommands;

import Commands.MathOpCommand;
import Commands.Node;


public class Remainder extends MathOpCommand {
    private static final int FIRSTCHILD = 0;
    private static final int SECONDCHILD = 1;
    private Node[] myChildren;

    @Override
    public String executeCommand () {
        double remainder = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        remainder = remainder % Integer.parseInt(myChildren[SECONDCHILD].getValue());
        return Double.toString(remainder);
    }

    @Override
    public Node[] getChildren () {
        return myChildren;
    }

}
