public class TurtleCommandExecutor extends CommandExecutor {
    
    public enum Command {
        Forward(1), Backward(1), Left(1), Right(1), SetHeading(1), SetTowards(2), SetPosition(2),
        PenDown(0), PenUp(0), ShowTurtle(0), HideTurtle(0), Home(0), ClearScreen(0);
        private int paramNeeded;

        private Command (int value) {
            this.paramNeeded = value;
        }
    }
}
