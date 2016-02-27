package Main;

public class Output {
    private String myOutputCommand;
    private Turtle myTurtle;

    public Output (String command) {
        myOutputCommand = command;
    }

    public String getCommand () {
        return myOutputCommand;
    }

    public void setCommand (String command) {
        this.myOutputCommand = command;
    }
    
    public void updateTurtle (Turtle turtle){
        this.myTurtle = turtle;
    }
}
