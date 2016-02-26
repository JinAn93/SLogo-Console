package Commands;
import java.lang.Class;

public class CommandFactory {
    public CommandInterface makeInstruction (String[] commands){
        if(commands[0] == null){
            return null;
        }
    
        if(commands[0].equalsIgnoreCase("Sum")){ //use resourcebundle
            return new SumCommand(commands);
        }
        
        return null;
        /*    
        try {
            return (CommandInterface) Class.forName(commands[0]).newInstance().
        }
        catch (InstantiationException e) {
            // TODO BAD CODE!!
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            // TODO BAD CODE!!
            e.printStackTrace();
        }       
        catch (ClassNotFoundException e) {
            // TODO BAD CODE!!
            e.printStackTrace();
        }
        return null;
        */
    }
    
    
}

        