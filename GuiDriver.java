import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.*;
public class GuiDriver extends JPanel{
   public static void main(String[] arg){
      System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
      JFrame frame = new JFrame("Suduko Solving App");
      MazePanel panel = new MazePanel();
      //frame.setExtendedState(Frame.MAXIMIZED_BOTH);
      frame.add(panel);
      //frame.pack();
      frame.setSize(1200,700);
      frame.setVisible(true);
      panel.maze();
      /*try{
         panel.start();
      } 
      catch (InterruptedException e){
      }*/
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	//System.out.println(System.nanoTime());
      /*int counter = 0;
      for(int i = 0; i<=7; i++){
         for(int j = 0; j<64; j++){
            counter++;
            if(i == 7&&j == 8){
               System.out.println(counter);
            }
         }
      }*/
   }
}