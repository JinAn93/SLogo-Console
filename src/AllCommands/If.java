package AllCommands;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import BackEndMain.*;
import CommandTypes.*;
import NodeTypes.*;
import Turtle.*;


/**
 * subclass of controlstructuredcommand : execute command by creating another expression tree only
 * if the parameter is not zero
 * 
 * @author Jin An
 *
 */
public class If extends ControlStructuredCommand {

    public If (List<SingleTurtle> turtle, List<StringBuilder> ListOfContents, ResourceBundle lang) {
        System.out.println("If was Created");
        myTurtle = turtle;
        myContent = ListOfContents.get(COMMAND_INDEX).toString();
        myLanguage = lang;
    }

    @Override
    public String executeCommand () {
        if (myContent == null)
            return StrConstant.ZERO;
        if (Integer.parseInt(myChildren[0].getValue()) == FALSE)
            return StrConstant.ZERO;
        else
            return executeStatement();
    }

    private String executeStatement () {
        Parser parser = new Parser(myTurtle, myLanguage);
        Stack<Node> result;
        try {
            result = parser.buildExpressionTree(Arrays.asList(myContent.split(StrConstant.SPACE)));
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
