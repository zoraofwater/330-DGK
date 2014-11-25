import java.io.*;
import java.util.*;
import java.io.BufferedReader.*;

public class Subscribe
{
   char[][] list;
   Subscribe(int size) throws IOException, FileNotFoundException
   {
      list = new char[size][size];
      int count = 0;
      BufferedReader reader = new BufferedReader(new FileReader("subscribe.txt"));
      String line = reader.readLine();
      
      System.out.println(size);
      System.out.println("Bitch2" + line);
      while(line != null)
      {
         System.out.println("Bitch");
         for(int i = 0; i < size; i++)
         {
            list[count][i] = line.charAt(i);
            System.out.println(line.charAt(i));
         }
         line = reader.readLine();
         count++;
      }
      printGraph(size);
   }
   
   void printGraph(int size)
   {
      System.out.println();
      for(int i = 0; i < size; i++)
      {
         for(int j = 0; j < size; j++)
         {
            System.out.print(list[i][j]);
         }
         System.out.println();
      }
   }
	public void update(int user) throws FileNotFoundException, IOException
   {
      String temp = "";
      String[] hold = new String[user];
      int count = 0, size = user - 2;

      FileWriter out = new FileWriter("subscribe.txt");
      
      System.out.println(size);
      
      for(int i = 0; i < user; i++)
      {
         for(int j = 0; j < user; j++)
         {
            System.out.println(j);
            if(j != size)
            {
               System.out.println("derp");
               temp = temp + list[count][j];
            }
            else if(i != size)
            {
               System.out.println("derp2");
               temp = temp + '0';
            }
            else
            {
               System.out.println("derp3");
               temp = temp + '1';
            }
            System.out.println(temp);
         }
         System.out.println("END");
         hold[i] = temp;
         count++;
         temp = "";
      }
      
      try { 
         for(int i = 0; i < user; i++)
         {
            out.write(hold[i]);
         }
      }finally {
         if (out != null)
         {
            out.close();
         }
      }
	}
}
