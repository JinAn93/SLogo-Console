package Main;

import java.util.ArrayList;
import java.util.List;
import Commands.Variable;


public class Output {

    private List<String> myResult = new ArrayList<String>();
    private Turtle myTurtle;
    private List<Variable> myVariables = new ArrayList<Variable>();
    private boolean badCommand = false; 
    
    public Output (Turtle turtle, List<Variable> variables) {
        myTurtle = turtle;
        myVariables = variables;
    }

    public List<String> getResult () {
        return myResult;
    }

    public void setResult (List<String> result) {
        this.myResult = result;
    }

    public Turtle getTurtle () {
        return myTurtle;
    }

    public void updateTurtle (Turtle turtle) {
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
    
    public void setValidity(boolean status){
    	badCommand = status; 
    }

}
