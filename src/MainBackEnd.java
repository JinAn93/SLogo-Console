import java.util.Stack;


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
        cDecoder.checkError(input);
        String[] commands = cDecoder.parseCommand(input);
        return commands;
    }

    public void executeCommand (String[] commands) {
        CommandExecutor[] possibleExecutors =
        { new TurtleCommandExecutor(), new TurtleQueriesExecutor(), new MathOpExecutor(),
         new BoolOpExecutor(), new UserDefinedExecutor() };
        Stack<String> stack = new Stack<String>();
        for (String input : commands) {
            if (stack.isEmpty()) {
                if (isCommand(input)){
                    stack.push(input);
                }
                else{
                    //Wrong input
                }
            }
            else {
                if (isCommand(input)) {
                }
                if (isVariable(input)) {
                }
                if (isConstant(input)) {
                }
                if (isList(input)) {
                }
            }
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
