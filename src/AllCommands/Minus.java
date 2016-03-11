package AllCommands;

import CommandTypes.MathOpCommand;


/**
 * subclass of MathOpCommand: serves to return (-1)*input
 * 
 * @author Jin An
 * @author Sarp Uner
 *
 */
public class Minus extends MathOpCommand {

    @Override
    public String executeCommand () {
        double minus = MINUS * Double.parseDouble(myChildren[0].getValue());
        return Double.toString(minus);
    }
}
