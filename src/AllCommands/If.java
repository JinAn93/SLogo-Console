package AllCommands;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import Commands.ControlStructuredCommand;
import Commands.Node;
import Commands.Variable;
import Main.*;


public class If extends ControlStructuredCommand {

    public If (Turtle turtle,
               List<StringBuilder> ListOfContents,
               ResourceBundle lang,
               List<Variable> variables) {
        System.out.println("If was Created");
        myTurtle = turtle;
        myContent = ListOfContents.get(COMMAND_INDEX).toString();
        myLanguage = lang;
        myVariableList = variables;
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
        Parser parser = new Parser(myTurtle, myLanguage, myVariableList);
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
