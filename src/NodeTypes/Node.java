package NodeTypes;

/**
 * Node is an interface which is implemented by Command, Operand, Variable, and UserCommand Objects.
 * 
 * @author Jin An
 * @author Sarp Uner
 *
 */
public interface Node {
    public String setValue (String str);

    public String getValue ();
}
