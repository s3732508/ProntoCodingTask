import java.util.Scanner;  

public class Board {

	private static Piece piece;
	private static Cell[][] cells; 
	private static Cell cursor;
	private static int height;
	private static int length;
	
	public Board(int height, int length) {
		cells = new Cell[length][height]; 
		piece = new Piece(0);
		this.length = length;
		this.height = height;
		for(int i=0;i<height;i++) {
			for(int j=0;j<length;j++) {
				cells[j][i] = new Cell(j, i, false);
			}
		}
		this.cursor = cells[length/2][height/2];
		cursor.setOccupied(true);
	}
	
	

	void printBoard() {
		  
	
		for(int i=0;i<height;i++) {
			System.out.print(" | ");
			for(int j=0;j<length;j++) {
				if(cells[j][i].isOccupied() == true)
					System.out.print("C | " );
				
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
	
	static int calculateTraversalDistance() {
		
		return Math.abs(cursor.getX()-(length/2))+Math.abs(cursor.getY()-(height/2));
	}
	
	public static void main(String[] args) {
		
		System.out.println();
		System.out.println("Enter BOARD SIZE AS A NUMBER. For Example 6,7 refers height - 6, length -7  board");
		Scanner scanner = new Scanner(System.in); 
		String commandString = scanner.nextLine();
		String[] commands = commandString.split(","); 
		
	    int length = Integer.parseInt(commands[0]);
	    int height = Integer.parseInt(commands[1]);
	    
		Board board = new Board(length,height);
		
		  // Create a Scanner object
		    System.out.println("Enter comma separated Commands");
		    commandString = scanner.nextLine();
		    
		    commands = commandString.split(","); 
		    
		    try {
		    	for (String command : commands) {
			    	String[] array = command.split("");
			    	//System.out.println( array[0]+ " "+ array[1]);
			    	switch(array[0].toUpperCase()) {
			    	  case "F":
			    	    // code block
//			    		  System.out.println("Front " + array[1]);
			    		  MoveFront(Integer.parseInt(array[1]));
			    	    break;
			    	  case "B":
//			    		  System.out.println("Back " + array[1]);
			    		  MoveBack(Integer.parseInt(array[1]));
			    	    break;
			    	  case "R":
//			    		  System.out.println("Right " + array[1]);
			    		  TurnRight(Integer.parseInt(array[1]));
			    	    break;
			    	  case "L":
//			    		  System.out.println("Left " + array[1]);
			    		  TurnLeft(Integer.parseInt(array[1]));
			    	    break;
			    	  default:
			    	    // code block
			    	}
			    	board.printBoard();	
					System.out.println("TRAVERSAL DISTANCE IS : " + calculateTraversalDistance());
			    }
	    		  }catch(Exception e) {
	    			  System.out.println("The cursor is moving out of the table, Please retry with a bigger size Board");
	    			 
	    		  } 
		

	}



	private static void TurnLeft(int i) {
		// TODO Auto-generated method stub
		for(int k=0;k<i; k++)
			piece.turnLeft();
//		System.out.println(piece.getDirection());
	}



	private static void TurnRight(int i) {
		// TODO Auto-generated method stub
		for(int k=0;k<i; k++)
			piece.turnRight();
//		System.out.println(piece.getDirection());
	}



	private static void MoveBack(int i) {
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
				  cursor = cells[cursor.getX()-1][cursor.getY()];
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
				  cursor = cells[cursor.getX()+1][cursor.getY()];
				  cursor.setOccupied(true);
			    break;
				   

			  default:
			    // code block
			}
		}
//		System.out.println(cursor.getX()+", "+cursor.getY());
		
	}



	private static void MoveFront(int i) {
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
			  cursor = cells[cursor.getX()+1][cursor.getY()];
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
			  cursor = cells[cursor.getX()-1][cursor.getY()];
			  cursor.setOccupied(true);
		    break;
			   

		  default:
		    // code block
		}
		}
//		System.out.println(cursor.getX()+", "+cursor.getY());
		
	}



	
	
}
