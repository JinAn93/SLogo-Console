package MathCommands;
import java.util.Arrays;
import Commands.*;


public class Sum extends MathOpCommand{
    
    public Sum(String[] listOfCommands){
        String[] commands = Arrays.copyOfRange(listOfCommands, 1, listOfCommands.length);
        int ret = executeCommand(commands);
        System.out.println(ret);
    }
    
   
    public int executeCommand (String[] commands){
        return parse(commands) + parse(Arrays.copyOfRange(commands,1,commands.length));
    }
}
