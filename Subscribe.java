import java.io.*;
import java.util.*;
import java.io.BufferedReader.*;

public class Subscribe
{
   char[][] list;
   ListofMembers lom = new ListofMembers();
   int size = lom.getSize();
   
   Subscribe() throws IOException, FileNotFoundException
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
   }
   
 	public void update(boolean register) throws FileNotFoundException, IOException
   {
      String temp = "";
      size = lom.getSize();
      String[] hold = new String[size];
      int count = 0, size2 = size - 1, next;

      FileWriter out = new FileWriter("subscribe.txt");
      
      for(int i = 0; i < size; i++)
      {
         for(int j = 0; j < size; j++)
         {
            if(j < size2 && i < size2)
            {
               temp = temp + list[count][j];
            }
            else if((j == size2 && i < size2) || (j < size2 && i == size2))
            {
               if(register == false)
               {
                  temp = temp + list[i][j];
               }
               else
               {
                  temp = temp + '0';
               }
            }
            else if (j == size2 && i == size2)
            {
               temp = temp + '1';
            }
         }
         hold[i] = temp;       
         count++;
         temp = "";
      }
      try { 
         out.write(hold[0] + '\n');
      }finally {
         if (out != null)
         {
            out.close();
         }
      }
      FileWriter out2 = new FileWriter("subscribe.txt",true);
      
      try
      {
         for(int i = 1; i < size; i++)
         {
            out2.write(hold[i]+'\n');
         }
      }finally
      {
         out2.close();
      }
	}
   
   public void add(String member, String user) throws IOException
   {
      int count = 0, num = lom.searchUserLine(member) - 1, num2 = lom.searchUserLine(user)-1;
      
      list[num2][num] = '1';
   }
   
   public boolean searchSub(String member, String user) throws IOException
   {
      int count = 0, num = lom.searchUserLine(member) - 1, num2 = lom.searchUserLine(user)-1;
      boolean subby;
   
      if(list[num2][num] == '1')
      {
         subby = true;
      }
      else
      {
         subby = false;
      }
      return subby;
   }
}
