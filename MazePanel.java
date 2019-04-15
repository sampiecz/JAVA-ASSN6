import java.io.File; 
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Color;
import java.lang.Exception;
import javax.swing.JPanel;

public class MazePanel extends JPanel
{
	// An object reference to a Maze object. This should
	// be initialized to null.
	private Maze myMaze;

	// A pair of Boolean variables, solutionAttempted and solutionFound, 
	// both of which should be initialized to false.
	private boolean solutionAttempted = false;
	private boolean solutionFound = false;


	// This method will be called to read an input file of maze data.
	// It should set solutionAttempted and solutionFound to false, create a new Maze object, 
	// use that object to call the readMaze() method of the Maze class, and then call 
	// repaint() to draw the new maze. Any exceptions thrown by the readMaze() method of 
	// the Maze class can simply be rethrown by this method.
	public void readMaze(File inputFile) throws NumberFormatException, NoSuchElementException, FileNotFoundException
    {
        this.solutionAttempted = false;
        this.solutionFound = false;

        myMaze = new Maze();

        myMaze.readMaze(inputFile);
        repaint();
    }

	// This method will be called to clear a maze solution. It should set solutionAttempted
	// and solutionFound to false, call the clearMazePath() method for the Maze object data
	// member, and then call repaint() to redraw the maze.
	public void clearMazePath()
	{
        this.solutionAttempted = false;
        this.solutionFound = false;
        myMaze.clearMazePath();
        repaint();
    }


	// This method will be called to try to solve a maze. It should set solutionAttempted 
	// to true, set solutionFound to result of calling the non-recursive solveMaze() method
	// for the Maze object data member, and then call repaint() to redraw the maze.
	public void solveMaze()
	{
        this.solutionAttempted = true;
        this.solutionFound = myMaze.solveMaze();
        repaint();
	}

	// Override this method to draw the maze on the panel’s surface (if it exists) and 
	// potentially a message about whether or not the maze has been successfully solved.
    @Override
	protected void paintComponent(Graphics g)
	{
		// Logic for this method might look something like this:
		// 1. Call the superclass version of paintComponent() to draw the panel.
        super.paintComponent(g);
		// 2. Get the dimensions of the panel by calling getSize().
        Dimension size = getSize();
		// 3. Draw a filled rectangle in LIGHT_GRAY over the entire panel to erase whatever
		// was previously drawn there.
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, size.width, size.height);
		// 4. If a Maze object exists (i.e., its object reference is not null), compute 
		// the x and y coordinates of its upper left corner so that the maze is centered in
		// the panel. Then call the Maze object’s drawMaze() method to draw it.
        if (myMaze != null)
        {
            myMaze.drawMaze(g, 20, 20);
        }
		// 5. If both solutionAttempted and solutionFound are true, draw a “Solved!” message
		// in the lower part of the panel. Otherwise, if solutionAttempted is true but solutionFound
		// is false, draw a “No solution exists for this maze.” message in the lower part of the panel.
		// In both cases, the message should be horizontally centered, with its baseline ~ 20 pixels
		// above the bottom of the panel.

        if (solutionAttempted && solutionFound)
        {
            g.drawString("Maze solved", 475, 500);
        }
        else if (solutionAttempted)
        {
            g.drawString("No solution exists.", 475, 500);
        }
		// (If neither Boolean variable is true, the “Solve Maze” button has not been pressed 
		// yet so no message needs to be displayed.)

		// You may want to override the methods getPreferredSize() and/or getMinimumSize() to ensure
		// that your panel has the appropriate dimensions to accommodate a maze of the maximum possible
		// number of rows and columns. Since the panel does not contain any other components, its
		// preferred size will likely default to an unacceptably small value.

		// There are other ways to set the dimensions of the panel, such as setting its size when
		// its created or setting the size of the enclosing frame.

	}

}
