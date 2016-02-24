package Commands;

import CommandExecutors.CommandExecutor;
import CommandExecutors.TurtleCommandExecutor;

public class TurtleCommand implements Command {
    
    private String myCommand;
    private int myArgNeeded;
    
    public enum Commands {
        Forward(1), Backward(1), Left(1), Right(1), SetHeading(1), SetTowards(2), SetPosition(2),
        PenDown(0), PenUp(0), ShowTurtle(0), HideTurtle(0), Home(0), ClearScreen(0);
        private int argNeeded;

        private Commands (int value) {
            this.argNeeded = value;
        }
    }
    
    @Override
    public Command makeCommand (String command) {
        myCommand = command;
        myArgNeeded = Commands.valueOf(command).argNeeded;
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int executeCommand () {
        CommandExecutor cExector = new TurtleCommandExecutor(myCommand);
        // TODO Auto-generated method stub
        return 0;
    }

}
