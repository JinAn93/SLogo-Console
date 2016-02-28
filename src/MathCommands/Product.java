package MathCommands;

import Commands.Command;
import Commands.MathOpCommand;
import Commands.Node;

public class Product extends MathOpCommand {
    public final int NUMBEROFCHILDREN = 2;
    private Node[] children = new Node[NUMBEROFCHILDREN];
    
    public Product(){

    }
    
    @Override
    public String executeCommand (){
        int product = 1; //This should be 1 as this is multiplication
        for(int i = 0; i < NUMBEROFCHILDREN; i++){
            System.out.println(children[i].getValue());
            product = product * Integer.parseInt(children[i].getValue());  
        }
        return Integer.toString(product);  
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
