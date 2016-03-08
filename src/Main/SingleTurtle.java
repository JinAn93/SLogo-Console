package Main;

import java.util.Observable;
import javafx.scene.image.Image;


public class SingleTurtle extends Observable implements Turtle {

    private double startXCor, startYCor, endXCor, endYCor, myHeading;
    private int myVisibility, myPen;
    private Image myTurtleImage;
    private double penWidth;
    private boolean isActive = true;

    public SingleTurtle (int x, int y, String dir) {
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

    @Override
    public boolean getActive () {
        return isActive;
    }

    @Override
    public void setActive (boolean active) {
        isActive = active;
        setChanged();
        notifyObservers();
    }

    @Override
    public double getHeading () {
        return myHeading;
    }

    @Override
    public double getStartXCor () {
        return startXCor;
    }

    @Override
    public double getStartYCor () {
        return startYCor;
    }

    @Override
    public double getEndYCor () {
        return endYCor;
    }

    @Override
    public double getEndXCor () {
        return endXCor;
    }

    @Override
    public void setHeading (double heading) {
        myHeading = heading % 360;
        setChanged();
        notifyObservers();
    }

    @Override
    public void setStartXCor (double xCor) {
        startXCor = xCor;

    }

    @Override
    public void setStartYCor (double yCor) {
        startYCor = yCor;

    }

    @Override
    public void setEndXCor (double xCor) {
        endXCor = xCor;
        setChanged();
        notifyObservers();

    }

    @Override
    public void setEndYCor (double yCor) {
        endYCor = yCor;
        setChanged();
        notifyObservers();
    }

    @Override
    public int getVisibility () {
        return myVisibility;
    }

    @Override
    public void setVisibility (int visibility) {
        myVisibility = visibility;
        setChanged();
        notifyObservers();
    }

    @Override
    public int getPen () {
        return myPen;
    }

    @Override
    public void setPen (int pen) {
        myPen = pen;
        setChanged();
        notifyObservers();
    }

    @Override
    public double getPenWidth () {
        return penWidth;
    }

    @Override
    public void setPenWidth (double width) {
        penWidth = width;

    }

    @Override
    public Image getTurtleImage () {
        return myTurtleImage;
    }

    @Override
    public void setTurtleImage (String dir) {
        this.myTurtleImage = new Image(dir);
        setChanged();
        notifyObservers();
    }

}
