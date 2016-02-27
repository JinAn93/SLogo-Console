package MathCommands;

import Commands.Command;
import Commands.Node;

public class Remainder extends Command{
    public final int NUMBEROFCHILDREN = 2;
    private Node[] children = new Node[NUMBEROFCHILDREN];
    
    public Remainder(){

    }
    
    @Override
    public String executeCommand (){
        int remainder = Integer.parseInt(children[0].getValue());
        remainder = remainder % Integer.parseInt(children[1].getValue());
        return Integer.toString(remainder);      
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
