package Main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import Commands.*;


/**
 * MainBackEnd serves to create Expression Tree and execute commands as it reads the nodes
 * 
 * @author Jin An
 * @author Sarp Uner
 *
 */

public class MainBackEnd {

    private static List<Variable> myVariableList = new ArrayList<Variable>();
    private static ResourceBundle myLanguage;
    private List<Turtle> myAllTurtles;
    private List<Turtle> myCurrentTurtles;

    public Output executeCommand (Collection<?> commands) {
        Parser parser = new Parser(myAllTurtles, myLanguage, myVariableList);
        Stack<Node> result;
        try {
            result = parser.buildExpressionTree(commands);
            if (result == null) {
                throw new Exception();
            }
            Output output = new Output(myAllTurtles, myVariableList);
            output.setResult(parser.stringizer(result));
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
}
