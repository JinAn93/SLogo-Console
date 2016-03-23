package NodeTypes;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import BackEndMain.Parser;
import BackEndMain.StrConstant;
import Turtle.SingleTurtle;


/**
 * UserCommand serves to store its user-defined command name, command details, and parameters. It
 * also has executeCommand method that creates expression tree and return appropriate value.
 *
 * @author Jin An
 *
 */
public class UserCommand extends Command {

    private String myCommandName;
    private String myCommand;
    private List<String> myParameters;
    private List<SingleTurtle> myTurtle;
    private ResourceBundle myLanguage;

    public UserCommand (List<SingleTurtle> turtles,
                        String name,
                        String command,
                        ResourceBundle lang,
                        List<String> parameters) {
        myCommandName = name;
        myTurtle = turtles;
        myCommand = command;
        myParameters = parameters;
        myLanguage = lang;
    }

    public UserCommand () {
    }

    @Override
    public String executeCommand () {
        Parser parser = new Parser(myTurtle, myLanguage);
        Stack<Node> root;
        try {
            root = parser.buildExpressionTree(Arrays.asList(myCommand.split(StrConstant.SPACE)));
            if (root == null) {
                throw new Exception();
            }
            List<String> ret = parser.evaluateRoot(root);
            return ret.get(ret.size() - 1); // return the result from last command
        }
        catch (Exception e) {
            return null;
        }
    }

    public String getUserCommandName () {
        return myCommandName;
    }

    public String getCommand () {
        return myCommand;
    }

    public List<String> getParameters () {
        return myParameters;
    }

    public void setUserCommandName (String name) {
        myCommandName = name;
    }

    public void setCommand (String command, List<String> parameter) {
        myCommand = command;
        myParameters = parameter;
    }
}
