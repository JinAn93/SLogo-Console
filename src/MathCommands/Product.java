package MathCommands;

import java.util.ResourceBundle;
import Commands.Command;
import Commands.MathOpCommand;
import Commands.Node;


public class Product extends MathOpCommand {
    private int myNumChildren;
    private Node[] myChildren;

    @Override
    public String executeCommand () {
        int product = 1; // initialization
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
