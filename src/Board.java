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
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < length; j++) {
				cells[j][i] = new Cell(j, i, false);
			}
		}
		this.cursor = cells[length / 2][height / 2];
		cursor.setOccupied(true);
	}

	void printBoard() {

		for (int i = 0; i < height; i++) {
			System.out.print(" | ");
			for (int j = 0; j < length; j++) {
				if (cells[j][i].isOccupied() == true)
					System.out.print("C | ");

				else {
					if (i == height / 2 && j == length / 2)
						System.out.print("O | ");
					else
						System.out.print("  | ");
				}

			}
			System.out.println();

			for (int j = 0; j < length; j++) {
				System.out.print("-----");
			}

			System.out.println();
		}

	}

	public static void main(String[] args) {

		System.out.println();
		System.out.println("Enter BOARD SIZE AS A NUMBER.\nFor Example 6,7 refers height of 6, length of 7  board");
		Scanner scanner = new Scanner(System.in);
		String commandString = scanner.nextLine();
		String[] commands = null;
		Board board = null;
		try {
			commands = commandString.split(",");
			if (commands.length > 2) {
				throw new Exception();
			}
			int length = Integer.parseInt(commands[0]);
			int height = Integer.parseInt(commands[1]);
			board = new Board(length, height);
		} catch (Exception e) {
			System.err.println(
					"Invalid input \nPlease give the input in the format as integer,integer \nInteger must be greater than 0 \nMax Value : 1000000");
			System.exit(1);
		}
		catch (OutOfMemoryError e) {
			System.err.println(
					"length * height cannot be greater than 10000000");
			System.exit(1);
		}
		System.out.println("Enter comma separated Commands. \nExample command: R1,L1,B3");
		commandString = scanner.nextLine();
		commands = commandString.split(",");
		
		System.out.println("Traversal Distance : " + executecommands(board, commands));
		System.out.println("Print Board ??? y- yes ");
		String drawboard = scanner.nextLine();
		
		
		if(drawboard.toUpperCase().equals("Y"))
			board.printBoard();

	}

	private static int executecommands(Board board, String[] commands) {
		// TODO Auto-generated method stub
		try {
			for (String command : commands) {
				String[] array = command.split("");

				int number = 0;
				for (int i = 1; i <= array.length - 1; i++) {
					number = (int) (number + Integer.parseInt(array[i]) * Math.pow(10, array.length - i - 1));
				}
				switch (array[0].toUpperCase()) {
				case "F":
					// code block
//			    		  System.out.println("Front " + array[1]);
					MoveFront(number);
					break;
				case "B":
//			    		  System.out.println("Back " + array[1]);
					MoveBack(number);
					break;
				case "R":
//			    		  System.out.println("Right " + array[1]);
					TurnRight(number);
					break;
				case "L":
//			    		  System.out.println("Left " + array[1]);
					TurnLeft(number);
					break;
				default:
					throw new Exception();
				}

			}
		} catch (Exception e) {
			System.out.println("Invalid input \nPlease give the input in the format requested \nAlso Make sure the given input is under the board boundaries");
			System.exit(0);
		}
		return Math.abs(cursor.getX() - (length / 2)) + Math.abs(cursor.getY() - (height / 2));

	}

	private static void TurnLeft(int i) {
		// TODO Auto-generated method stub
		for (int k = 0; k < i; k++)
			piece.turnLeft();
//		System.out.println(piece.getDirection());
	}

	private static void TurnRight(int i) {
		// TODO Auto-generated method stub
		for (int k = 0; k < i; k++)
			piece.turnRight();
//		System.out.println(piece.getDirection());
	}

	private static void MoveBack(int i) {
		// TODO Auto-generated method stub
		int direction = piece.getDirection();
		for (int k = 0; k < i; k++) {

			switch (direction) {
			case 0:
				cursor.setOccupied(false);
				cursor = cells[cursor.getX()][cursor.getY() + 1];
				cursor.setOccupied(true);
				break;
			case 1:
				cursor.setOccupied(false);
				cursor = cells[cursor.getX() - 1][cursor.getY()];
				cursor.setOccupied(true);
				break;
			// code block
			case 2:
				cursor.setOccupied(false);
				cursor = cells[cursor.getX()][cursor.getY() - 1];
				cursor.setOccupied(true);
				break;
			// code block
			case 3:
				cursor.setOccupied(false);
				cursor = cells[cursor.getX() + 1][cursor.getY()];
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
		for (int k = 0; k < i; k++) {
			switch (direction) {
			case 0:
				cursor.setOccupied(false);
				cursor = cells[cursor.getX()][cursor.getY() - 1];
				cursor.setOccupied(true);
				break;
			case 1:
				cursor.setOccupied(false);
				cursor = cells[cursor.getX() + 1][cursor.getY()];
				cursor.setOccupied(true);
				break;
			// code block
			case 2:
				cursor.setOccupied(false);
				cursor = cells[cursor.getX()][cursor.getY() + 1];
				cursor.setOccupied(true);
				break;
			// code block
			case 3:
				cursor.setOccupied(false);
				cursor = cells[cursor.getX() - 1][cursor.getY()];
				cursor.setOccupied(true);
				break;

			default:
				// code block
			}
		}
//		System.out.println(cursor.getX()+", "+cursor.getY());

	}

}
