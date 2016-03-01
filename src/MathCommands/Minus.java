package MathCommands;

import java.util.ResourceBundle;
import Commands.Command;
import Commands.MathOpCommand;
import Commands.Node;


public class Minus extends MathOpCommand {
    private Node[] myChildren;

    @Override
    public String executeCommand () {
        double minus = (-1) * Double.parseDouble(myChildren[0].getValue());
        return Double.toString(minus);
    }

    @Override
    public void setChildren (Node[] kids) {
        myChildren = kids;
    }

    @Override
    public Node[] getChildren () {
        return myChildren;
    }

}
