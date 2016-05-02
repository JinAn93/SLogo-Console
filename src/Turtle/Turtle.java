package Turtle;

import javafx.scene.image.Image;


/**
 * Turtle class serves to store its properties such as visibility, xCor, yCor, and pen (up or Down)
 *
 * @author Jin An
 * @author David Yan
 *
 */
public interface Turtle {

    boolean getActive ();

    double getHeading ();

    double getStartXCor ();

    double getStartYCor ();

    double getEndYCor ();

    double getEndXCor ();

    int getVisibility ();

    int getPen ();

    TurtlePen getTurtlePen ();

    double getPenWidth ();

    Image getTurtleImage ();

    void setActive (boolean active);

    void setHeading (double heading);

    void setStartXCor (double xCor);

    void setStartYCor (double yCor);

    void setEndXYCor (double xCor, double yCor);

    void setVisibility (int visibility);

    void setPen (int pen);

    void setTurtlePen (TurtlePen turtlePen);

    void setPenWidth (double width);

    void setTurtleImage (String dir);

    void setPenDashed ();

    boolean getPenDashed ();
}
