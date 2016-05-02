package allcommands;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import BackEndMain.Parser;
import BackEndMain.StrConstant;
import CommandTypes.ControlStructuredCommand;
import NodeTypes.Node;
import Turtle.SingleTurtle;


/**
 * subclass of control structured command: if parameter is nonzero, execute the first bracket, if
 * not execute the next bracket.
 *
 * @author Jin An
 *
 */
public class IfElse extends ControlStructuredCommand {

    private String myTrueCommand, myFalseCommand;
    private static final int TRUECOMMAND = 0;
    private static final int FALSECOMMAND = 1;

    public IfElse (List<SingleTurtle> turtle,
                   List<StringBuilder> ListOfContents,
                   ResourceBundle lang) {
        myTurtle = turtle;
        myTrueCommand = ListOfContents.get(TRUECOMMAND).toString();
        myFalseCommand = ListOfContents.get(FALSECOMMAND).toString();
        myLanguage = lang;
    }

    @Override
    public String executeCommand () {
        Parser parser = new Parser(myTurtle, myLanguage);
        boolean ifOrElse = (Integer.parseInt(myChildren[0].getValue()) == FALSE);
        if ((ifOrElse && myTrueCommand == null) || !(ifOrElse) && myFalseCommand == null) {
            return StrConstant.ZERO;
        }

        Stack<Node> root;
        try {
            Collection<?> contents = Arrays.asList((ifOrElse ? myTrueCommand : myFalseCommand)
                                                   .split(StrConstant.SPACE));
            root = parser.buildExpressionTree(contents);
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
