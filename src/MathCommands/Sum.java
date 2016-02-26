package MathCommands;
import java.util.Arrays;
import Commands.*;


public class Sum extends MathOpCommand{
    private String operand1;
    private String operand2;
    private String[] commands;
    
    public Sum(String[] listOfCommands){
        operand1 = listOfCommands[0];
        operand2 = listOfCommands[1];
        commands = Arrays.copyOfRange(listOfCommands, 2, listOfCommands.length);
    }
    
   
    @Override
    public int executeCommand (){
        return parse(operand1, commands) + parse(operand2, commands);
        return 0;
    }
    

}
