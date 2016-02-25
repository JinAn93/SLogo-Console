package Commands;

public class TurtleQueriesCommand implements CommandInterface {

    private String myCommand;
    @Override
    public CommandInterface makeCommand (String command) {
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
