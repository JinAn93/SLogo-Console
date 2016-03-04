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


public class If extends ControlStructuredCommand {
    
    public If (Turtle turtle,
               List<StringBuilder> ListOfContents,
               ResourceBundle lang,
               List<Variable> variables) {
        System.out.println("If was Created");
        myTurtle = turtle;
        myContent = ListOfContents.get(COMMAND_INDEX).toString();
        myLanguage = lang;
        myVariableList = variables;
    }

    @Override
    public String executeCommand () {
        if(Integer.parseInt(myChildren[0].getValue()) != 0)
            return executeStatement();
        else
            return ZERO;
    }
    
    private String executeStatement() {
        CommandDecoder cdecoder = new CommandDecoder();
        Parser parser = new Parser(myTurtle, myLanguage, myVariableList);
        Stack<Node> result =
                parser.buildExpressionTree(cdecoder.parseCommand((myContent.toString())));
        List<String> ret = parser.stringizer(result);

        return ret.get(ret.size() - 1);
    }
}
