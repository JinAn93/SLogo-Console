package Commands;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import Main.Parser;
import Main.Turtle;


public class UserCommand extends Command {

    private String myCommandName;
    private String mySavedCommand;
    private List<String> myParameters;
    private List<Turtle> myTurtle;
    private ResourceBundle myLanguage;
    private List<Variable> myVariableList;

    public UserCommand (String name, String command, List<String> parameters) {
        myCommandName = name;
        mySavedCommand = command;
        myParameters = parameters;
    }

    @Override
    public String executeCommand () {
        Parser parser = new Parser(myTurtle, myLanguage, myVariableList);
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
    
    public String getUserCommandName(){
        return myCommandName;
    }
    
    public void setCommand (String command, List<String> parameter){
        mySavedCommand = command;
        myParameters = parameter;
    }
}
