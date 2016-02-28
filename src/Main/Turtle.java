package Main;

import javafx.scene.image.Image;

/**
 * Turtle class serves to store its properties such as visibility, xCor, yCor, and pen (up or Down)
 * 
 * @author Jin An
 *
 */
public class Turtle {

    private int myXCor, myYCor, myHeading, myVisibility, myPen;
    private Image myTurtleImage;
    public Turtle (int x, int y, String dir) {
        myXCor = x;
        myYCor = y;
        myVisibility = 1;
        myPen = 0;
        myTurtleImage = new Image(dir);
        myHeading = 0;
    }

    public int getHeading () {
        return myHeading;
    }
    public int getXCor () {
        return myXCor;
    }

    public int getYCor () {
        return myYCor;
    }

    public void setHeading (int heading){
        myHeading = heading;
    }
    public void setXCor (int xCor) {
        myXCor = xCor;
    }

    public void setYCor (int yCor) {
        myYCor = yCor;
    }

    public int getVisibility () {
        return myVisibility;
    }

    public void setVisibility (int visibility) {
        myVisibility = visibility;
    }

    public int getPen () {
        return myPen;
    }

    public void setPen (int pen) {
        myPen = pen;
    }
    
    public Image getTurtleImage(){
    	return myTurtleImage; 
    }
    
    public void setTurtleImage(String dir){
    	this.myTurtleImage = new Image(dir);
    }
}
