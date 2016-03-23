package fxFrontend;

public class DisplayObject {
    private String variableName;
    private String variableValue;

    public DisplayObject (String myName, String myValue) {
        variableName = myName;
        variableValue = myValue;
    }

    public void setName (String name) {
        variableName = name;
    }

    public void setValue (String value) {
        variableValue = value;
    }

    public String getVariableName () {
        return variableName;
    }

    public String getVariableValue () {
        return variableValue;
    }
}
