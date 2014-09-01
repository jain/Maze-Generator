import java.awt.*;
public class Travel{
   private Point location[];
   private int arr[][];
   private int dir;// 0 is up, 1 is right, 2 is down, 3 is left
   public Travel(int arr[][]){
      this.arr = arr;
      location = new Point[2];
      if(arr[5][0] == 1){
         location[0] = new Point(0,0);
         location[1] = new Point(1,0);
         dir = 2;
      }else{
         location[0] = new Point(3,0);
         location[1] = new Point(3,1);
         dir = 1;
      }
   }
   public void move(){
      if(dir==1){
         location[0] = new Point(location[1].x, location[1].y);
         location[1] = new Point(location[1].x, location[1].y+1);
      }else if(dir == 2){
         location[0] = new Point(location[1].x, location[1].y);
         location[1] = new Point(location[1].x+1, location[1].y);
      }else if(dir ==0){
         location[0] = new Point(location[1].x, location[1].y);
         location[1] = new Point(location[1].x-1, location[1].y);
      }else{
         location[0] = new Point(location[1].x, location[1].y);
         location[1] = new Point(location[1].x, location[1].y-1);
      }
   }
   public Point[] getLocation(){
      return location;
   }
}