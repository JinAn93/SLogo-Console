package Error_Checking;

/**
 * Serves to catch exception when there is wrong coordination of brackets.
 * 
 * @author Jin An
 *
 */
public class BracketException extends Exception {

    // for serialization
    private static final long serialVersionUID = 1L;

    public BracketException () {
        super();
    }
}
