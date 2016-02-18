#Cell Society Team 2 API Exercise
#David Yan
#Jin An
#Sarp Uner
#Cody Li 
=======

###API Critique
**Critique of Cell Society Team 24**

######Cell class
> - public Color getColor() - Internal API
> - public void setColor(Color c) - External API
> - public int getX() - External API
> - public int getY() - External API

######RuleEnforcer class
> - public ArrayList<Cell> getNeighbors(Cell check, boolean wrap) - Internal API
> - public int wrapCor(int cor) - Internal API
> - public ArrayList<Cell> getAdjNeighbors(Cell check, boolean wrap) - Internal API
> - public void createCopyGrid() - Internal API

######FileErrorCheck class
> - public void validateSim() - Internal API
> - public void fillParam() - Internal API
> - public void validateParams() - Internal API

######FileReader Class
> - public FileReader(File f) throws SAXException, IOException, ParserConfigurationException - External API
> - public void validateSim() - External API
> - public String readProperty(String property) - External API 
> - public int[] populateCoorArray(String vals) - External API  

######Gridinitializer class
> - public abstract void makeGrid() - Internal API

######Simulator class
> - public void step() - External API
> - public void start() - External API
> - public void adjustSpeed(double ratio) - External API
> - public void stop() - External API
> - public void resume() - External API
> - public void byStep() - External API

######Summary
> - The simulation portion of Cell Society consisted of the purely internal backend class of RuleEnforcer, and the mixed internal and external frontend/backend classes of Grid, Cell, and GridInitializer. The Grid and Cell class define the basic data objects used to store information of the simulation as well as display portions of the UI to the user. 
> - The configuration portion of Cell Society is almost completely internal and consists of the FileReader the FileErrorCheck and FileReader classes and is responsible for reading the XML file, determining the validity of values in the XML file, and then passing the values into the appropriate classes that call for it. 
> - The visualization portion of Cell Society is consisted almost purely of external frontend classes of Simulation and Control. The purpose of these classes are to visually display the simulation as well as provide the user with controls to manipulate the simulation .


###SLogo Architecture Design
> - When does parsing need to take place and what does it need to start properly? Parsing will start on the front end once the user types in a command to a dialog box and hits enter. The command will be sent to the backend for interpretation, and according to the command, the back end will send back the instruction to the front end.
> - What is the result of parsing and who receives it? The result of parsing will be the evaluation of the command entered, and the backend will interpret this command and send back information to the front end.
> - When are errors detected and how are they reported? Detecting the actual style of the input and actually look at how the input string is organized (ex. is a minus sign right next to a value?). In terms of incorrect commands, there should only be one command then values after it, and if it is not in this form we will throw an error. We will keep all our valid commands in a map to check whether the user has input a correct command or not.
> - What do commands know, when do they know it, and how do they get it? The command would need to know the current position of the turtle so that when the user inputs a new command the commands will know where to move the turtle. The command would also be able to keep track of variables and their values. The commands would get this information from a class that keeps track of these changing variables.
> - How is the GUI updated after a command has completed execution? The turtle display screen would be updated with new positions of the turtle and any new lines that may be drawn. If the user has input an arithmetic operation, the console would output the result of the arithmetic. 

###Frontend Design
> - Display
  * Functions similar to a "main" class where it calls the neccesary "componenet" classes to create the general GUI. 
  * Creates the stage, calls other classes to populate everything (window, buttons, console, etc.)
   *  void update()
  > - UI 
    * Creates all of the neccessary buttons for the user to interact with. 
    * Also creates the "dialogue box" where the user can type in commands. 
    * Toolbar of things that users can click on (change preferences for languages). 
     * void createToolbar
     * void createTextBox
  > - Window
    * Creates the window that displays the turtle graphics.  
    * Displays the previous commands
    * Displays a table with variable values 
     * void createGraphicsWindows
     * void createVarTable
     * void createPrevCommands
  > - Console
    * Displays the console that outputs information such as arithmetic and boolean operations.  
     * void createConsole
     * void updateConsole(String command) - Maybe use an ArrayList due store all commands and then iterate through to update        console 
