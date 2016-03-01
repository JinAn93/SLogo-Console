package MathCommands;

import java.util.ResourceBundle;
import Commands.Command;
import Commands.MathOpCommand;
import Commands.Node;


public class Minus extends MathOpCommand {
    private Node[] myChildren;

    @Override
    public String executeCommand () {
        int minus = (-1) * Integer.parseInt(myChildren[0].getValue());
        return Integer.toString(minus);
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
