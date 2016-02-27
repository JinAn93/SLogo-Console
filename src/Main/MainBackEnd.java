package Main;

import java.util.ArrayDeque;
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

    // private CommandInterface currentCommand;

    private static final ResourceBundle myParameters = ResourceBundle
            .getBundle("resources.ParameterList/AllParameters");
    private static final ResourceBundle mySyntaxes = ResourceBundle
            .getBundle("resources.languages/Syntax");
    private ResourceBundle myLanguages = ResourceBundle.getBundle("resources.languages/" +
                                                                  possibleLanguages[DEFAULTLANG]);

     public static void main(String args[]){
         MainBackEnd mb = new MainBackEnd();
         Collection<?> commands = mb.setup("sum 1 2"); 
         for(int i = commands.size() - 1; i > -1; i--){
             //System.out.println(commands[i]);
         }
         Node[] temp = mb.buildExpressionTree(commands);
         for(int i = 0; i < temp.length; i++){
             System.out.println(temp[i].getValue());
         }
     }

    public MainBackEnd () {

    }

    public void executeCommand (Collection<?> commands) {
        Node[] temp = buildExpressionTree(commands);
        
    }

    public Collection<?> setup (String input) {
        CommandDecoder cDecoder = new CommandDecoder();
        return cDecoder.parseCommand(input);
    }

    private Node[] buildExpressionTree (Collection<?> ListOfCommands) {
        Deque<Node> stack = new ArrayDeque<Node>();
        CommandFactory cf = new CommandFactory();
        String[] commands = ListOfCommands.toArray(new String[ListOfCommands.size()]);
        for (int i = commands.length - 1; i > -1; i--) {
            Node command;
            if (isCommand(commands[i])) {
                command = cf.makeInstruction(commands[i]);

                int paramNum = getParamNum(commands[i]);
                Node[] children = new Node[paramNum];
                System.out.println(commands[i]);
                System.out.println(paramNum);
                for (int c = 0; c < paramNum; c++) {
                    children[c] = stack.pop();
                }
                ((Command) command).setChildren(children);
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
            System.out.println(whichCommand);
            if (command.matches(myLanguages.getString(whichCommand))) {
                return Integer.parseInt(myParameters.getString(whichCommand));
            }
        }
        return 0;
    }

    public void setLanguage (ResourceBundle bundle) {
        myLanguages = bundle;
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
