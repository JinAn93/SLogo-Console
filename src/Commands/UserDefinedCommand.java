package Commands;

import java.util.ResourceBundle;



public class UserDefinedCommand extends Command {

    @Override
    public String executeCommand () {
        // TODO Auto-generated method stub
        return null;
    }
    
    public String getValue(){
        return executeCommand();
    }

    @Override
    public void setChildren (Node[] kids, ResourceBundle parameters) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Node[] getChildren () {
        // TODO Auto-generated method stub
        return null;
    }
}
