package AllCommands;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import Commands.ControlStructuredCommand;
import Commands.Node;
import Commands.Variable;
import Main.CommandDecoder;
import Main.Parser;
import Main.Turtle;


public class Repeat extends ControlStructuredCommand {

    public Repeat (Turtle turtle, String content, ResourceBundle lang, List<Variable> variables) {
        System.out.println("Repeat was created");
        myTurtle = turtle;
        myContent = content;
        myLanguage = lang;
        myVariableList = variables;
    }

    @Override
    public String executeCommand () {
        int repNumber = Integer.parseInt(myChildren[FIRSTCHILD].getValue());
        StringBuilder newCommand = new StringBuilder();
        for (int i = 0; i < repNumber; i++) {
            newCommand.append(myContent);
        }
        newCommand.deleteCharAt(newCommand.length()-1);
        System.out.println("The copied Strings are : \n" + newCommand.toString() + "\n");
        CommandDecoder cdecoder = new CommandDecoder();
        Parser parser = new Parser(myTurtle, myLanguage, myVariableList);
        Stack<Node> result = parser.buildExpressionTree(cdecoder.parseCommand((newCommand.toString())));
        List<String> ret = parser.stringizer(result);
        System.out.println("Repeat Stack is done! Repeat will return : " + ret.get(ret.size()-1));
        return ret.get(ret.size()-1);
    }
}
