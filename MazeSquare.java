public class MazeSquare 
{
	// specifies the type of squares that can be drawn
	// wall, space, and path
	public SquareType enum = new SquareType();

	// A symbolic constant that specifies the dimensions
	// of a square (the sample screenshots use 15 x 15 pixel squares).
	//
	// Excuse me what???


	// A symbolic constant that specifies the dimensions of a square 
	// (the sample screenshots use 15 x 15 pixel squares).
	int row, column;

	// A SquareType variable that stores the type of the square.
	SquareType typeOfSquare;

	// A Boolean variable that specifies whether this square has been
	// visited by the solution algorithm. This should be initialized to false
	boolean visited = false;

	// A constructor that creates a MazeSquare with a specified row, column, and type.
	public MazeSquare(int row, int column, SquareType typeOfSquare) 
	{
		this.row = row;
		this.column = column;
		this.typeOfSquare = typeOfSquare;
	}


	// This method will be called for every square in the maze when the “Clear Solution”
	// button is pressed. It should set the square’s visited data member to false and if
	// the square’s type is currently PATH, it should be changed back to SPACE.
	public void clearSquare()
	{
		this.visited = false;

		if(this.typeOfSquare == "PATH")
		{
			this.typeOfSquare == "SPACE";
		}
	}


	// This method will be called by the solution algorithm. It should set the square’s
	// visited data member to true.
	public void markVisited()
	{
		this.visited = true;
	}

	// This method will be called by the solution algorithm. It should return the square’s
	// visited data member.
	public boolean getVisited()
	{
		return self.visited;
	}

	// This method will be called by the solution algorithm. It should return true if this 
	// square’s type is WALL and false if it is not.
	public boolean isWall()
	{
		if(this.typeOfSquare == "WALL")
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	// This method will be called by the solution algorithm. It should set the square’s 
	// type to PATH.
	public void setToPath()
	{
		this.typeOfSquare = "PATH";
	}

	// This method will be called for each square as part of drawing the maze. The Graphics
	// object can be used to call various drawing methods. The parameters startX and startY
	// are the x and y coordinates of the upper left corner of the maze.
	public void drawSquare(Graphics g, int startX, int startY)
	{
		// The method should set the current drawing color based on the square’s type, draw
		// a filled rectangle of that color, and then draw a black rectangle as the border
		// of the square. You will need to compute the x and y coordinates of the upper left
		// corner of these rectangles based on startX and startY, the row and column of the
		// square, and the square’s dimensions. 	
	}
}
