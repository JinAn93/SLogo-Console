import java.util.Stack;
import CommandExecutors.*;
import Commands.CommandFactory;


public class MainBackEnd {

    private static final String[] possibleLanguages = { "English.properties" };
    private static final int ENGLISH = 0;
    private static final int TURTLECOMMAND = 0;
    private static final int TURTLEQUERIES = 1;
    private static final int MATHOP = 2;
    private static final int BOOLOP = 3;
    private static final int USERDEFINED = 4;

    public MainBackEnd () {
    }

    public String[] setup (String input) {
        CommandDecoder cDecoder = new CommandDecoder();
        String[] commands = cDecoder.parseCommand(input);
        return commands;
    }

    public void executeCommand (String[] commands) {
        CommandFactory cFactory = new CommandFactory();
        Stack<String> stack = new Stack<String>();
        String prevElement = new String();
        String commandExecuting = new String();
        int argCount = 0;
        for (String input : commands) {
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
            prevElement = stack.peek();
        }
    }

    private boolean isCommand (String input) {
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
