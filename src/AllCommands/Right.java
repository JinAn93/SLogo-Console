package AllCommands;

import java.util.List;
import CommandTypes.TurtleCommand;
import Turtle.*;


public class Right extends TurtleCommand {

    public Right (List<SingleTurtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        double changeinHeading = Double.parseDouble(myChildren[FIRSTCHILD].getValue());
        aturtle.setHeading(aturtle.getHeading() + changeinHeading);
        return myChildren[FIRSTCHILD].getValue();
    }
}
