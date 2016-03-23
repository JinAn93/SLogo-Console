package fxFrontend;

import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.transform.Rotate;
import BackEndMain.StrConstant;
import Turtle.SingleTurtle;
import Turtle.Turtle;


public class DisplayUpdater {
    private List<SingleTurtle> myTurtleList;
    private GraphicsContext graphics;
    private double[] xCoor, yCoor, head;
    private int[] visib;
    private static final String TURTLE_NUMBER = "Turtle Number ";
    private static final String X_COOR = "X Coordinate: ";
    private static final String Y_COOR = "Y Coordinate: ";
    private static final String HEAD = "Heading: ";
    private static final String PENDOWN = "Pen: Down";
    private static final String PENUP = "Pen: Up";
    private static final String TUR_HEAD = "Turtle Heading:";
    private static final String TUR_ACTIVE = "Turtle active:";
    private static final int GRAPHIC_START = 0;
    private static final int GRAPHIC_END = 600;

    public DisplayUpdater (List<SingleTurtle> myTurts, GraphicsContext gc) {
        myTurtleList = myTurts;
        graphics = gc;
    }

    public String updateTurtleStats () {
        StringBuilder myTurtleStats = new StringBuilder();
        int turtleID = 0;
        for (Turtle aTurtle : myTurtleList) {
            myTurtleStats.append(TURTLE_NUMBER + turtleID + StrConstant.NEWLINE);
            myTurtleStats.append(X_COOR + aTurtle.getStartXCor() + StrConstant.NEWLINE);
            myTurtleStats.append(Y_COOR + aTurtle.getStartYCor() + StrConstant.NEWLINE);
            myTurtleStats.append(HEAD + aTurtle.getHeading() + StrConstant.NEWLINE);
            if (aTurtle.getPen() == 1) {
                myTurtleStats.append(PENDOWN + StrConstant.NEWLINE);
            }
            else {
                myTurtleStats.append(PENUP + StrConstant.NEWLINE);
            }
            myTurtleStats.append(TUR_HEAD + aTurtle.getHeading() + StrConstant.NEWLINE);
            myTurtleStats.append(TUR_ACTIVE + aTurtle.getActive() + StrConstant.NEWLINE);
            myTurtleStats.append(StrConstant.NEWLINE);
            turtleID++;
        }
        return myTurtleStats.toString();
    }

    public void updateTurtle () {
        int turtleID = 0;
        setupValues();
        graphics.clearRect(GRAPHIC_START, GRAPHIC_START, GRAPHIC_END, GRAPHIC_END);
        graphics.fillRect(GRAPHIC_START, GRAPHIC_START, GRAPHIC_END, GRAPHIC_END);
        for (Turtle aturtle : myTurtleList) {
            xCoor[turtleID] = aturtle.getEndXCor();
            yCoor[turtleID] = aturtle.getEndYCor();
            head[turtleID] = aturtle.getHeading();
            visib[turtleID] = aturtle.getVisibility();
            turtleID++;
        }
        turtleID = 0;
        for (Turtle aturtle : myTurtleList) {
            if (visib[turtleID] == 1) {
                graphics.drawImage(aturtle.getTurtleImage(), xCoor[turtleID], yCoor[turtleID]);
            }
            rotate(graphics, head[turtleID], calculatePivotX(aturtle), calculatePivotY(aturtle));
            turtleID++;
        }
    }

    private void setupValues () {
        xCoor = new double[myTurtleList.size()];
        yCoor = new double[myTurtleList.size()];
        head = new double[myTurtleList.size()];
        visib = new int[myTurtleList.size()];
    }

    private void rotate (GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    private double calculatePivotX (Turtle turtle) {
        return (turtle.getStartXCor() + (turtle.getTurtleImage().getWidth() / 2));
    }

    private double calculatePivotY (Turtle turtle) {
        return (turtle.getStartYCor() + (turtle.getTurtleImage().getHeight() / 2));
    }
}
