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
    private CreateLanguageMenu myLanguageMenu;
    private CreateInactiveTurtles myInactiveTurtles;
    
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
        colorBackGroundMenu();        
        penColorMenu();
        languageMenu();
        turtleMenu();
    }
    
	private void turtleMenu() {
		myInactiveTurtles = new CreateInactiveTurtles(myInactiveList, myNumTurtles);
        myMenu.getMenus().add(myInactiveTurtles.getMenu());
	}
	
	private void languageMenu() {
		myLanguageMenu = new CreateLanguageMenu(myDisplay);
        myMenu.getMenus().add(myLanguageMenu.getMenu());
	}
	
	private void penColorMenu() {
		myPenMenu = new CreatePenColorMenu(myLineGraphics);
        myMenu.getMenus().add(myPenMenu.getPenMenu());
        myPenPropertiesMenu = new CreatePenPropertiesMenu(myTurtle);
        myMenu.getMenus().add(myPenPropertiesMenu.getPenUpMenu());
	}
	
	private void colorBackGroundMenu() {
		createMenu = new CreateBackgroundColorMenu(myGraphics, myLineGraphics);
        myMenu.getMenus().add(createMenu.getColorMenu());
        myTurtleImages = new CreateTurtleSelectionMenu(myTurtle);
        myMenu.getMenus().add(myTurtleImages.getImageMenu());
	}
	
    public MenuBar getMenuBar(){
    	return myMenu;
    }

}
