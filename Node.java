import java.awt.*;
public class Node{
	private int up;
	private int down;
	private int left;
	private int right;
	private Point loc;
	public Node(int x, int y){
		this.setLoc(new Point(x, y));
	}
	public Point getLoc() {
		return loc;
	}
	public void setLoc(Point loc) {
		this.loc = loc;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getDown() {
		return down;
	}
	public void setDown(int down) {
		this.down = down;
	}
	public int getUp() {
		return up;
	}
	public void setUp(int up) {
		this.up = up;
	}
}