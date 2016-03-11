package AllCommands;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import CommandTypes.ControlStructuredCommand;
import NodeTypes.*;
import Turtle.*;
import BackEndMain.*;


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
        System.out.println("Repeat was created");
        myTurtle = turtle;
        myContent = ListOfContents.get(0).toString();
        myLanguage = lang;
    }

    @Override
    public String executeCommand () {
        if (myContent == null)
            return StrConstant.ZERO;
        int repNumber = Integer.parseInt(myChildren[FIRSTCHILD].getValue());
        StringBuilder newCommand = new StringBuilder();
        for (int i = 0; i < repNumber; i++) {
            newCommand.append(myContent);
        }
        newCommand.deleteCharAt(newCommand.length() - 1);
        Parser parser = new Parser(myTurtle, myLanguage);
        Stack<Node> result;
        try {
            result = parser.buildExpressionTree(Arrays.asList(newCommand.toString()
                    .split(StrConstant.SPACE)));
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
