package AllCommands;

import CommandTypes.MathOpCommand;


/**
 * Subclass of MathOpCommand: serves to return the quotient from firstchild dividing by secondchild.
 * 
 * @author Jin An
 * @author Sarp Uner
 *
 */
public class Quotient extends MathOpCommand {

    @Override
    public String executeCommand () {
        double quotient = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        quotient /= Double.parseDouble(myChildren[SECONDCHILD].getValue());
        return Double.toString(quotient);
    }
}
