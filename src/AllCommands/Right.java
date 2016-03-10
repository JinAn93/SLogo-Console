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
        for (Turtle aturtle : myTurtle) {
            aturtle.setHeading(aturtle.getHeading() +
                               Double.parseDouble(myChildren[FIRSTCHILD].getValue()));
        }
        return myChildren[FIRSTCHILD].getValue();
    }
}
