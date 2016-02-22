import java.util.Collection;
import java.util.List;

public class MainBackEnd {

//    private static final CommandExecutor[] myPossibleExecutors =
//    { new TurtleCommandExecutor(), new TurtleQueryExecutor(), new MathOperationExecutor(),
//     new BooleanOperationExecutor(), new UserDefinedExecutor() };

    
    public MainBackEnd (String input) {
        CommandDecoder cDecoder = new CommandDecoder();
        CommandExecutor cExecutor = new CommandExecutor();
        cDecoder.checkError(input);
        Collection<List<String>> command = cDecoder.parseCommand(input);
    }
}
