package fxFrontend;

public class Line {
	private double myBeginX, myBeginY, myEndX, myEndY;
	
	public Line(double beginX, double beginY, double endX, double endY){
		myBeginX = beginX;
		myBeginY = beginY;
		myEndX = endX;
		myEndY = endY;
	}
	
	public double getBeginX(){
		return myBeginX;
	}
	public double getBeginY(){
		return myBeginY;
	}
	public double getEndX(){
		return myEndX;
	}
	public double getEndY(){
		return myEndY;
	}
	public Line makeLine(double beginX, double beginY, double endX, double endY){
		return new Line(beginX,beginY,endX,endY);
	}

}
