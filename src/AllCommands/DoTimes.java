package AllCommands;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import Commands.ControlStructuredCommand;
import Commands.Node;
import Commands.Variable;
import Main.*;


public class DoTimes extends ControlStructuredCommand {

    private static final int INDEX_VARIABLE = 0;
    private static final int LIMIT_INDEX = 1;

    public DoTimes (Turtle turtle,
                    List<StringBuilder> ListOfContents,
                    ResourceBundle lang,
                    List<Variable> variables) {
        System.out.println("DoTimes was Created");
        myTurtle = turtle;
        myContent = ListOfContents.get(COMMAND_INDEX).toString();
        myControlContent = ListOfContents.get(CONTROL_INDEX).toString();
        myLanguage = lang;
        myVariableList = variables;
    }

    @Override
    public String executeCommand () {
        if (myContent == null)
            return ZERO;
        return executeLoop(createIndexVariable());
    }

    private int createIndexVariable () {
        Variable indexVar = new Variable();
        String[] controlData = myControlContent.split(SPACE);
        indexVar.setName(controlData[INDEX_VARIABLE]);
        indexVar.setValue(ONE_INDEXDEFAULT);
        indexVar.setValue(controlData[LIMIT_INDEX]);
        myVariableList.add(indexVar);
        System.out.println(controlData);
        return Integer.parseInt(indexVar.getValue());
    }

    private String executeLoop (int limit) {
        StringBuilder newCommand = new StringBuilder();
        for (int i = 0; i < limit; i++) {
            newCommand.append(myContent);
        }
        newCommand.deleteCharAt(newCommand.length() - 1);
        Parser parser = new Parser(myTurtle, myLanguage, myVariableList);
        Stack<Node> result;
        try {
            result = parser.buildExpressionTree(Arrays.asList(newCommand.toString().split(" ")));
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
