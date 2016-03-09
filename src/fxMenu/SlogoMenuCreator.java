package fxMenu;

import java.util.List;
import java.util.ResourceBundle;
import fxFrontend.Display;
import Turtle.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuBar;

public class SlogoMenuCreator {
	
	private MenuBar myMenu;
    private CreateBackgroundColorMenu createMenu;
    private CreateTurtleSelectionMenu myTurtleImages;
    private CreatePenColorMenu myPenMenu;
    private CreatePenPropertiesMenu myPenPropertiesMenu;
    private ChooseLanguageMenu myLanguageMenu;
    private ChooseInactiveTurtles myInactiveTurtles;
    
    private List<SingleTurtle> myTurtle; 
    private GraphicsContext myGraphics;
    private GraphicsContext myLineGraphics;
    private Display myDisplay;
    private List<Integer> myInactiveList;
    private List<SingleTurtle> myNumTurtles;
    
    public SlogoMenuCreator(List<SingleTurtle> turt, GraphicsContext toChange, GraphicsContext myLines, Display useDisplay, List<Integer> myInactives, List<SingleTurtle> myTurtles){
    	myMenu = new MenuBar();
    	myTurtle = turt;
    	myGraphics = myLines;
    	myLineGraphics = myLines;
    	myDisplay = useDisplay;
    	myInactiveList = myInactives;
    	myNumTurtles = myTurtles;
    	
        createMenu = new CreateBackgroundColorMenu(myGraphics, myLineGraphics);
        myMenu.getMenus().add(createMenu.getColorMenu());
        myTurtleImages = new CreateTurtleSelectionMenu(myTurtle);
        myMenu.getMenus().add(myTurtleImages.getImageMenu());
        
        myPenMenu = new CreatePenColorMenu(myLineGraphics);
        myMenu.getMenus().add(myPenMenu.getPenMenu());
        myPenPropertiesMenu = new CreatePenPropertiesMenu(myTurtle);
        myMenu.getMenus().add(myPenPropertiesMenu.getPenUpMenu());
        
        myLanguageMenu = new ChooseLanguageMenu(myDisplay);
        myMenu.getMenus().add(myLanguageMenu.getMenu());
        
        myInactiveTurtles = new ChooseInactiveTurtles(myInactiveList, myNumTurtles);
        myMenu.getMenus().add(myInactiveTurtles.getMenu());


    }
    public MenuBar getMenuBar(){
    	return myMenu;
    }

}
