package allcommands;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import BackEndMain.Parser;
import BackEndMain.StrConstant;
import CommandTypes.ControlStructuredCommand;
import Error_Checking.ErrorObject;
import Error_Checking.VariableException;
import NodeTypes.Node;
import NodeTypes.Variable;
import Turtle.SingleTurtle;


/**
 * subclass of controlstructuredcommand: creates index variable, counts how many times it repeats,
 * and execute the loop.
 *
 * @author Jin An
 *
 */
public class For extends ControlStructuredCommand {

    private static final int INDEX_VARIABLE = 0;
    private static final int INDEX_START = 1;
    private static final int INDEX_END = 2;
    private static final int INDEX_INCREMENT = 3;

    public For (List<SingleTurtle> turtle, List<StringBuilder> ListOfContents, ResourceBundle lang) {
        myTurtle = turtle;
        myContent = ListOfContents.get(COMMAND_INDEX).toString();
        myControlContent = ListOfContents.get(CONTROL_INDEX).toString();
        myLanguage = lang;
    }

    @Override
    public String executeCommand () {
        if (myContent == null) {
            return StrConstant.ZERO;
        }
        return executeLoop(createIndexVariable());
    }

    private int createIndexVariable () {
        Variable indexVar = new Variable();
        String[] controlData = myControlContent.split(StrConstant.SPACE);
        int startPoint = Integer.parseInt(controlData[INDEX_START]);
        int endPoint = Integer.parseInt(controlData[INDEX_END]);
        int increment = Integer.parseInt(controlData[INDEX_INCREMENT]);
        int numRepeat = countRepeat(startPoint, endPoint, increment);
        char firstChar = controlData[INDEX_VARIABLE].charAt(INDEX_FIRSTCHAR);
        try {
            if (firstChar != COLON) {
                throw new VariableException();
            }
            indexVar.setName(controlData[INDEX_VARIABLE].substring(INDEX_COLON));
            indexVar.setValue(controlData[INDEX_START]);
            indexVar.setValue(Integer.toString(startPoint + increment * (numRepeat - 1)));
            myVariableList.add(indexVar);
            System.out.println(controlData);
            return numRepeat;
        }
        catch (VariableException e) {
            new ErrorObject(StrConstant.VARIABLE_ERROR).displayError();
            return 0;
        }
    }

    private int countRepeat (int startPoint, int endPoint, int increment) {
        if ((endPoint - startPoint + 1) % increment == 0) {
            return ((endPoint - startPoint + 1) / increment);
        }
        else {
            return ((endPoint - startPoint + 1) / increment) + 1;
        }
    }

    private String executeLoop (int limit) {
        StringBuilder newCom = new StringBuilder();
        for (int i = 0; i < limit; i++) {
            newCom.append(myContent);
        }
        newCom.deleteCharAt(newCom.length() - 1);
        Parser parser = new Parser(myTurtle, myLanguage);
        Stack<Node> root;
        try {
            root = parser.buildExpressionTree(Arrays.asList((newCom.toString()
                    .split(StrConstant.SPACE))));
            if (root == null) {
                throw new Exception();
            }
            List<String> ret = parser.evaluateRoot(root);
            return ret.get(ret.size() - 1);
        }
        catch (Exception e) {
            return null;
        }
    }
}
