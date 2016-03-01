package MathCommands;

import java.util.ResourceBundle;
import Commands.MathOpCommand;
import Commands.Node;


public class Product extends MathOpCommand {
    private int myNumChildren;
    private Node[] myChildren;
    private final static int INITIALIZATION = 1;
    @Override
    public String executeCommand () {
        int product = INITIALIZATION;
        for (int i = 0; i < myNumChildren; i++) {
            System.out.println(myChildren[i].getValue());
            product *= Integer.parseInt(myChildren[i].getValue());
        }
        return Integer.toString(product);
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
