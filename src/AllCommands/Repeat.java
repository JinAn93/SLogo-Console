package AllCommands;

import Commands.UserDefinedCommand;


public class Repeat extends UserDefinedCommand {

    public Repeat (String content){
        myContent = content;
    }
    
    @Override
    public String executeCommand () {
        int repNumber = Integer.parseInt(myChildren[FIRSTCHILD].getValue());
        StringBuilder newCommand = new StringBuilder();
        for (int i=0; i<repNumber; i++){
            newCommand.append(myContent);
        }
        return null;
    }
}
