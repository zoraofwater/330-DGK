import java.util.*;
import java.io.*;

public class HashList{
   
   public void ListAdd(String hoot, int count) throws IOException{ //adds hashtags to list
   FileReader in = new FileReader ("HList.txt");
   FileWriter out = new FileWriter ("HList.txt");
   char start = hoot.charAt(count);
   String hashtag = "";
   while (start != ' ' && start != '!' && start != '.'){      
      hashtag = hashtag + start;
      start = hoot.charAt(count++);
      }
   out.write(hashtag);
   }
}   