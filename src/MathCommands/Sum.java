package MathCommands;
import Commands.*;

public class Sum extends MathOpCommand{
    String[] listOfArguments;
    
    public void SumCommand(String[] listOfCommands){
        listOfArguments = listOfCommands;

        
        
    }
    
    @Override
    public int executeCommand (){
//        return parse(myArguments[0], listOfArguments[2:]) + parse(myArguments[1], listOfArguments[2:]);
        return 0;
    }
    

}
