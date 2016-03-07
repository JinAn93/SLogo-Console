package AllCommands;

import java.util.List;
import Commands.TurtleCommand;
import Main.Turtle;


public class PenUp extends TurtleCommand {

    public PenUp (List<Turtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        for(Turtle aturtle:myTurtle){
            aturtle.setPen(PENUP);
        }
        return Integer.toString(PENUP);
    }
}
