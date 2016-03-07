package Main;

import java.util.ArrayList;
import java.util.List;
import Commands.Variable;


public class Output {

    private List<String> myResult = new ArrayList<String>();
    private List<Turtle> myTurtle;
    private List<Variable> myVariables = new ArrayList<Variable>();
    private boolean badCommand = false; 
    private String myErrorType; 
    private String myErrorMessage; 
    
    public Output (List<Turtle> turtle, List<Variable> variables) {
        myTurtle = turtle;
        myVariables = variables;
    }
    
    public Output(List<Turtle> turtle, List<Variable> variables, String errorType, String errorMessage){
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

    public List<Turtle> getTurtle () {
        return myTurtle;
    }

    public void updateTurtle (List<Turtle> turtle) {
        this.myTurtle = turtle;
    }

    public List<Variable> getVariables () {
        return myVariables;
    }

    public void updateVariable (List<Variable> variables) {
        this.myVariables = variables;
    }
    
    public boolean isValidCommand(){
    	return badCommand;
    }
    
    public void setBadCommand(){
    	badCommand = true; 
    }
    
    public void setValidity(boolean status){
    	badCommand = status; 
    }
    
    public String getErrorMessage(){
    	return myErrorMessage;
    }
    
    public void setErrorMessage(String error){
    	myErrorMessage = error;
    }
    
    
}
