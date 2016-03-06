package fxMenu;

import java.util.ResourceBundle;
import fxFrontend.Display;
import Main.Turtle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuBar;

public class SlogoMenuCreator {
	
	private MenuBar myMenu;
    private CreateBackgroundColorMenu createMenu;
    private CreateTurtleSelectionMenu myTurtleImages;
    private CreatePenColorMenu myPenMenu;
    private CreatePenPropertiesMenu myPenPropertiesMenu;
    private ChooseLanguageMenu myLanguageMenu;
    
    private Turtle myTurtle; 
    private GraphicsContext myGraphics;
    private GraphicsContext myLineGraphics;
    private Display myDisplay;
    
    public SlogoMenuCreator(Turtle turt, GraphicsContext toChange, GraphicsContext myLines, Display useDisplay){
    	myMenu = new MenuBar();
    	myTurtle = turt;
    	myGraphics = myLines;
    	myLineGraphics = myLines;
    	myDisplay = useDisplay;
    	
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


    }
    public MenuBar getMenuBar(){
    	return myMenu;
    }

}
