package Main;
import java.util.ResourceBundle;
import java.util.Stack;
import CommandExecutors.*;
import Commands.CommandFactory;
import Commands.CommandInterface;
import MathCommands.*;

/**
 * MainBackEnd serves to create Expression Tree and execute commands as it reads the nodes
 * @author Jin An
 * @author Sarp Uner
 *
 */
public class MainBackEnd {

    private static final String[] possibleLanguages = { "English" };
    private static final int TURTLECOMMAND = 0;
    private static final int TURTLEQUERIES = 1;
    private static final int MATHOP = 2;
    private static final int BOOLOP = 3;
    private static final int USERDEFINED = 4;
    private CommandInterface currentCommand;
    
    ResourceBundle myResources;

    public static void main(String args[]){
        MainBackEnd mb = new MainBackEnd();
        System.out.println(mb.myResources.getObject("Sum").getClass().getName());
        
    }
    public MainBackEnd () {
        
    }

    public String[] setup (String input, int lang) {
        myResources = ResourceBundle.getBundle("resources.languages/" + possibleLanguages[lang]);
        CommandDecoder cDecoder = new CommandDecoder();
        String[] commands = cDecoder.parseCommand(input);
        return commands;
    }
    
    private void buildExpressionTree(String[] commands){
        if(commands[0] == myResources.getString("Sum")){
            MainBackEnd mbe = new MainBackEnd();   
        }
            
    }
  
    

    public void executeCommand (String[] commands) {
        CommandFactory cFactory = new CommandFactory();
        Stack<String> stack = new Stack<String>();
        String prevElement = new String();
        String commandExecuting = new String();
        int argCount = 0;
        while(commands.length > 0){
            if(isCommand(commands[0])){
                currentCommand = cFactory.makeInstruction(commands[0]);
            }
            /*
            if (stack.isEmpty() && !(isCommand(input))) {
                // Wrong input
            }
            else {
                if (isCommand(input)) {
                    stack.push(input);
                    commandExecuting = input;
                }
                if (isConstant(input)) {
                    argCount ++;
                    //check how many args commandExecuting requires
                    // if # args required == argCount --> Execute commandExecuting
                    
                }
                if (isVariable(input)) {
                }
                if (isList(input)) {
                }
            }
            prevElement = stack.peek();*/
        } 
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
