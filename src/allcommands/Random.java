package allcommands;

import CommandTypes.MathOpCommand;


/**
 * subclass of mathopcommand: serves to return random number less than the max (first child) value.
 *
 * @author Jin An
 *
 */
public class Random extends MathOpCommand {

    @Override
    public String executeCommand () {
        double max = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        return Double.toString(Math.random() * max);
    }
}
