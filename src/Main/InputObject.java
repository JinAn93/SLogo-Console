package Main;
import Main.Turtle;
public class InputObject {
	private String myCommand;
	private Turtle myTurtle;
	
	public InputObject(String command, Turtle turtle){
		myCommand = command;
		myTurtle = turtle;
	}
	
	public String getCommand(){
		return myCommand;
	}
	
	public Turtle getTurtle(){
		return myTurtle;
	}
	

}
