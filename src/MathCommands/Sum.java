package MathCommands;
import java.util.Arrays;
import Commands.*;


public class Sum extends Command{

    public final int NUMBEROFCHILDREN = 2;
    private Node[] children = new Node[NUMBEROFCHILDREN];
    
    public Sum(){

    }
    
    @Override
    public String executeCommand (){
        int sum = 0;
        for(int i = 0; i < NUMBEROFCHILDREN; i++){
            System.out.println(children[i].getClass().getName());
            sum += Integer.parseInt(children[i].getValue());
            
        }
        return Integer.toString(sum);
        
    }




    @Override
    public int numberOfChildren () {
        return NUMBEROFCHILDREN;
    }

    @Override
    public void setChildren (Node[] kids) {
        for(int i = 0; i < kids.length; i++){
            children[i] = kids[i];
           
        }
    }
    
    @Override
    public Node[] getChildren () {
        return children;
    }


}
