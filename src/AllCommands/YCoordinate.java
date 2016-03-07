package AllCommands;

import java.util.List;
import Commands.TurtleCommand;
import Main.Turtle;


public class YCoordinate extends TurtleCommand {

    public YCoordinate (List<Turtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        String ret = null;
        for(Turtle aturtle:myTurtle){
        ret = String.valueOf((aturtle.getStartYCor()));
        }
        return ret;
    }
}
