package MathCommands;

import java.util.ResourceBundle;
import Commands.*;


public class Difference extends MathOpCommand {
    private Node[] myChildren;

    @Override
    public String executeCommand () {
        double difference = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        difference -= Double.parseDouble(myChildren[SECONDCHILD].getValue());
        return Double.toString(difference);
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
