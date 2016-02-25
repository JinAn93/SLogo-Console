package MathCommands;
import Commands.*;

public class SumCommand extends MathOpCommand{
    
    public void SumCommand(String[] listOfArguments){

        
        
    }
    
   
    @Override
    public int executeCommand (){
        return parse(myArguments[0], listOfArguments[2:]) + parse(myArguments[1], listOfArguments[2:]);
        
    }
    

}
