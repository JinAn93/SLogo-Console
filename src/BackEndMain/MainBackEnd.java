package BackEndMain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import NodeTypes.Node;
import NodeTypes.UserCommand;
import NodeTypes.Variable;
import Turtle.SingleTurtle;


/**
 * MainBackEnd serves to create Expression Tree and execute commands as it reads the nodes. It takes
 * in Input Object
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

    public Output executeCommand (Collection<?> commands) {
        Parser parser = new Parser(myAllTurtles, myLanguage);
        Stack<Node> root;
        try {
            root = parser.buildExpressionTree(commands);
            if (root == null) {
                throw new Exception();
            }
            Output output = new Output(myAllTurtles, myVariableList, myUserCommandList);
            output.setResult(parser.evaluateRoot(root));
            return output;
        }
        catch (Exception e) {
            return null;
        }
    }

    public Collection<?> setup (InputObject inputObject) {
        InputNormalizer iNormalizer = new InputNormalizer();
        myAllTurtles = inputObject.getTurtle();
        myLanguage = inputObject.getLanguage();
        return iNormalizer.normalizeInput(inputObject.getCommand());
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
