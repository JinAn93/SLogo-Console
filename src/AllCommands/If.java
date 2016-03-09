package AllCommands;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import Commands.ControlStructuredCommand;
import Commands.Node;
import Commands.UserCommand;
import Commands.Variable;
import Main.*;


public class If extends ControlStructuredCommand {

    public If (List<SingleTurtle> turtle, List<StringBuilder> ListOfContents,
               ResourceBundle lang, List<Variable> variables, List<UserCommand> commands) {
        System.out.println("If was Created");
        myTurtle = turtle;
        myContent = ListOfContents.get(COMMAND_INDEX).toString();
        myLanguage = lang;
        myVariableList = variables;
        myUserCommandList = commands;
    }

    @Override
    public String executeCommand () {
        if (myContent == null)
            return ZERO;
        if (Integer.parseInt(myChildren[0].getValue()) == 0)
            return ZERO;
        else
            return executeStatement();
    }

    private String executeStatement () {
        Parser parser = new Parser(myTurtle, myLanguage, myVariableList, myUserCommandList);
        Stack<Node> result;
        try {
            result = parser.buildExpressionTree(Arrays.asList(myContent.split(" ")));
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
}
