package Turtle;

public class TurtlePen {
    private String myPenColor;
    private double myPenSize;
    private int myIsPenDown;
    
    public TurtlePen (String color, double penSize, int isPenDown){
        myPenColor = color;
        myPenSize = penSize;
        myIsPenDown = isPenDown;
    }
        
    public String getPenColor (){
        return myPenColor;
    }
    
    public double getPenSize () {
        return myPenSize;
    }
    
    public int IsPenDown() {
        return myIsPenDown;
    }
    
    public void setPenColor (String color) {
        myPenColor = color;
    }
    
    public void setPenSize (double penSize){
        myPenSize = penSize;
    }
    
    public void setPen(int PenupOrDown){
        myIsPenDown = PenupOrDown;
    }
}
