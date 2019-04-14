public class MazeApp extends JFrame
{
	// This class represents the entire application It will contain the bulk of the
	// user interface and will be responsible for handling events from the user. It
	// should extend JFrame.

	// A MazePanel object.
	MazePanel myMazePanel;

	// Three JButton objects to represent the “Open Maze File”, “Solve Maze”, and 
	// “Clear Solution” buttons.
	JButton openButton = new JButton("Open Maze File");
	JButton solveButton = new JButton("Solve Maze");
	JButton clearButton = new JButton("Clear Solution");

	// A JFileChooser object which will be used to choose an input file.
	JFileChooser fileChooser = new JFileChooser();

	// Creates an instance of MazeApp and then uses it to call method(s) to set up the 
	// user interface elements (e.g., createAndShowGUI()). Remember that Swing is not 
	// thread-safe, so your Swing objects must be created on the Event Dispatch Thread.
	// See Assignment 0, Part 2 for an example of the code pattern that is typically used to do this.
	public void main()
	{
		MazeApp myMazeApp = new MazeApp();

		myMazeApp.createAndShowGUI();
	}

	// A constructor that sets the title on the application’s title bar.
	public MazeApp()
	{
		super();
	}

	// Handles ActionEvents from the buttons. It’s entirely up to you whether you have
	// a single version of this method that handles events from all three buttons or
	// whether you create a separate handler for each button.
	public void actionPerformed()
	{
		//In general terms, here’s what the handler for each button should do:

		// “Open Maze File” button
		// Call the showOpenDialog() method of the JFileChooser object to allow the user
		// to choose an input file of maze data.
		// Call the readMaze() method for the MazePanel object to read the chosen file.
		// Enable the “Solve Maze” button.
		// Disable the “Clear Solution” button.
		// readMaze() may throw one of several possible exceptions; if it does, display an
		// appropriate error message using JOptionPane.showMessageDialog() as in Assignment 4.

		// “Solve Maze” button
		// Call the solveMaze() method for the MazePanel object.
		// Disable the “Solve Maze” button.
		// Enable the “Clear Solution” button.

		// “Clear Solution” button
		// Call the clearMazePath() method for the MazePanel object.
		// Enable the “Solve Maze” button.
		// Disable the “Clear Solution” button.

	}

}
