package AllCommands;

import CommandTypes.MathOpCommand;


public class Product extends MathOpCommand {

    @Override
    public String executeCommand () {
        double firstChild = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        double secondChild = Double.parseDouble(myChildren[SECONDCHILD].getValue());
        double product = firstChild * secondChild;
        return Double.toString(product);
    }
}
