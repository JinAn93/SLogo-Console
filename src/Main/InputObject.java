package Main;

import java.util.ResourceBundle;

import Main.Turtle;


public class InputObject {
    private String myCommand;
    private Turtle myTurtle;
    private ResourceBundle language;
    
    public InputObject (String command, Turtle turtle) {
        myCommand = command;
        myTurtle = turtle;
    }

    public String getCommand () {
        return myCommand;
    }

    public Turtle getTurtle () {
        return myTurtle;
    }
    
    public void setLanguage(ResourceBundle bundle){
    	language = bundle; 
    }
    
    public ResourceBundle getLanguage(){
    	return language; 
    }

}
