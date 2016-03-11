package AllCommands;

import CommandTypes.MathOpCommand;

/**
 * Subclass of MathOpCommand: returns the sum of two children.
 * @author Jin AN
 * @author Sarp Uner
 *
 */
public class Sum extends MathOpCommand {

    @Override
    public String executeCommand () {
        double firstValue = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        double secondValue = Double.parseDouble(myChildren[SECONDCHILD].getValue());
        return Double.toString(firstValue + secondValue);
    }
}
