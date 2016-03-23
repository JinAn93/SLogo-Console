package AllCommands;

import CommandTypes.MathOpCommand;


/**
 * subclass of mathopcommand: serves to return remainder from dividing first child by second child
 *
 * @author Jin An
 * @author Sarp Uner
 *
 */
public class Remainder extends MathOpCommand {

    @Override
    public String executeCommand () {
        double remainder = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        remainder = remainder % Double.parseDouble(myChildren[SECONDCHILD].getValue());
        return Double.toString(remainder);
    }
}
