package allcommands;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import BackEndMain.Parser;
import BackEndMain.StrConstant;
import CommandTypes.ControlStructuredCommand;
import NodeTypes.Node;
import Turtle.SingleTurtle;


/**
 * subclass of control structured command: serves to repeat the instruction as much as the
 * parameter's value. We replicate the commands and execute it by building another expression tree.
 *
 * @author Jin An
 * @author Sarp Uner
 *
 */
public class Repeat extends ControlStructuredCommand {

    public Repeat (List<SingleTurtle> turtle, List<StringBuilder> ListOfContents,
                   ResourceBundle lang) {
        myTurtle = turtle;
        myContent = ListOfContents.get(0).toString();
        myLanguage = lang;
    }

    @Override
    public String executeCommand () {
        if (myContent == null) {
            return StrConstant.ZERO;
        }
        int repNumber = Integer.parseInt(myChildren[FIRSTCHILD].getValue());
        StringBuilder newCommand = new StringBuilder();
        for (int i = 0; i < repNumber; i++) {
            newCommand.append(myContent);
        }
        newCommand.deleteCharAt(newCommand.length() - 1);
        Parser parser = new Parser(myTurtle, myLanguage);
        Stack<Node> root;
        try {
            root = parser.buildExpressionTree(Arrays.asList(newCommand.toString()
                                                              .split(StrConstant.SPACE)));
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
