package MathCommands;

import java.util.ResourceBundle;
import Commands.*;


public class Difference extends MathOpCommand {
    private Node[] myChildren;
    private static final int FIRSTCHILD = 0;
    private static final int SECONDCHILD = 1;
    public Difference () {

    }

    @Override
    public String executeCommand () {
        int difference = Integer.parseInt(myChildren[FIRSTCHILD].getValue());
        difference -= Integer.parseInt(myChildren[SECONDCHILD].getValue());
        return Integer.toString(difference);
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
