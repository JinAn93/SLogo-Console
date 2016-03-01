package MathCommands;

import java.util.ResourceBundle;
import Commands.*;


public class Difference extends MathOpCommand {
    private int myNumChildren;
    private Node[] myChildren;

    public Difference () {

    }

    @Override
    public String executeCommand () {
        int difference = Integer.parseInt(myChildren[0].getValue());
        difference -= Integer.parseInt(myChildren[1].getValue());
        return Integer.toString(difference);
    }

    @Override
    public void setChildren (Node[] kids, ResourceBundle parameters) {
        myNumChildren = Integer.parseInt(parameters.getString(this.getClass().getSimpleName()));
        myChildren = kids;
    }

    @Override
    public Node[] getChildren () {
        return myChildren;
    }

}
