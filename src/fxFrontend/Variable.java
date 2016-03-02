package fxFrontend;

public class Variable {
	private String variableName;
	private double variableValue;
	
	public Variable(String myName, double myValue){
		variableName = myName;
		variableValue = myValue;
	}
	
	public void setName(String name){
		variableName = name;
	}
	public void setValue(double value){
		variableValue = value;
	}
	
	public String getVariableName(){
		return variableName;
	}
	
	public double getVariableValue(){
		return variableValue;
	}
}
