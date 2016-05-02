package allcommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.SingleTurtle;


/**
 * subclass of turtlecommand: serves to rotate each turtle to the right by input (heading).
 *
 * @author Jin An
 * @author Sarp Uner
 *
 */
public class Right extends TurtleCommand {

    public Right (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeOnSingleTurtle (SingleTurtle t) {
        double changeinHeading = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        t.setHeading(t.getHeading() + changeinHeading);
        return myChildren[FIRSTCHILD].getValue();
    }
}
