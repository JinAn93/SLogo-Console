package MathCommands;

import java.util.ResourceBundle;
import Commands.*;


public class Sum extends MathOpCommand {

    private int myNumChildren;
    private Node[] myChildren;

    @Override
    public String executeCommand () {
        int sum = 0;
        for (int i = 0; i < myNumChildren; i++) {
            System.out.println(myChildren[i].getClass().getName());
            sum += Integer.parseInt(myChildren[i].getValue());
        }
        return Integer.toString(sum);

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
