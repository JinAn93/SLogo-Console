package Turtle;

import java.util.Observable;
import javafx.scene.image.Image;


/**
 * MultipleTurtles implements turtle and serves to perform multiple Turtle commands
 * 
 * @author Jin An
 *
 */
public class MultipleTurtles extends Observable implements Turtle {

    @Override
    public boolean getActive () {
        return false;
    }

    @Override
    public void setActive (boolean active) {
    }

    @Override
    public double getHeading () {
        return 0;
    }

    @Override
    public double getStartXCor () {
        return 0;
    }

    @Override
    public double getStartYCor () {
        return 0;
    }

    @Override
    public double getEndYCor () {
        return 0;
    }

    @Override
    public double getEndXCor () {
        return 0;
    }

    @Override
    public void setHeading (double heading) {
    }

    @Override
    public void setStartXCor (double xCor) {
    }

    @Override
    public void setStartYCor (double yCor) {
    }

    @Override
    public void setEndXYCor (double xCor, double yCor) {
    }

    @Override
    public int getVisibility () {
        return 0;
    }

    @Override
    public void setVisibility (int visibility) {
    }

    @Override
    public int getPen () {
        return 0;
    }

    @Override
    public void setPen (int pen) {
    }

    @Override
    public double getPenWidth () {
        return 0;
    }

    @Override
    public void setPenWidth (double width) {
    }

    @Override
    public Image getTurtleImage () {
        return null;
    }

    @Override
    public void setTurtleImage (String dir) {
    }

    @Override
    public void setPenDashed () {
    }

    @Override
    public boolean getPenDashed () {
        return false;
    }
}
