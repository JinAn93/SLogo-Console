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

    private double myXCor, myYCor, myHeading;
    private int myVisibility, myPen;
    private Image myTurtleImage;
    public Turtle (int x, int y, String dir) {
        myXCor = x;
        myYCor = y;
        myVisibility = 1;
        myPen = 1;
        myTurtleImage = new Image(dir);
        myHeading = 0;
    }

    public double getHeading () {
        return myHeading;
    }
    public double getXCor () {
        return myXCor;
    }

    public double getYCor () {
        return myYCor;
    }

    public void setHeading (double heading){
        myHeading = heading % 360;
        setChanged();
        notifyObservers();
    }
    public void setXCor (double xCor) {
        myXCor = xCor;
        setChanged();
        notifyObservers();
    }

    public void setYCor (double yCor) {
        myYCor = yCor;
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
    
    public Image getTurtleImage(){
    	return myTurtleImage; 
    }
    
    public void setTurtleImage(String dir){
    	this.myTurtleImage = new Image(dir);
        setChanged();
        notifyObservers();
    }
}
