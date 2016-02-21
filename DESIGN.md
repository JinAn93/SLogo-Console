Net IDs: dwy3, cl305, su26, sa190

# Introduction

We are creating an IDE which focuses on helping users to experiment with and manage expressions, building up complex expressions from previously entered ones and keeping the visual representation of the turtle appropriately updated. As our primary design goals, we are creating a graphic user interface that allows users to input commands and track the movements of turtle themselves. Secondly, we will be creating four distinct APIs that are concise, powerful, extendable, and  difficult to mise use to other programmers. Following the open-closed principle, we will be creating APIs (public methods) that are robust enough that no one needs to modify them. On the other hand, if other programmers want to implement more features, they will be able to add public methods to fulfill their goals. The project is divided into two sections - backend and frontend. Frontend receives the input from users and transfer appropriately to the backend where it is parsed and transferred the results to the front end to be displayed.

# Design Overview

The program is divided into frontend and backend. Frontend involves display, userinterface, and window. Backend involves command decoding and command execution. The userinterface class creates button, which interacts with main backend class. Then, the main back end class will call check error method in commandDecoder class and execute command method in abstract commandExecutor class. Then, frontend will access the output class which contains the printable outputs and instance of grid. The four APIs we intend to create are: User Interaction with Display(frontend internal) Interaction with Backend where it reads the user input and pass down to backend(frontend external), command decoding(backend internal), and passing the output object to front-end (backend external)

# User Interface

Main Display Window - Will display the turtle and display the movement of the turtle as well as the user adds commands. This window will primarily be used for turtle commands and displaying the result of turtle commands.
Console - If the user decides to perform a non-turtle command such as arithmetic calculation, the console will output the results of those calculations. Additionally, the error messages (bad input data, bad commands, etc.)  will also be displayed through the console.
Display History - This section will display the list of VALID commands that the user has input. Each valid command that the user has input will be displayed in a list style format here and the user will be able to click on old commands in the list to repeat those commands.
Variables View - This section will display the current variables that the user has input and display it in the form of a 2 column table. The first column will display the variable name and the second column will display the current value saved in that variable.
Input Lines/Submit - This will be the means of input for the user. The user will type in a command into the input lines text box, then click the submit button to submit the command for processing and display.
Toolbar Dropdown (not pictured) - This toolbar will contain options that a normal toolbar dropdown menu would, allowing the user to start a new project, etc.

# API Details 

> Backend Internal API:

In MainBackEnd class, commandDecoder class, which contains parseCommand( ), checkError( ), and cacheCommand( ) methods will be instantiated. During the command decoding process, the API will parse the command. The more details will be covered in the future. However, the rough idea is that we will split the string into lines. We will eliminate the ones with “#” and the empty ones. Then, we will store the commands with their appropriate information such as pixels, degrees, positions, expressions, and etc. checkError method reads the information and check errors. If there exists an error, the method will return an integer that specifies what kind of error it is to userinterface class. CacheCommand method will store the error-free commands so that if the same command is called, it can execute it without checking error. Obviously, we will throw exceptions in our checkError method so that they can be handled appropriately. Because command decoding only requires the string, it does not require any instance variables and private methods. 

> Backend External API: 

This API will provide communication with the frontend part of the code. Using this API, the frontend clients will be able to obtain the details of all the objects and variables created during that instance of the program (e.g. turtles, variables, history, etc.) by calling the appropriate methods of the API. In the same way, they will also be able to obtain the results of the commands and expressions entered (e.g. 3 + 5 will be 5) so that they may printed to the screen. 

> Frontend Internal API: 

The internal frontend API will provide the communication between frontend elements, mainly changing how elements of the GUI change and will include the Console, Window, and UI classes. This internal frontend API will provide methods that change the GUI elements. Methods include updating the graphics, changing the language, updating console, updating the variable table, and updating the history of commands. 

> Frontend External API:

The external API will involve sending the user’s input command to the backend so that it may be processed and potentially executed. The main external frontend class will be the UI class because it contains methods to not only create the text boxes where the user types in their command, but also the method to create the send button that when clicked on, will send the command (in the form of a String) to the backend for processing. 

# API Example Code

Command: ‘fd 50’

User will input the above command into the appropriate text box and click on the “Submit” button, which will call the getCommandInput() method in the UI class. This method will take the input as a String and then pass it into the backend’s CommandDecode class where it will run the checkError(String command) method on the command to determine its validity. If valid, the parseCommand(String command) method will be called on the command to determine all of the command’s parts and parameters and will then be passed into the ComandExecuter class where it will run the moveTurtle(String direction, int distance) method. In this case, the turtle will move 50 in the forward direction. This information will be encoded into an Output object where it will passed back into the FrontEnd’s Window class where the update(Output output) will determine the data contained in the Output object to appropriately update the GUI. Things that will be updated are the turtle’s position, the console will output a message saying command complete, and the command history will be updated to say ‘fd 50’ as one of valid commands executed.

> Frontend

David

Handle the display and button inputs and is responsible for sending the command that the user inputs to the backend for processing. 

Cody

Handle the processing of the Output object that is passed into the frontend from the backend and will read the values contained in the Output object to appropriately update the GUI.   

> Backend

Jin

Decode the command and save it into list of command objects. check eror and cache commands.

Sarp

With the list of command objects, execute the appropriate commands and edit the output object for the frontend to use.

	public interface ExternalAPI{
		public void getTurtleXCor(String turtleName);

		public void getTurtleYCor(String turtleName);
	}

# Design Considerations 

We discussed not having the results of arithmetic operations appear in the console, but instead appear right under the arithmetic command input in the input box. We ultimately decided against this because keeping outputs in the same text box where we take in inputs could complicate our design. In addition, displaying the results of arithmetic operations in console allows the results to be wiped once a new command is taken in.
We discussed the data structure we will be using to save the list of commands and relevant information. We came up with two options which were using list queue to store the command object that contains the command name and its required expressions. The other option was to use hashmap to store the information. What’s good about list queue is that it is easy to keep track of the order of the commands. An advantage for hashmap is that it does not need to instantiate new class to store expressions. We decided to use arraylist queue because making a separate command class would give the progammers more flexibility to extend its features. 

# Team Responsibilities

David Yan: Handling UIs and send input to backend(Display, UI Class)

Cody Li: Receive output from backend and update the display (Display, UI Class)

Jin An: MainBackEnd, Turtle, Command Decode

Sarp Uner: CommandExecutor, Command, Grid

Even though we have designated our responsibilities, we will be meeting together as frequently as possible to help each other in solving the more difficult challenges and make the design decision.

# Plan diagram: 