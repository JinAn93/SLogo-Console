package AllCommands;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import CommandTypes.ControlStructuredCommand;
import NodeTypes.*;
import Turtle.*;
import BackEndMain.*;


public class Repeat extends ControlStructuredCommand {

    public Repeat (List<SingleTurtle> turtle, List<StringBuilder> ListOfContents,
                   ResourceBundle lang, List<Variable> variables, List<UserCommand> commands) {
        System.out.println("Repeat was created");
        myTurtle = turtle;
        myContent = ListOfContents.get(0).toString();
        myLanguage = lang;
        myVariableList = variables;
        myUserCommandList = commands;
    }

    @Override
    public String executeCommand () {
        if (myContent == null)
            return ZERO;
        int repNumber = Integer.parseInt(myChildren[FIRSTCHILD].getValue());
        StringBuilder newCommand = new StringBuilder();
        for (int i = 0; i < repNumber; i++) {
            newCommand.append(myContent);
        }
        newCommand.deleteCharAt(newCommand.length() - 1);
        System.out.println("The copied Strings are : \n" + newCommand.toString() + "\n");
        Parser parser = new Parser(myTurtle, myLanguage, myVariableList, myUserCommandList);

        Stack<Node> result;
        try {
            result = parser.buildExpressionTree(Arrays.asList(newCommand.toString().split(" ")));
            if (result == null) {
                throw new Exception();
            }
            List<String> ret = parser.stringizer(result);
            System.out.println("Repeat Stack is done! Repeat will return : " +
                               ret.get(ret.size() - 1));
            return ret.get(ret.size() - 1);
        }
        catch (Exception e) {
            return null;
        }
    }
}
