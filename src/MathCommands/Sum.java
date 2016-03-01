package MathCommands;

import java.util.ResourceBundle;
import Commands.*;


public class Sum extends MathOpCommand {

    private Node[] myChildren;

    @Override
    public String executeCommand () {
        double firstValue = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        double secondValue = Double.parseDouble(myChildren[SECONDCHILD].getValue());
        return Double.toString(firstValue + secondValue);
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
