import java.util.*;

public class HashList{
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
}