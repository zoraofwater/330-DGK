import java.util.*;
import java.io.*;

public class TagList{
   
   public void ListAdd(String hoot, int count) throws IOException{
   FileReader in = new FileReader ("TList.txt");
   FileWriter out = new FileWriter ("TList.txt");
   char start = hoot.charAt(count);
   String tag = "";
   while (start != ' ' && start != '!' && start != '.'){      
      tag = tag + start;
      start = hoot.charAt(count++);
      }
   out.write(tag);
   }
}   