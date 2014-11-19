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
}*/

public class HashList{
   int c = 0;
   
   public void ListAdd(String hoot) throws IOException{
   FileReader in = new FileReader ("HList.txt");
   FileWriter out = new FileWriter ("HList.txt");
   char start, end;
   int find = 0;
   boolean found = false;
   String hashtag = "";
   for(start = hoot.charAt(find++); start == '#'; start = hoot.charAt(find++))
   while (start != ' ' && start != '!' && start != '.'){      
      hashtag = hashtag + start;
      start = hoot.charAt(find++);
   }
   while (c != -1) {
            c = in.read();}
   out.write(hashtag);
   }
}   