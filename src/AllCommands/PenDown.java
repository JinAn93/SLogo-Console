package AllCommands;

import java.util.List;
import Commands.TurtleCommand;
import Main.Turtle;


public class PenDown extends TurtleCommand {
    
    public PenDown (List<Turtle> turtle) {
        super(turtle);
    }

    @Override
    public String executeCommand () {
        for(Turtle aturtle: myTurtle){
            aturtle.setPen(PENDOWN);
        }
        return Integer.toString(PENDOWN);
    }
}
