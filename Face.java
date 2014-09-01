public class Face{
   private int arr[][];
   private boolean contain;
   public Face(int dir){
      contain = false;
      int arr[][] = {{0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0}};
      this.arr = arr;
      if(dir!=0){
         dir(dir);
      }
   }
   public void dir(int dir){
      int temp[][] = new int[12][12];
      for(int i=0; i<12; i++){
         for(int j = 0; j<12; j++){
            temp[i][j] = arr[i][j];
         }
      }
      if(dir == 1){
         for(int i=0; i<12; i++){
            for(int j = 0; j<12; j++){
               arr[j][11-i] = temp[i][j];
            }
         }
      } 
      else if(dir == 2){
         for(int i=0; i<12; i++){
            for(int j = 0; j<12; j++){
               arr[11-i][11-j] = temp[i][j];
            }
         }
      } 
      else if (dir==3){
         for(int i=0; i<12; i++){
            for(int j = 0; j<12; j++){
               arr[11-j][i] = temp[i][j];
            }
         }
      }
   }
   public int get(int i, int j){
      return arr[i][j];
   }
   public void setContain(boolean contain){
      this.contain = contain;
   }
   public boolean getContain(){
      return contain;
   }
}