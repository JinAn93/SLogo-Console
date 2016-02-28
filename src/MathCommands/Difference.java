package MathCommands;

import Commands.*;

public class Difference extends MathOpCommand {
    public final int NUMBEROFCHILDREN = 2;
    private Node[] children = new Node[NUMBEROFCHILDREN];
    
    public Difference(){

    }
    
    @Override
    public String executeCommand (){
        int difference = Integer.parseInt(children[0].getValue());
        difference = difference - Integer.parseInt(children[1].getValue());
        return Integer.toString(difference);      
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
