package NodeTypes;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import BackEndMain.*;
import Turtle.*;


public class UserCommand extends Command {

    private String myCommandName;
    private String mySavedCommand;
    private List<String> myParameters;
    private List<SingleTurtle> myTurtle;
    private ResourceBundle myLanguage;
    private List<Variable> myVariableList;
    private List<UserCommand> myUserCommandList;

    public UserCommand (List<SingleTurtle> turtles,
                        String name,
                        String command,
                        ResourceBundle lang,
                        List<String> parameters,
                        List<UserCommand> commands) {
        myCommandName = name;
        myTurtle = turtles;
        mySavedCommand = command;
        myParameters = parameters;
        myUserCommandList = commands;
        myLanguage = lang;
    }

    public UserCommand () {
    }

    @Override
    public String executeCommand () {
        Parser parser = new Parser(myTurtle, myLanguage, myVariableList, myUserCommandList);
        Stack<Node> result;
        try {
            result = parser.buildExpressionTree(Arrays.asList(mySavedCommand.split(" ")));
            if (result == null) {
                throw new Exception();
            }
            List<String> ret = parser.stringizer(result);
            return ret.get(ret.size() - 1);
        }
        catch (Exception e) {
            return null;
        }
    }

    public String getUserCommandName () {
        return myCommandName;
    }

    public String getCommand () {
        return mySavedCommand;
    }

    public List<String> getParameters () {
        return myParameters;
    }

    public void setUserCommandName (String name) {
        myCommandName = name;
    }

    public void setCommand (String command, List<String> parameter) {
        mySavedCommand = command;
        myParameters = parameter;
    }
}
