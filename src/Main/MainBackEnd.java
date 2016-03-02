package Main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import Commands.*;


/**
 * MainBackEnd serves to create Expression Tree and execute commands as it reads the nodes
 * 
 * @author Jin An
 * @author Sarp Uner
 *
 */

public class MainBackEnd {

    private static final int DEFAULTLANG = 0;

    private static List<Variable> myVariableList = new ArrayList<Variable>();
    private static final String[] possibleLanguages = { "English" };
    private static ResourceBundle myLanguages = ResourceBundle
            .getBundle("resources.languages/" +
                       possibleLanguages[DEFAULTLANG]);
    private Turtle myTurtle;

    public MainBackEnd () {
    }

    public Output executeCommand (Collection<?> commands) {
        Parser parser = new Parser(myTurtle, myLanguages, myVariableList);
        Stack<Node> result = parser.buildExpressionTree(commands);
        Output output = new Output(myTurtle, myVariableList);
        output.setResult(parser.stringizer(result));
        return output;
    }

    public Collection<?> setup (String input, InputObject inputObject) {
        CommandDecoder cDecoder = new CommandDecoder();
        InputObject io = inputObject;
        myTurtle = io.getTurtle();
        System.out.println(cDecoder.parseCommand(input));
        return cDecoder.parseCommand(input);
    }

    private void setLanguage (ResourceBundle bundle) {
        myLanguages = bundle;
    }

    public static List<Variable> getVariables () {
        return myVariableList;
    }
}
