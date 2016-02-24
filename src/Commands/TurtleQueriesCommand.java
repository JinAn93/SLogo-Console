package Commands;

public class TurtleQueriesCommand implements Command {

    private String myCommand;
    @Override
    public Command makeCommand (String command) {
        // TODO Auto-generated method stub
        myCommand = command;
        return null;
    }

    @Override
    public int executeCommand () {
        // TODO Auto-generated method stub
        return 0;
    }
}
