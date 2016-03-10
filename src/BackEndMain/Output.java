package BackEndMain;

import java.util.ArrayList;
import java.util.List;
import NodeTypes.*;
import Turtle.*;


public class Output {

    private List<String> myResult = new ArrayList<String>();
    private List<SingleTurtle> myTurtle;
    private List<Variable> myVariables = new ArrayList<Variable>();
    private List<UserCommand> myUserCommands = new ArrayList<UserCommand>();
    private boolean badCommand = false;
    private String myErrorType;
    private String myErrorMessage;

    public Output (List<SingleTurtle> turtle, List<Variable> variables, List<UserCommand> commands) {
        myTurtle = turtle;
        myVariables = variables;
        myUserCommands = commands;
    }

    public Output (List<SingleTurtle> turtle,
                   List<Variable> variables,
                   String errorType,
                   String errorMessage) {
        myTurtle = turtle;
        myVariables = variables;
        myErrorType = errorType;
        myErrorMessage = errorMessage;
    }

    public List<String> getResult () {
        return myResult;
    }

    public void setResult (List<String> result) {
        this.myResult = result;
    }

    public List<SingleTurtle> getTurtle () {
        return myTurtle;
    }

    public void updateTurtle (List<SingleTurtle> turtle) {
        this.myTurtle = turtle;
    }

    public List<Variable> getVariables () {
        return myVariables;
    }

    public List<UserCommand> getUserCommands() {
        return myUserCommands;
    }
    
    public void updateVariable (List<Variable> variables) {
        this.myVariables = variables;
    }

    public boolean isValidCommand () {
        return badCommand;
    }

    public void setBadCommand () {
        badCommand = true;
    }

    public void setValidity (boolean status) {
        badCommand = status;
    }

    public String getErrorMessage () {
        return myErrorMessage;
    }

    public void setErrorMessage (String error) {
        myErrorMessage = error;
    }

}
