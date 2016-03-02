package MathCommands;

import Commands.MathOpCommand;
import Commands.Node;


public class Minus extends MathOpCommand {
    private Node[] myChildren;

    @Override
    public String executeCommand () {
        double minus = (-1) * Double.parseDouble(myChildren[0].getValue());
        return Double.toString(minus);
    }
}
