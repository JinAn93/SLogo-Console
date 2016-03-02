package AllCommands;

import Commands.UserDefinedCommand;


public class Repeat extends UserDefinedCommand {

    @Override
    public String executeCommand () {
        int repeatTimes = Integer.parseInt(myChildren[numRepeatIndex].getValue()) - 1;
        myChildren[numRepeatIndex].setValue(Integer.toString(repeatTimes));
        if(repeatTimes == 0){
            return null; //return value from last execution
        }
        else{
            return this.getClass().getSimpleName();
        }
    }
}
