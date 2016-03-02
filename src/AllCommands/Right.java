package AllCommands;

import Commands.TurtleCommand;
import Main.Turtle;


public class Right extends TurtleCommand {

    public Right (Turtle turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        myTurtle.setHeading(myTurtle.getHeading() +
                            Double.parseDouble(myChildren[FIRSTCHILD].getValue()));
        return myChildren[FIRSTCHILD].getValue();
    }
}
