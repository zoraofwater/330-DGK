import java.io.*;

public class Hoot{
   public String hot;
   Hoot(String hoot){
      hot = hoot;}

   public void HAdd(String hot){
      HashList HL = new HashList(); //should be in main
      int count = 0;
      char check = hot.charAt(count);
      while (check != hot.charAt(-1)){
         count = count + 1;
         check = hot.charAt(count);
         if (check == '#'){
            try{HL.ListAdd(hot, count);}
            catch(IOException a){System.out.print("Shove something in there <3 Juliana");}
         }
      }
   }
    
   public void TAdd(String hot){   
      TagList TL = new TagList(); //should be in main
      int count = 0;
      char check = hot.charAt(count);
      while (check != hot.charAt(-1)){
         count = count + 1;
         check = hot.charAt(count);
         if (check == '@'){
            try{TL.ListAdd(hot, count);}
            catch(IOException a){System.out.print("Shove something in there <3 Juliana");}

         }   
      }
   }
}