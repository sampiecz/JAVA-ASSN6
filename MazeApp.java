import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.EventQueue;
import javax.swing.WindowConstants;


public class MazeApp extends JFrame implements ActionListener
{
	// This class represents the entire application It will contain the bulk of the
	// user interface and will be responsible for handling events from the user. It
	// should extend JFrame.
    private File file;
    int returnValue;
    String currentLine;

	// A MazePanel object.
	MazePanel myMazePanel = new MazePanel();

	// Three JButton objects to represent the “Open Maze File”, “Solve Maze”, and 
	// “Clear Solution” buttons.
	JButton openButton = new JButton("Open Maze File");
	JButton solveButton = new JButton("Solve Maze");
	JButton clearButton = new JButton("Clear Solution");

	// A JFileChooser object which will be used to choose an input file.
	JFileChooser fileChooser = new JFileChooser();


	// A constructor that sets the title on the application’s title bar.
	public MazeApp()
	{
		super("Maze App");
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

	// Creates an instance of MazeApp and then uses it to call method(s) to set up the 
	// user interface elements (e.g., createAndShowGUI()). Remember that Swing is not 
	// thread-safe, so your Swing objects must be created on the Event Dispatch Thread.
	// See Assignment 0, Part 2 for an example of the code pattern that is typically used to do this.
    //
    public static void main(String[] args)
    {
		EventQueue.invokeLater(() ->
		{
            MazeApp myMazeApp = new MazeApp();
            myMazeApp.createAndShowGUI();
		});
    }

	private void createAndShowGUI()
	{
		initComponents();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

    private void initComponents()
    {
        setLayout(new BorderLayout());
        JPanel southPanel = new JPanel(); 
        southPanel.setLayout(new FlowLayout());
        fileChooser.setCurrentDirectory(new File ("."));

        openButton.addActionListener(this);
        southPanel.add(openButton);

        solveButton.addActionListener(this);
        solveButton.setEnabled(false);
        southPanel.add(solveButton);

        clearButton.addActionListener(this);
        clearButton.setEnabled(false);
        southPanel.add(clearButton);

        add(myMazePanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

    }

    @Override
	public void actionPerformed(ActionEvent event)
	{ 

		// Store users input 
		String input = event.getActionCommand();
			
		if(input.equals("Open Maze File"))
		{
            returnValue = fileChooser.showOpenDialog(null);
            if (returnValue == JFileChooser.APPROVE_OPTION)
            {
                file = fileChooser.getSelectedFile();
                try
                {
                    myMazePanel.readMaze(file);
                }
                catch (FileNotFoundException error)
                {
                    System.out.println(error);
                }
            }

            solveButton.setEnabled(true);

        }
        else if(input.equals("Solve Maze"))
		{
            myMazePanel.solveMaze();
            clearButton.setEnabled(true);
            solveButton.setEnabled(false);
        }
        else if(input.equals("Clear Solution"))
		{
            myMazePanel.clearMazePath();
            solveButton.setEnabled(true);
            clearButton.setEnabled(false);

        }

    }
		
}
