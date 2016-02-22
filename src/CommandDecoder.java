import java.util.ArrayList;
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
        PriorityQueue<List<String>> commandQueue = new PriorityQueue<List<String>>();
        List<String> commandList = new ArrayList<String>();
        String[] CommandbyLine = input.split("\n");
        String commentFreeInput = new String();
        for (String line : CommandbyLine) {
            if (!line.startsWith("#")) {
                commentFreeInput += line;
            }
            // If line includes only space, take out the line
        }
        String[] commands = commentFreeInput.split(" ");
        for (String command : commands) {
            // Group command name with relevant information
            // Store into PQ
        }
        return commandQueue;
    }
}
