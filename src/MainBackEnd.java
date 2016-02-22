import java.util.Stack;


public class MainBackEnd {

    private static final String[] possibleLanguages = { "English.properties" };

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
            if (isCommand(input)) {}
            if (isVariable(input)) {}
            if (isConstant(input)) {}
            if (isList(input)) {}
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
