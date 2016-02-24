package Commands;

public interface Command {
    Command makeCommand (String command);
    int executeCommand();
}
