import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;


/**
 * CommandDecoder serves to parse the input and check whether there exist any error.
 * 
 * @author Jin An
 *
 */
public class CommandDecoder {
    public boolean checkError (String input) {
        return false;
    }

    public Collection<List<String>> parseCommand (String input) {
        PriorityQueue<List<String>> commandList = new PriorityQueue<List<String>>();
        String[] CommandbyLine = input.split("\n");
        String commentFreeInput = new String();
        for (String line : CommandbyLine){
            if(!line.startsWith("#")){
                commentFreeInput += line;
            }
            // If line includes only space, take out the line
        }
        //Split with space
        //Group command name with relevant information
        //Store into PQ
        return commandList;
    }
}
