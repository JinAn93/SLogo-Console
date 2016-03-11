package BackEndMain;

import java.util.*;
import NodeTypes.*;
import Turtle.*;


/**
 * MainBackEnd serves to create Expression Tree and execute commands as it reads the nodes
 * 
 * @author Jin An
 * @author Sarp Uner
 *
 */

public class MainBackEnd {

    private static List<Variable> myVariableList = new ArrayList<Variable>();
    private static List<UserCommand> myUserCommandList = new ArrayList<UserCommand>();
    private static ResourceBundle myLanguage;
    private List<SingleTurtle> myAllTurtles;
    private List<SingleTurtle> myCurrentTurtles;

    public Output executeCommand (Collection<?> commands) {
        Parser parser = new Parser(myAllTurtles, myLanguage, myVariableList, myUserCommandList);
        Stack<Node> result;
        try {
            result = parser.buildExpressionTree(commands);
            if (result == null) {
                throw new Exception();
            }
            Output output = new Output(myAllTurtles, myVariableList, myUserCommandList);
            output.setResult(parser.stringizer(result));
            System.out.println("Here is the Variable List: " + myVariableList);
            System.out.println("Here is the User Command List: " + myUserCommandList);
            return output;
        }
        catch (Exception e) {
            return null;
        }
    }

    public Collection<?> setup (String input, InputObject inputObject) {
        InputNormalizer iNormalizer = new InputNormalizer();
        myAllTurtles = inputObject.getTurtle();
        myLanguage = inputObject.getLanguage();
        return iNormalizer.normalizeInput(input);
    }

    public void setLanguage (ResourceBundle bundle) {
        myLanguage = bundle;
    }

    public static List<Variable> getVariables () {
        return myVariableList;
    }
    
    public static List<UserCommand> getUserCommands () {
        return myUserCommandList;
    }
}