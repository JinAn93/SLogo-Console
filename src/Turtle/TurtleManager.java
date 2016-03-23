package Turtle;

import java.util.ArrayList;
import java.util.List;


/**
 * TurtleManager serves to work with both single and multiple turtles.
 *
 * @author Jin An
 *
 */
public class TurtleManager {

    private List<SingleTurtle> myTurtles;

    public TurtleManager (List<SingleTurtle> turtles) {
        myTurtles = turtles;
    }

    /**
     * findActiveTurtles method serves to go through turtle list and saves index of active turtles.
     *
     * @return
     */
    public List<Integer> findActiveTurtles () {
        List<Integer> activeIndex = new ArrayList<Integer>();
        for (int i = 0; i < myTurtles.size(); i++) {
            if (myTurtles.get(i).getActive()) {
                activeIndex.add(i);
            }
        }
        return activeIndex;
    }
}
