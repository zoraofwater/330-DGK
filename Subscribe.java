import java.io.*;
import java.util.*;
import java.io.BufferedReader.*;

public class Subscribe
{
   public void addMember(int node) throws IOException, FileNotFoundException
   {
      FileWriter out = new FileWriter("subscribe.txt",true);
          
      BufferedReader reader = new BufferedReader(new FileReader("subscribe.txt"));
      String line = reader.readLine(), line2 = "";
      
      while(line != null)
      {
         line2 = line2 + "0";
         String.format(line + "0");
         line = reader.readLine();
      }
      
      line2 = line2 + "1";
      
      try { 
         out.write(line2);
      }finally {
         if (out != null)
         {
            out.close();
         }
      }
   }
	/*public void add(String member, String subscription) throws FileNotFoundException, IOException
   {
		BufferedReader reader = new BufferedReader(new FileReader("subscribe.txt");
      String line = reader.readLine(), temp;
      boolean user = false;
      
		while (line != null && user == false)
      {
			String parts[] = line.split(" ");
         
         if(part[0] == member)
         {
            temp = temp + part[1] + subscription + " ";
            line = null;
            user = true;
         }
         else
         {
            line = reader.readLine();
         }
		}
      
      if(user == false)
      {
         out = new FileWriter("subscribe.txt",true);
         
         try { 
            out.write(member + " " + subscription);
         }finally {
            if (out != null)
            {
               out.close();
            }
         }
      }
      else
      {
         out = new FileWriter("subscribe.txt");
      }
	}*/
}
