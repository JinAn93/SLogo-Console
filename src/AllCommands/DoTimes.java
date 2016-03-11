package AllCommands;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import CommandTypes.ControlStructuredCommand;
import Error_Checking.ErrorObject;
import Error_Checking.VariableException;
import BackEndMain.*;
import NodeTypes.*;
import Turtle.*;


/**
 * Subclass of ControlStructuredCommand: it creates index variable and executes loop.
 * 
 * @author Jin An
 *
 */
public class DoTimes extends ControlStructuredCommand {

    private static final int INDEX_VARIABLE = 0;
    private static final int LIMIT_INDEX = 1;

    public DoTimes (List<SingleTurtle> turtle,
                    List<StringBuilder> ListOfContents,
                    ResourceBundle lang) {
        myTurtle = turtle;
        myContent = ListOfContents.get(COMMAND_INDEX).toString();
        myControlContent = ListOfContents.get(CONTROL_INDEX).toString();
        myLanguage = lang;
    }

    @Override
    public String executeCommand () {
        if (myContent == null)
            return StrConstant.ZERO;
        return executeLoop(createIndexVariable());
    }

    private int createIndexVariable () {
        Variable indexVar = new Variable();
        String[] controlData = myControlContent.split(StrConstant.SPACE);
        char firstChar = controlData[INDEX_VARIABLE].charAt(INDEX_FIRSTCHAR);
        try {
            if (firstChar != COLON) {
                throw new VariableException();
            }
            indexVar.setName(controlData[INDEX_VARIABLE].substring(INDEX_COLON));
            indexVar.setValue(StrConstant.ONE_INDEX_DEFAULT);
            indexVar.setValue(controlData[LIMIT_INDEX]);
            myVariableList.add(indexVar);
            System.out.println(controlData);
            return Integer.parseInt(indexVar.getValue());
        }
        catch (VariableException e) {
            new ErrorObject(StrConstant.VARIABLE_ERROR).displayError();
            return ERROR;
        }
    }

    private String executeLoop (int limit) {
        if(limit == ERROR)
            return null;
        StringBuilder newCommand = new StringBuilder();
        for (int i = 0; i < limit; i++) {
            newCommand.append(myContent);
        }
        newCommand.deleteCharAt(newCommand.length() - 1);
        Parser parser = new Parser(myTurtle, myLanguage);
        Stack<Node> result;
        try {
            result = parser.buildExpressionTree(Arrays.asList(newCommand.toString().split(" ")));
            if (result == null) {
                throw new Exception(); //if parameter/instruction/variable error occurs, throws new general exception.
            }
            List<String> ret = parser.stringizer(result);
            return ret.get(ret.size() - 1);
        }
        catch (Exception e) {
            return null;
        }
    }
}
