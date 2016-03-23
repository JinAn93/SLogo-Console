package BackEndMain;

import java.util.ArrayList;
import java.util.List;
import NodeTypes.UserCommand;
import NodeTypes.Variable;
import Turtle.SingleTurtle;


/**
 * Output class serves to contain all the information needed for front end to display the result. It
 * contains list of printable string (console), list of turtles, list of variables, and list of
 * user-defined commands.
 *
 * @author Jin An
 * @author David Yan
 * @author Cody Li
 * @author Sarp Uner
 */
public class Output {

    private List<String> myResult = new ArrayList<String>();
    private List<SingleTurtle> myTurtle;
    private List<Variable> myVariables = new ArrayList<Variable>();
    private List<UserCommand> myUserCommands = new ArrayList<UserCommand>();

    public Output (List<SingleTurtle> turtle, List<Variable> variables, List<UserCommand> commands) {
        myTurtle = turtle;
        myVariables = variables;
        myUserCommands = commands;
    }

    public Output (List<SingleTurtle> turtle, List<Variable> variables) {
        myTurtle = turtle;
        myVariables = variables;
    }

    public List<String> getResult () {
        return myResult;
    }

    public void setResult (List<String> result) {
        myResult = result;
    }

    public List<SingleTurtle> getTurtle () {
        return myTurtle;
    }

    public void updateTurtle (List<SingleTurtle> turtle) {
        myTurtle = turtle;
    }

    public List<Variable> getVariables () {
        return myVariables;
    }

    public List<UserCommand> getUserCommands () {
        return myUserCommands;
    }

    public void updateVariable (List<Variable> variables) {
        myVariables = variables;
    }
}
