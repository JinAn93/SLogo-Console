package Main;

import javafx.scene.image.Image;

/**
 * Turtle class serves to store its properties such as visibility, xCor, yCor, and pen (up or Down)
 * 
 * @author Jin An
 *
 */
public class Turtle {

    private int myXCor, myYCor;
    private boolean myVisibility, myPen;
    private Image myTurtleImage = new Image("/resources/koopa.png");
    public Turtle (int x, int y) {
        myXCor = x;
        myYCor = y;
        myVisibility = true;
        myPen = false;
    }

    public int getXCor () {
        return myXCor;
    }

    public int getYCor () {
        return myYCor;
    }

    public void setXCor (int xCor) {
        myXCor = xCor;
    }

    public void setYCor (int yCor) {
        myYCor = yCor;
    }

    public boolean getVisibility () {
        return myVisibility;
    }

    public void setVisibility (boolean visibility) {
        myVisibility = visibility;
    }

    public boolean getPen () {
        return myPen;
    }

    public void setPen (boolean pen) {
        myPen = pen;
    }
    
    public Image getTurtleImage(){
    	return myTurtleImage; 
    }
}
