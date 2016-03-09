package AllCommands;

import java.util.*;
import CommandTypes.*;
import BackEndMain.*;
import NodeTypes.*;
import Turtle.*;


public class IfElse extends ControlStructuredCommand {

    private String myTrueCommand, myFalseCommand;
    private static final int TRUECOMMAND = 0;
    private static final int FALSECOMMAND = 1;

    public IfElse (List<SingleTurtle> turtle, List<StringBuilder> ListOfContents,
                   ResourceBundle lang, List<Variable> variables, List<UserCommand> commands) {
        System.out.println("If was Created");
        myTurtle = turtle;
        myTrueCommand = ListOfContents.get(TRUECOMMAND).toString();
        myFalseCommand = ListOfContents.get(FALSECOMMAND).toString();
        myLanguage = lang;
        myVariableList = variables;
        myUserCommandList = commands;
    }

    @Override
    public String executeCommand () {
        Parser parser = new Parser(myTurtle, myLanguage, myVariableList, myUserCommandList);
        boolean ifOrElse = (Integer.parseInt(myChildren[0].getValue()) == 0);
        if ((ifOrElse && myTrueCommand == null) || !(ifOrElse) && myFalseCommand == null)
            return ZERO;

        Stack<Node> result;
        try {
            Collection<?> contents =
                    Arrays.asList((ifOrElse ? myTrueCommand : myFalseCommand).split(" "));
            result = parser.buildExpressionTree(contents);
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
