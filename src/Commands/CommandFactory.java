package Commands;
import MathCommands.*;

public class CommandFactory {
    public Command makeInstruction (String command){

    
        if(command.equalsIgnoreCase("Sum")){ //use resourcebundle
            Command ret = new Sum();
            ret.setOperand(false);
            System.out.println("sum was created");
            return ret;
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

        