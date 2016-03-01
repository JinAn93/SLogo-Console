package MathCommands;

import java.util.ResourceBundle;
import Commands.MathOpCommand;
import Commands.Node;


public class Product extends MathOpCommand {
    private Node[] myChildren;

    @Override
    public String executeCommand () {
        double firstChild = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        double secondChild = Double.parseDouble(myChildren[SECONDCHILD].getValue());
        double product = firstChild * secondChild;
        return Double.toString(product);
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
