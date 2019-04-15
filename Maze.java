import java.awt.Graphics;
import java.lang.Exception;
import java.util.NoSuchElementException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class Maze 
{
	// Symbolic constants for the maximum number of rows and columns in the maze. 
    // The sample program uses the value 30 for both of these
	public static final int maxRow = 30;
	public static final int maxColumn = 30;

	// Four integers to store the row and column of the start and end of the maze.
	private int startRow, startColumn, endRow, endColumn, numberOfRows, numberOfColumns;

	// A reference to a two-dimensional array of MazeSquare objects.
	private MazeSquare[][] myMazeSquares;

    public Maze()
    {
        this.startRow = 0;
        this.startColumn = 0; 
        this.endRow = 0;
        this.endColumn = 0;
        this.numberOfRows = 0;
        this.numberOfColumns = 0;
    } 



	// An accessor method to return the actual number of rows in the maze.
	public int getNumberOfRows()
	{
		return this.numberOfRows;
	}
	
	// Setter
	public void setNumberOfRows(int numberOfRows)
	{
		this.numberOfRows = numberOfRows;
	}

	// An accessor method to return the actual number of columns in the maze.
	public int getNumberOfColumns()
	{
		return this.numberOfColumns;
	}

	public void setNumberOfColumns(int numberOfColumns)
	{
		this.numberOfColumns = numberOfColumns;
	}

	public void setStartRow(int startRow)
	{
		this.startRow = startRow;
	}

	public int getStartRow()
	{
		return this.startRow;
	}

	public void setStartColumn(int startColumn)
	{
		this.startColumn = startColumn;
	}

	public int getStartColumn()
	{
		return this.startColumn;
	}

	public void setEndRow(int endRow)
	{
		this.endRow = endRow;
	}

	public int getEndRow()
	{
		return this.endRow;
	}

	public void setEndColumn(int endColumn)
	{
		this.endColumn = endColumn;
	}

	public int getEndColumn()
	{
		return this.endColumn;
	}


	// This method will be called to read an input file of maze data 
	// (see Input below for a description of the file format). It will allocate
	// the maze array storage and create all of the MazeSquare objects. It will
	// also save the row and column coordinates of the start and end of the maze
	// when they are encountered in the input.
	public void readMaze(File fileName) throws NumberFormatException, NoSuchElementException, FileNotFoundException
	{
		Scanner inFile = new Scanner(fileName);
		String inputLine = "";

		inputLine = inFile.nextLine();
		setNumberOfRows(Integer.parseInt(inputLine));  

		inputLine = inFile.nextLine();
		setNumberOfColumns(Integer.parseInt(inputLine));

		myMazeSquares = new MazeSquare[getNumberOfRows()][getNumberOfColumns()];

		while (inFile.hasNextLine())
		{     
			// represents which row 
			for (int i = 0; i < getNumberOfRows(); i++)
			{
				inputLine = inFile.nextLine();
				// represents which column 
				for (int j = 0; j < getNumberOfColumns(); j++)
				{
					// Wall square
					if (inputLine.charAt(j) == '#')
					{
						MazeSquare tempSquare = new MazeSquare(i, j, MazeSquare.SquareType.wall);
						myMazeSquares[i][j] = tempSquare;           
					}
					// Space square
					else
					{
						// Starting space
						if (inputLine.charAt(j) == 's')
						{
							setStartRow(i);
							setStartColumn(j);
						}
						// Ending space
						if (inputLine.charAt(j) == 'e')
						{
							setEndRow(i);
							setEndColumn(j);
						}

						MazeSquare tempSquare = new MazeSquare(i, j, MazeSquare.SquareType.space);
						myMazeSquares[i][j] = tempSquare;
					}  

				}            
			}

		}

	}	

	// This method will be called to clear the maze solution. It should call
	// clearSquare() for every MazeSquare in the maze array.
	public void clearMazePath()
	{
		for(MazeSquare[] mazeSquares : myMazeSquares)
		{
            for(MazeSquare mazeSquare : mazeSquares) 
            {
                mazeSquare.clearSquare();
            }
		}
	}

	// This method will be called to draw the maze. The parameters startX and
	// startY are the x and y coordinates of the upper left corner of the maze.
	// The method should call drawSquare() for every MazeSquare in the maze array.
	void drawMaze(Graphics g, int startX, int startY)
	{
        for(MazeSquare[] mazeSquares : myMazeSquares)
        {
            for(MazeSquare mazeSquare : mazeSquares) 
            {
                mazeSquare.drawSquare(g, startX, startY);
            }
        }
	}

	// This non-recursive method will call the recursive solveMaze() method described
	// below, passing it the row and column of the start of the maze. It should return
	// the value returned by the recursive method.
	public boolean solveMaze()
	{
		return solveMaze(getStartRow(), getStartColumn());
	}

	// This private recursive method attempts to solve the maze. It returns true if a
	// solution is found and false if not.
	private boolean solveMaze(int row, int column)
	{
		// The method will try to find a solution for the maze by attempting to move north,
		// south, east, and west. If a move reaches the end of the maze, a valid path has been
		// found, and the squares along that path will have their type changed from SPACE to PATH
		// as the algorithm backtracks. If a move hits a wall or ends up retracing its steps, that
		// is not a valid path. If no valid path is found, the eventual return value will be false.

		// Here is the recursive logic for this method, which has three base cases and four recursive cases:

		// If we’ve reached the end of the maze, we have solved it.
        if (row == getEndRow() && column == getEndColumn()) 
        {
            myMazeSquares[row][column].setToPath();
            return true;
        }

		// If we hit a wall or we've already visited this square, this square is
		// not part of a valid path to the end of the maze.
        if (this.myMazeSquares[row][column].isWall() || this.myMazeSquares[row][column].visited)
        {
            return false;  
        }
			
		this.myMazeSquares[row][column].markVisited(); 

		// If we're not on the top edge of the maze, try to go north.
		if (row != 0) 
		{
		  if (solveMaze(row -1, column)) 
		  {
			// There is a valid path to the north.
            this.myMazeSquares[row][column].setToPath();
			return true;
		  }
		}

		// If we're not on the bottom edge of the maze, try to go south.
		if (row != getNumberOfRows()-1) 
		{
		  if (solveMaze(row + 1, column)) 
		  {
			// There is a valid path to the south.
			this.myMazeSquares[row][column].setToPath();
			return true;
		  }
		}

		// If we're not on the left edge of the maze, try to go west.
		if (column != 0) 
		{
		  if (solveMaze(row, column -1)) 
		  {
			// There is a valid path to the west.
			this.myMazeSquares[row][column].setToPath();
			return true;
          }
		}

		// If we're not on the right edge of the maze, try to go east.
		if (column != getNumberOfColumns()-1) 
		{
		  if (solveMaze(row, column + 1)) 
		  {
			// There is a valid path to the east.
			this.myMazeSquares[row][column].setToPath();
			return true;
		  }
		}
		// If we haven't returned true by this point, no valid path through the 
		// maze has been found.
		return false;
	}

}
