package fxFrontend;

public class DisplayVariable {
	private String variableName;
	private String variableValue;
	
	public DisplayVariable(String myName, String myValue){
		variableName = myName;
		variableValue = myValue;
	}
	
	public void setName(String name){
		variableName = name;
	}
	public void setValue(String value){
		variableValue = value;
	}
	
	public String getVariableName(){
		return variableName;
	}
	
	public String getVariableValue(){
		return variableValue;
	}
}
