package Commands;

public interface Node {
    public String setValue(String str);
    public String getValue();
    public boolean setOperand(boolean bool);
    public boolean isOperand();
    public int numberOfChildren();
    void setChildren (Node[] children);
    public Node[] getChildren();

}
