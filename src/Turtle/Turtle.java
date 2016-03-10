package Turtle;

import javafx.scene.image.Image;


/**
 * Turtle class serves to store its properties such as visibility, xCor, yCor, and pen (up or Down)
 * 
 * @author Jin An and David Yan
 * 
 */
public interface Turtle {

    public boolean getActive ();

    public double getHeading ();

    public double getStartXCor ();

    public double getStartYCor ();

    public double getEndYCor ();

    public double getEndXCor ();

    public int getVisibility ();

    public int getPen ();

    public double getPenWidth ();

    public Image getTurtleImage ();

    public void setActive (boolean active);

    public void setHeading (double heading);

    public void setStartXCor (double xCor);

    public void setStartYCor (double yCor);

    public void setEndXYCor (double xCor, double yCor);

    public void setVisibility (int visibility);

    public void setPen (int pen);

    public void setPenWidth (double width);

    public void setTurtleImage (String dir);

	public void setPenDashed();
	
	public boolean getPenDashed(); 
}
