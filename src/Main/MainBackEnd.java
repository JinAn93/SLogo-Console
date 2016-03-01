package Main;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Stack;
import CommandExecutors.*;
import Commands.*;
import MathCommands.*;


/**
 * MainBackEnd serves to create Expression Tree and execute commands as it reads the nodes
 * 
 * @author Jin An
 * @author Sarp Uner
 *
 */

public class MainBackEnd {

    private static final String[] possibleLanguages = { "English" };
    private static final int DEFAULTLANG = 0;


    private static final ResourceBundle myParameters = ResourceBundle
            .getBundle("resources.ParameterList/AllParameters");
    private static final ResourceBundle mySyntaxes = ResourceBundle
            .getBundle("resources.languages/Syntax");
    private static ResourceBundle myLanguages = ResourceBundle.getBundle("resources.languages/" +
                                                                  possibleLanguages[DEFAULTLANG]);

    private Turtle myTurtle;

    public MainBackEnd () {
    }

    public Output executeCommand (Collection<?> commands) {
        Node[] result = buildExpressionTree(commands);
        Output output = new Output(myTurtle);
        
        output.setResult(stringizer(result));
        return output;
    }

    public Collection<?> setup (String input, InputObject inputObject) {
        CommandDecoder cDecoder = new CommandDecoder();
        InputObject io = inputObject;
        myTurtle = io.getTurtle();
        System.out.println(cDecoder.parseCommand(input));
        return cDecoder.parseCommand(input);
    }

    private List<String> stringizer (Node[] input){
        List<String> ret = new ArrayList<String>();
        for(int i=0; i<input.length; i++){
            ret.add(input[i].getValue());
        }
        return ret;
    }
    private Node[] buildExpressionTree (Collection<?> ListOfCommands) {
        Deque<Node> stack = new ArrayDeque<Node>();
        CommandFactory cf = new CommandFactory();
        String[] commands = ListOfCommands.toArray(new String[ListOfCommands.size()]);
        for (int i = commands.length - 1; i > -1; i--) {
            Node command;
            if (isCommand(commands[i])) {
                command = cf.makeInstruction(commands[i], myTurtle, myLanguages);

                int paramNum = getParamNum(commands[i]);
                Node[] children = new Node[paramNum];
                for (int c = 0; c < paramNum; c++) {
                    children[c] = stack.pop();
                }
                ((Command) command).setChildren(children, myParameters);
            }
            else {
                command = cf.makeOperand(commands[i]);
            }
            stack.push(command);
        }
        return stack.toArray(new Node[stack.size()]);
    }


    private int getParamNum (String command) {
        Enumeration<String> keys = myLanguages.getKeys();
        while (keys.hasMoreElements()) {
            String whichCommand =(keys.nextElement());
            if (command.matches(myLanguages.getString(whichCommand))) {
                return Integer.parseInt(myParameters.getString(whichCommand));
            }
        }
        return 0;
    }

    private void setLanguage (ResourceBundle bundle) {
        myLanguages = bundle;
    }
    
    public static ResourceBundle getSyntax(){
        return mySyntaxes;
    }
    public static boolean isCommand (String input) {
        return input.matches(mySyntaxes.getString("Command"));
    }

    private boolean isVariable (String input) {
        return input.matches(mySyntaxes.getString("Variable"));
    }

    private boolean isConstant (String input) {
        return input.matches(mySyntaxes.getString("Constant"));
    }

    private boolean isListStart (String input) {
        return input.matches(mySyntaxes.getString("ListStart"));
    }

    private boolean isListEnd (String input) {
        return input.matches(mySyntaxes.getString("ListEnd"));
    }

    private boolean isGroupStart (String input) {
        return input.matches(mySyntaxes.getString("GroupStart"));
    }

    private boolean isGroupEnd (String input) {
        return input.matches(mySyntaxes.getString("GroupEnd"));
    }
}
