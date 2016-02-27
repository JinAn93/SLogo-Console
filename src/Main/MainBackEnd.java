package Main;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.ResourceBundle;
import java.util.Stack;
import CommandExecutors.*;
import Commands.*;
import MathCommands.*;

/**
 * MainBackEnd serves to create Expression Tree and execute commands as it reads the nodes
 * @author Jin An
 * @author Sarp Uner
 *
 */

public class MainBackEnd {

    private static final String[] possibleLanguages = { "English" };
    private static final int DEFAULTLANG = 0;
    private static final int TURTLECOMMAND = 0;
    private static final int TURTLEQUERIES = 1;
    private static final int MATHOP = 2;
    private static final int BOOLOP = 3;
    private static final int USERDEFINED = 4;
//    private CommandInterface currentCommand;
    
    ResourceBundle myResources = ResourceBundle.getBundle("resources.languages/" + possibleLanguages[DEFAULTLANG]);

    public static void main(String args[]){
        MainBackEnd mb = new MainBackEnd();
        String[] commands = mb.setup("sum 1 product 2 difference 5 4");   // JUST PLAY AROUND WITH THIS STRING AND THEN RUN MAINBACKEND TO RUN IT !!
        for(int i = commands.length - 1; i > -1; i--){
            //System.out.println(commands[i]);
        }
        Node[] temp = mb.buildExpressionTree(commands);
        for(int i = 0; i < temp.length; i++){
            System.out.println(temp[i].getValue());
        }
        }
    
    public MainBackEnd () {
        
    }

    public String[] setup (String input) {
        CommandDecoder cDecoder = new CommandDecoder();

        String[] commands = cDecoder.parseCommand(input);
        return commands;
    }
    
    public void setLanguage (ResourceBundle bundle){
        myResources = bundle;
    }
    
    private Node[] buildExpressionTree(String[] commands){
        Deque<Node> stack = new ArrayDeque<Node>();
        CommandFactory cf = new CommandFactory();
        for(int i = commands.length - 1; i > -1; i--){
            Node command;
            if(isCommand(commands[i])){
                command = cf.makeInstruction(commands[i]);
                Node[] children = new Node[command.numberOfChildren()];
                for(int c = 0; c < command.numberOfChildren(); c++){
                    children[c] = stack.pop();
                }
                command.setChildren(children);
            }
            else{
                command = cf.makeOperand(commands[i]);
            }
            stack.push(command);
        }
        return stack.toArray(new Node[stack.size()]);
    }
  
    
    

    
    

    public static boolean isCommand (String input) {
        return input.matches("[a-zA-Z_]+(\\?)?");
    }

    private boolean isVariable (String input) {
        return input.matches(":[a-zA-Z_]+");
    }

    private boolean isConstant (String input) {
        return input.matches("-?[0-9]+\\.?[0-9]*");
    }

    private boolean isList (String input) {
        return input.matches("[ ]");
    }
}
