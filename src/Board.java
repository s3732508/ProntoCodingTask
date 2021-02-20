import java.util.Scanner;  

public class Board {

	private static Piece piece;
	private static Cell[][] cells; 
	private static Cell cursor;
	private static int height;
	private static int length;
	public Board(int height, int length) {
		cells = new Cell[height][length]; 
		piece = new Piece(0);
		this.length = length;
		this.height = height;
		for(int i=0;i<height;i++) {
			for(int j=0;j<length;j++) {
				cells[i][j] = new Cell(i, j, false);
			}
		}
		this.cursor = cells[height/2][length/2];
		cursor.setOccupied(true);
	}
	
	

	void printBoard() {
		  
	
		for(int i=0;i<height;i++) {
			System.out.print(" | ");
			for(int j=0;j<length;j++) {
				if(cells[j][i].isOccupied() == true)
					System.out.print("X | " );
				
				else {
					if(i==height/2 && j == length/2) 
						System.out.print("O | " );
					else
						System.out.print("  | " );
				}
					
			}
			System.out.println();
			
			for(int j=0;j<length;j++) {
				System.out.print("-----");
			}			
			
			System.out.println();
		}
		
	}
	
	int calculateTraversalDistance(Cell cell) {
		
		return 0;
	}
	
	public static void main(String[] args) {
		
		Board board = new Board(7,7);
		
		 Scanner scanner = new Scanner(System.in);  // Create a Scanner object
		    System.out.println("Enter comma separated Commands");
		    String commandString = scanner.nextLine();
		    
		    String[] commands = commandString.split(","); 
		    
		    for (String command : commands) {
		    	String[] array = command.split("");
		    	//System.out.println( array[0]+ " "+ array[1]);
		    	switch(array[0].toUpperCase()) {
		    	  case "F":
		    	    // code block
		    		  System.out.println("Front " + array[1]);
		    		  MoveFront(Integer.parseInt(array[1]));
		    	    break;
		    	  case "B":
		    		  System.out.println("Back " + array[1]);
		    		  MoveBack(Integer.parseInt(array[1]));
		    	    break;
		    	  case "R":
		    		  System.out.println("Right " + array[1]);
		    		  TurnRight(Integer.parseInt(array[1]));
		    	    break;
		    	  case "L":
		    		  System.out.println("Left " + array[1]);
		    		  TurnLeft(Integer.parseInt(array[1]));
		    	    break;
		    	  default:
		    	    // code block
		    	}
		    }
		board.printBoard();	

	}



	private static void TurnLeft(int i) {
		// TODO Auto-generated method stub
		for(int k=0;k<i; k++)
			piece.turnLeft();
		System.out.println(piece.getDirection());
	}



	private static void TurnRight(int i) {
		// TODO Auto-generated method stub
		for(int k=0;k<i; k++)
			piece.turnRight();
		System.out.println(piece.getDirection());
	}



	private static void MoveBack(int i) {
		// TODO Auto-generated method stub
		int direction = piece.getDirection();
		for(int k=0;k<i; k++) {

			switch(direction) {
			  case 0:
				  cursor.setOccupied(false);
				  cursor = cells[cursor.getX()][cursor.getY()-1];
				  cursor.setOccupied(true);
			    break;
			  case 1:
				  cursor.setOccupied(false);
				  cursor = cells[cursor.getX()-1][cursor.getY()];
				  cursor.setOccupied(true);
			    break;
			    // code block
			  case 2:
				  cursor.setOccupied(false);
				  cursor = cells[cursor.getX()][cursor.getY()+1];
				  cursor.setOccupied(true);
			    break;
				    // code block
			  case 3:
				  cursor.setOccupied(false);
				  cursor = cells[cursor.getX()+1][cursor.getY()];
				  cursor.setOccupied(true);
			    break;
				   

			  default:
			    // code block
			}
		}
		System.out.println(cursor.getX()+", "+cursor.getY());
		
	}



	private static void MoveFront(int i) {
		// TODO Auto-generated method stub
		int direction = piece.getDirection();
		for(int k=0;k<i; k++) {
		switch(direction) {
		  case 0:
			  cursor.setOccupied(false);
			  cursor = cells[cursor.getX()][cursor.getY()+1];
			  cursor.setOccupied(true);
		    break;
		  case 1:
			  cursor.setOccupied(false);
			  cursor = cells[cursor.getX()+1][cursor.getY()];
			  cursor.setOccupied(true);
		    break;
		    // code block
		  case 2:
			  cursor.setOccupied(false);
			  cursor = cells[cursor.getX()][cursor.getY()-1];
			  cursor.setOccupied(true);
		    break;
			    // code block
		  case 3:
			  cursor.setOccupied(false);
			  cursor = cells[cursor.getX()-1][cursor.getY()];
			  cursor.setOccupied(true);
		    break;
			   

		  default:
		    // code block
		}
		}
		System.out.println(cursor.getX()+", "+cursor.getY());
		
	}



	public Cell getCursor() {
		return cursor;
	}



	public void setCursor(Cell cursor) {
		this.cursor = cursor;
	}

	
}
