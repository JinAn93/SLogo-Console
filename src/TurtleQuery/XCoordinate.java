package TurtleQuery;

import Commands.TurtleQueriesCommand;
import Main.Turtle;

public class XCoordinate extends TurtleQueriesCommand{
    private Turtle myTurtle;
    
    public XCoordinate(Turtle turtle){
        myTurtle = turtle;
    }
    
    @Override
    public String executeCommand (){
        return String.valueOf((myTurtle.getXCor()));
    }
}
