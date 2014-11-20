import java.util.*;
import java.io.*;

/*public class HashList{
   List HList = new ArrayList();
   Iterator iter = new Iterator();
   iter = HList.iterator();
   
   public void ListAdd(String hoot){
      char start, end;
      char point = '!';
      char space = ' ';
      char period = '.';
      String hashtag;
      for(start = hoot[0]; end == ' ' || end == '.' || end == '!'; start = start.next()){
         if(start == '#'){
            end = ' ';
            hashtag = hoot[start, end];
            HList.add(hashtag);
         }
      }
   }
} Do not reinsert, possibly may need to delete*/

public class HashList{
   
   public void ListAdd(String hoot, int count) throws IOException{
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