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
      
      while(line != null)
      {
         for(int i = 0; i < size; i++)
         {
            list[count][i] = line.charAt(i);
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
      int count = 0, size = user - 1, next;

      FileWriter out = new FileWriter("subscribe.txt");
      
      for(int i = 0; i < user; i++)
      {
         for(int j = 0; j < user; j++)
         {
            System.out.println(j + " " + count);
            if(j < size && i < size)
            {
               System.out.println("derp");
               temp = temp + list[count][j];
            }
            else if((j == size && i < size) || (j < size && i == size))
            {
               System.out.println("derp2");
               temp = temp + '0';
            }
            else if (j == size && i == size)
            {
               System.out.println("derp3");
               temp = temp + '1';
            }
            System.out.println("Line: " + temp);
         }
         System.out.println("END");
         hold[i] = temp;       
         count++;
         temp = "";
      }
      System.out.println("Attempt to write");
      try { 
         out.write(hold[0] + '\n');
      }finally {
         if (out != null)
         {
            out.close();
         }
      }
      System.out.println("Written line 1. attempting to write line 2");
      FileWriter out2 = new FileWriter("subscribe.txt",true);
      
      try
      {
         for(int i = 1; i < user; i++)
         {
            out2.write(hold[i]+'\n');
         }
      }finally
      {
         out2.close();
      }
	}
}
