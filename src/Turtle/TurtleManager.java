package Turtle;

import java.util.ArrayList;
import java.util.List;


public class TurtleManager {

    private List<SingleTurtle> myTurtles;

    public TurtleManager (List<SingleTurtle> turtles) {
        myTurtles = turtles;
    }

    public List<Integer> findActiveTurtles(){
        List<Integer> activeIndex = new ArrayList<Integer>();
        System.out.println("Let's look for active Turtles!");
        for(int i=0; i<myTurtles.size(); i++){
            if(myTurtles.get(i).getActive())
                activeIndex.add(i);
        }
        return activeIndex;
    }
}
