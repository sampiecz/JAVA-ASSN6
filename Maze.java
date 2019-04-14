public class Maze 
{
	// Symbolic constants for the maximum number of rows and columns in the maze. The sample program uses the value 30 for both of these
	int maxRow = 30;
	int maxColumn = 30;

	// Four integers to store the row and column of the start and end of the maze.
	int startRow, startColumn, endRow, endColumn;

	// TODO
	// A reference to a two-dimensional array of MazeSquare objects.
	MazeSquare myMazeSquares;

	// An accessor method to return the actual number of rows in the maze.
	public int getRows()
	{
		return maxRows; 
	}

	// An accessor method to return the actual number of columns in the maze.
	public int getColumns()
	{
		return maxColumns; 
	}


	// This method will be called to read an input file of maze data 
	// (see Input below for a description of the file format). It will allocate
	// the maze array storage and create all of the MazeSquare objects. It will
	// also save the row and column coordinates of the start and end of the maze
	// when they are encountered in the input.
	void readMaze(File inputFile)
	{

		// This method could throw NumberFormatException or NoSuchElementException
		// if the input file is not in the correct format, or FileNotFoundException
		// if the file can’t be opened.
		try
		{
		}
		catch (Exception e)
		{
		}
	}


	// This method will be called to clear the maze solution. It should call
	// clearSquare() for every MazeSquare in the maze array.
	public void clearMazePath()
	{
		for(MazeSquare mazeSquare : myMazeSquares)
		{
			mazeSquare.clearSquare();
		}
	}

	// This method will be called to draw the maze. The parameters startX and
	// startY are the x and y coordinates of the upper left corner of the maze.
	// The method should call drawSquare() for every MazeSquare in the maze array.
	void drawMaze(Graphics g, int startX, int startY)
	{
	}

	// This non-recursive method will call the recursive solveMaze() method described
	// below, passing it the row and column of the start of the maze. It should return
	// the value returned by the recursive method.
	boolean solveMaze()
	{
		return solveMaze(startRow, startColumn);
	}

	// This private recursive method attempts to solve the maze. It returns true if a
	// solution is found and false if not.
	boolean solveMaze(int row, int column)
	{
		// The method will try to find a solution for the maze by attempting to move north,
		// south, east, and west. If a move reaches the end of the maze, a valid path has been
		// found, and the squares along that path will have their type changed from SPACE to PATH
		// as the algorithm backtracks. If a move hits a wall or ends up retracing its steps, that
		// is not a valid path. If no valid path is found, the eventual return value will be false.

		// Here is the recursive logic for this method, which has three base cases and four recursive cases:

		// If we’ve reached the end of the maze, we have solved it.
		if (the row and column of this MazeSquare is the end of the maze) 
		{
			 Call setToPath() for this MazeSquare
		  return true;
		}

		// If we hit a wall or we've already visited this square, this square is
		// not part of a valid path to the end of the maze.

		if (this MazeSquare is a wall or has been visited)
		  return false;  
			
		Mark this MazeSquare as visited

		// If we're not on the top edge of the maze, try to go north.
		if (row is not the first row of the maze) 
		{
		  if (call solveMaze() with row-1 and col as arguments) 
		  {
			// There is a valid path to the north.
					Call setToPath() for this MazeSquare
			return true;
		  }
		}

		// If we're not on the bottom edge of the maze, try to go south.
		if (row is not the last row of the maze) 
		{
		  if (call solveMaze() with row+1 and col as arguments) 
		  {
			// There is a valid path to the south.
				 Call setToPath() for this MazeSquare
			return true;
		  }
		}

		// If we're not on the left edge of the maze, try to go west.
		if (col is not the first column of the maze) 
		{
		  if (call solveMaze() with row and col-1 as arguments) 
		  {
			// There is a valid path to the west.
				 Call setToPath() for this MazeSquare
			return true;
		  }
		}

		// If we're not on the right edge of the maze, try to go east.
		if (col is not the last column of the maze) 
		{
		  if (call solveMaze() with row and col+1 as arguments) 
		  {
			// There is a valid path to the east.
				 Call setToPath() for this MazeSquare
			return true;
		  }
		}
		// If we haven't returned true by this point, no valid path through the 
		// maze has been found.
		return false;

	}

}
