package Commands;
import MathCommands.*;

public class CommandFactory {
    public Command makeInstruction (String command){
        Command ret;
        

    
        if(command.equalsIgnoreCase("Sum")){ //use resourcebundle
            return new Sum();
        }
        
        if(command.equalsIgnoreCase("Product")){
            return new Product();
            
        }
        
        if(command.equalsIgnoreCase("Difference")){
            return new Difference();
        }
        
        return null;
    }
    
    public Operand makeOperand (String operand){
        if(operand == null){
            System.out.println(operand + " was not created");
            return null;
        }
        
        Operand op = new Operand();
        op.setValue(operand);
        op.setOperand(true);
        System.out.println(operand + " was created");
        return op;
    }
    
    
}

        