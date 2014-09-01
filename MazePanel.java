import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class MazePanel extends JPanel{
	private int arr[][];
	private JPanel layout[][];
	private int minArr[][];
	// use circle equation to go in circle
	public MazePanel(){
		arr = new int[100][100];
		layout = new JPanel[100][100];
		//farr = new Face[4][53][53];
		setLayout(new GridLayout(100, 100));
		adder();
		//maze();
		//setter();
		//setter2();
		//check();
		//sum();
	}
	// 1/0 is up, 11/00 is right, 111/000 is down, 1111/0000 is left in binary
	// 0 is up, 1 is right, 2 is down, 3 is left
	public int[][][] nodeGen(){
		int temp[][] = minArr;
		int[][][] node = new int[4][25][25];
		for(int x = 0; x<4; x++){
			for(int i = 0; i<25; i++){
				for(int j = 0; j<25; j++){  
					node[x][i][j] = 0;
				}
			}
		}
		for(int i = 1; i<25; i++){
			for(int j = 0; j<25; j++){  
				if(temp[i][j]==1&&temp[i-1][j] == 1){
					node[0][i][j]++;
				}
			}
		}
		for(int i = 0; i<25; i++){
			for(int j = 1; j<25; j++){  
				if(temp[i][j]==1&&temp[i][j-1] == 1){
					node[3][i][j]++;
				}
			}
		}
		for(int i = 0; i<24; i++){
			for(int j = 0; j<25; j++){  
				if(temp[i][j]==1&&temp[i+1][j] == 1){
					node[2][i][j]++;
				}
			}
		}
		for(int i = 0; i<25; i++){
			for(int j = 0; j<24; j++){  
				if(temp[i][j]==1&&temp[i][j+1] == 1){
					node[1][i][j]++;
				}
			}
		}
		return node;
	}
	public void adder(){
		int count = 0;
		for (int i = 0; i<100; i++){
			for(int j = 0; j<100; j++){
				JPanel txt = new JPanel();
				layout[i][j] = txt;
				txt.setBorder(BorderFactory.createLineBorder(Color.black));
				txt.setBackground(Color.orange);
				arr[i][j] = 0;
				add(txt);
			}
		}
	}
	/* 0 = up
      1 = right
      2 = down
      3 = leftx
	 */
	 public void maze(){
		 LinkedList<Point> list = new LinkedList<Point>();
		 Random rand = new Random();
		 int minArr[][] = new int[25][25];
		 boolean cond = true;
		 while(cond){
			 list = new LinkedList<Point>();
			 for(int x = 0; x<25; x++){
				 for(int y = 0; y<25; y++){
					 minArr[x][y] = 0;
					 //layout[x][y].setBackground(Color.orange);
				 }
			 }
			 int i = 0;
			 int j = 0;
			 minArr[0][0] = 1;
			 //layout[i][j].setBackground(Color.blue);
			 list.push(new Point(i,j));
			 int count = 0;
			 while(minArr[24][24]!=1&&count<100000){
				 count++;
				 //System.out.println(i + "," + j);
				 int num = rand.nextInt(4);
				 if(num == 0){
					 if(j>0){
						 j--;
						 if(i-1>=0&&i+1<=24){

						 }
						 if(!list.contains(new Point(i,j))){
							 list.push(new Point(i,j));
							 minArr[i][j]= 1;
							 //layout[i][j].setBackground(Color.blue);
						 }
						 else{
							 Point pnt = list.pop();
							 minArr[pnt.x][pnt.y]= 0;
							 //layout[pnt.x][pnt.y].setBackground(Color.orange);
							 pnt = list.peek();
							 i = pnt.x;
							 j = pnt.y;
						 }
					 }
				 } 
				 else if(num == 1){
					 if(i<24){
						 i++;
						 if(!list.contains(new Point(i,j))){
							 list.push(new Point(i,j));
							 minArr[i][j]= 1;
							 //layout[i][j].setBackground(Color.blue);
						 }
						 else{
							 Point pnt = list.pop();
							 minArr[pnt.x][pnt.y]= 0;
							 //layout[pnt.x][pnt.y].setBackground(Color.orange);
							 pnt = list.peek();
							 i = pnt.x;
							 j = pnt.y;
						 }
					 }
				 } 
				 else if(num == 2){
					 if(j<24){
						 j++;
						 if(!list.contains(new Point(i,j))){
							 list.push(new Point(i,j));
							 minArr[i][j]= 1;
							 //layout[i][j].setBackground(Color.blue);
						 }
						 else{
							 Point pnt = list.pop();
							 minArr[pnt.x][pnt.y]= 0;
							 //layout[pnt.x][pnt.y].setBackground(Color.orange);
							 pnt = list.peek();
							 i = pnt.x;
							 j = pnt.y;
						 }
					 }
				 } 
				 else{
					 if(i>0){
						 i--;
						 if(!list.contains(new Point(i,j))){
							 list.push(new Point(i,j));
							 minArr[i][j]= 1;
							 //layout[i][j].setBackground(Color.blue);
						 }
						 else{
							 Point pnt = list.pop();
							 minArr[pnt.x][pnt.y]= 0;
							 //layout[pnt.x][pnt.y].setBackground(Color.orange);
							 pnt = list.peek();
							 i = pnt.x;
							 j = pnt.y;
						 }
					 }
				 }
			 }
			 System.out.println(count);
			 if(count<100000){
				 cond = false;
			 }
		 }
		 for(int i = 0; i<100; i++){
			 for(int j = 0; j<100; j++){
				 if(minArr[i/4][j/4] == 1){
					 layout[i][j].setBackground(Color.blue);
					 arr[i][j] = 1;
				 }
			 }
		 }
		 this.minArr = minArr;
	 }
	 public void start() throws InterruptedException{
		 Travel travel = new Travel(arr);
		 Point loc[] = travel.getLocation();
		 layout[loc[0].x][loc[0].y].setBackground(Color.red);
		 layout[loc[1].x][loc[1].y].setBackground(Color.red);
		 move(travel);
		 move(travel);
		 move(travel);
	 }
	 public void move(Travel travel) throws InterruptedException{
		 Thread.sleep(1000);
		 Point loc[] = travel.getLocation();
		 layout[loc[0].x][loc[0].y].setBackground(Color.blue);
		 layout[loc[1].x][loc[1].y].setBackground(Color.blue);
		 travel.move();
		 loc = travel.getLocation();
		 layout[loc[0].x][loc[0].y].setBackground(Color.red);
		 layout[loc[1].x][loc[1].y].setBackground(Color.red);
	 }
	 public int[][] getMinArr() {
		 return minArr;
	 }

}