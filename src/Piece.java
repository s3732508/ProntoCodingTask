
public class Piece {
	
//	Directions 
//	0 - North
//	1 - East
//	2 - South
//	3 - West	
	
	int[] leftTurn = {3, 0, 1, 2};
	
	int[] rightTurn = {1, 2, 3, 0};
			
	
	
	
	private int direction;
	
	
	public Piece(int i) {
		this.direction = i;
	
	}
	
	public int getDirection() {
		return direction;
	}
	
	public void turnLeft() {
		this.direction = leftTurn[this.direction];
	}
	
	public void turnRight() {
		this.direction = rightTurn[this.direction];
	}
	
}
