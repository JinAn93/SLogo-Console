package UserDefinedCommand;

import Commands.Node;
import Commands.UserDefinedCommand;


public class Repeat extends UserDefinedCommand {

    private Node[] myChildren;
    private static final int numRepeatIndex = 0;

    public String execommand () {
        int repeatTimes = Integer.parseInt(myChildren[numRepeatIndex].getValue()) - 1;
        myChildren[numRepeatIndex].setValue(Integer.toString(repeatTimes));
        if(repeatTimes == 0){
            return null; //return value from last execution
        }
        else{
            return this.getClass().getSimpleName();
        }
    }

    @Override
    public void setChildren (Node[] kids) {
        myChildren = kids;
    }

    @Override
    public Node[] getChildren () {
        return myChildren;
    }
}
