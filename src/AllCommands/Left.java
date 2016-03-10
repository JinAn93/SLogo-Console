package AllCommands;

import java.util.List;
import Turtle.SingleTurtle;
import Turtle.Turtle;
import CommandTypes.TurtleCommand;

public class Left extends TurtleCommand {

    public Left (List<SingleTurtle> turtle) {
        super(turtle);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String executeCommand () {
        for (Turtle aturtle : myTurtle) {
            aturtle.setHeading(aturtle.getHeading() -
                               Double.parseDouble(myChildren[FIRSTCHILD].getValue()));
        }
        return myChildren[FIRSTCHILD].getValue();
    }
}
