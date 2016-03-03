package Main;

import java.util.Observable;
import javafx.scene.image.Image;

/**
 * Turtle class serves to store its properties such as visibility, xCor, yCor, and pen (up or Down)
 * 
 * @author Jin An
 *
 */
public class Turtle extends Observable{

    private double startXCor, startYCor, endXCor, endYCor, myHeading;
    private int myVisibility, myPen;
    private Image myTurtleImage;
    private double penWidth;
    public Turtle (int x, int y, String dir) {
    	startXCor = x;
    	startYCor = y;
    	endXCor = x;
    	endYCor = y;
        myVisibility = 1;
        myPen = 1;
        myTurtleImage = new Image(dir);
        myHeading = 0;
        penWidth = 4.0;
    }

    public double getHeading () {
        return myHeading;
    }
    public double getStartXCor () {
        return startXCor;
    }

    public double getStartYCor () {
        return startYCor;
    }
    
    public double getEndYCor(){
    	return endYCor;
    }
    
    public double getEndXCor(){
    	return endXCor;
    }

    public void setHeading (double heading){
        myHeading = heading % 360;
        setChanged();
        notifyObservers();
    }
    public void setStartXCor (double xCor) {
    	startXCor = xCor;
    }

    public void setStartYCor (double yCor) {
    	startYCor = yCor;
    }
    
    public void setEndXCor (double xCor){
    	endXCor = xCor;
    	setChanged();
    	notifyObservers();
    }
    
    public void setEndYCor (double yCor){
    	endYCor = yCor;
    	setChanged();
    	notifyObservers();
    }

    public int getVisibility () {
        return myVisibility;
    }

    public void setVisibility (int visibility) {
        myVisibility = visibility;
        setChanged();
        notifyObservers();
    }

    public int getPen () {
        return myPen;
    }

    public void setPen (int pen) {
        myPen = pen;
        setChanged();
        notifyObservers();
    }
    
    public double getPenWidth(){
    	return penWidth;
    }
    
    public void setPenWidth(double width){
    	penWidth = width;
    }
    
    public Image getTurtleImage(){
    	return myTurtleImage; 
    }
    
    public void setTurtleImage(String dir){
    	this.myTurtleImage = new Image(dir);
        setChanged();
        notifyObservers();
    }
}
