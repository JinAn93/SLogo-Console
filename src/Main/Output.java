package Main;

import java.util.ArrayList;
import java.util.List;

public class Output {

    private List<String> myResult = new ArrayList<String>();
    private Turtle myTurtle;

    public Output (Turtle turtle) {
       myTurtle = turtle;
    }

    public List<String> getResult(){
        return myResult;
    }

    public void setResult(List<String> result){
        this.myResult = result;
    }
    
    public void updateTurtle (Turtle turtle){
        this.myTurtle = turtle;
    }

    public Turtle getTurtle (){
        return myTurtle;
    }
}
