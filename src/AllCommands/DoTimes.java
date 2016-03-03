package AllCommands;

import java.util.List;
import java.util.ResourceBundle;
import Commands.ControlStructuredCommand;
import Commands.Variable;
import Main.Turtle;

public class DoTimes extends ControlStructuredCommand{

    private static final int INDEXVARIABLE = 0;
    private static final int LIMIT = 1;
    
    public DoTimes (Turtle turtle, String content, ResourceBundle lang, List<Variable> variables){
        System.out.println("DoTimes was Created");
        myTurtle = turtle;
        myContent = content;
        myLanguage = lang;
        myVariableList = variables;
    }
    @Override
    public String executeCommand () {
        if(myContent == null)
            return ZERO;
        
        return null;
    }

}
