package BackEndMain;

import java.util.List;
import java.util.ResourceBundle;
import Turtle.*;


/**
 * InputObject serves to save all the input needed for backend to process the commands. It is
 * created in Frontend and it is passed to backend. It contains input command, list of Single Turtle
 * Objects, and language ResourceBundle. All variables are private and getter and setter methods are
 * used to access each object.
 * 
 * @author Jin An
 * @author David Yan
 * @author Cody Li
 * @author Sarp Uner
 *
 */
public class InputObject {
    private String myCommand;
    private List<SingleTurtle> myAllTurtles;
    private ResourceBundle myLanguage;

    public InputObject (String command, List<SingleTurtle> turtle, ResourceBundle language) {
        myCommand = command;
        myAllTurtles = turtle;
        myLanguage = language;
    }

    public InputObject (ResourceBundle language) {
        myLanguage = language;
    }

    public void setCommand (String command) {
        myCommand = command;
    }

    public void setTurtle (List<SingleTurtle> turtle) {
        myAllTurtles = turtle;
    }

    public String getCommand () {
        return myCommand;
    }

    public List<SingleTurtle> getTurtle () {
        return myAllTurtles;
    }

    public void setLanguage (ResourceBundle bundle) {
        myLanguage = bundle;
    }

    public ResourceBundle getLanguage () {
        return myLanguage;
    }

}
