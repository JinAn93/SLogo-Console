package allcommands;

import CommandTypes.MathOpCommand;


/**
 * Subclass of MathOpCommand: executes subtraction
 *
 * @author Jin An
 * @author Sarp Uner
 *
 */
public class Difference extends MathOpCommand {

    @Override
    public String executeCommand () {
        double difference = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        difference -= Double.parseDouble(myChildren[SECONDCHILD].getValue());
        return Double.toString(difference);
    }
}
