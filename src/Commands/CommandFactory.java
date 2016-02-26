package Commands;
import java.lang.Class;
import MathCommands.*;

public class CommandFactory {
    public CommandInterface makeInstruction (String[] commands){
        if(commands[0] == null){
            return null;
        }
    
        if(commands[0].equalsIgnoreCase("Sum")){ //use resourcebundle
            return new Sum(commands);
        }
        
        return null;
    }
    
    
}

        