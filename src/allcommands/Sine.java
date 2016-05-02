package allcommands;

import CommandTypes.MathOpCommand;


/**
 * Subclass of mathopcommand: serves to return sine value of an angle (first child)
 *
 * @author Jin An
 *
 */
public class Sine extends MathOpCommand {

    @Override
    public String executeCommand () {
        double radian = Math.toRadians(Double.parseDouble(myChildren[FIRSTCHILD].getValue()));
        return Double.toString(Math.sin(radian));
    }
}
