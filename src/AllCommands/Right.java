package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.*;


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
