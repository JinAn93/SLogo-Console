package Commands;
import MathCommands.*;

public class CommandFactory {
    public Node makeInstruction (String command){

    
        if(command.equalsIgnoreCase("Sum")){ //use resourcebundle
            Node ret = new Sum();
            ret.setOperand(false);
            System.out.println("sum was created");
            return ret;
        }
        
        return null;
    }
    
    public Node makeOperand (String operand){
        if(operand == null){
            System.out.println(operand + " was not created");
            return null;
        }
        
        Node op = new Operand();
        op.setValue(operand);
        op.setOperand(true);
        System.out.println(operand + " was created");
        return op;
    }
    
    
}

        