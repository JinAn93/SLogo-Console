package fxMenu;

import Main.Turtle;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.MenuBar;

public class SlogoMenuCreator {
	
	private MenuBar myMenu;
    private CreateBackgroundColorMenu createMenu;
    private CreateTurtleSelectionMenu myTurtleImages;
    private CreatePenColorMenu myPenMenu;
    private CreatePenPropertiesMenu myPenPropertiesMenu;
    
    private Turtle myTurtle; //createturtleselectionmenu and createpenpropertiesmenu
    private GraphicsContext myGraphics; // createPenColorMenu
    private GraphicsContext myLineGraphics;
    
    public SlogoMenuCreator(Turtle turt, GraphicsContext toChange, GraphicsContext myLines){
    	myMenu = new MenuBar();
    	myTurtle = turt;
    	myGraphics = myLines;
    	myLineGraphics = myLines;
    	
        createMenu = new CreateBackgroundColorMenu(myGraphics, myLineGraphics);
        myMenu.getMenus().add(createMenu.getColorMenu());
        myTurtleImages = new CreateTurtleSelectionMenu(myTurtle);
        myMenu.getMenus().add(myTurtleImages.getImageMenu());
        
        myPenMenu = new CreatePenColorMenu(myLineGraphics);
        myMenu.getMenus().add(myPenMenu.getPenMenu());
        myPenPropertiesMenu = new CreatePenPropertiesMenu(myTurtle);
        myMenu.getMenus().add(myPenPropertiesMenu.getPenUpMenu());


    }
    public MenuBar getMenuBar(){
    	return myMenu;
    }

}
