package AllCommands;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import Commands.ControlStructuredCommand;
import Commands.Node;
import Commands.Variable;
import Error_Checking.ErrorObject;
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
        InputNormalizer iNormalizer = new InputNormalizer();
        Parser parser = new Parser(myTurtle, myLanguage, myVariableList);
        Stack<Node> result;
        try {
            result = parser.buildExpressionTree(iNormalizer.parseCommand((myContent.toString())));
            List<String> ret = parser.stringizer(result);
            return ret.get(ret.size() - 1);
        }
        catch (ClassNotFoundException e) {
            new ErrorObject(INSTRUCTION_ERROR).displayError();
            return null;
        }
    }
}
