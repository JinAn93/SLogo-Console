package Commands;

public interface CommandInterface {
    CommandInterface makeCommand (String command);
    int executeCommand(String[] listofCommands);
}
