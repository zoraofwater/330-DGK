import java.io.*;

public class Hoot{
   public String hot;
   boolean pubPri;
   public String name;
   Hoot(String username, boolean pubOrPri, String hoot){
      hot = hoot;
      name = username;
      pubPri = pubOrPri;}
      
   public String getHoot(){
      return hot;}
      
   public String getUsername(){
      return name;}
      
   public boolean getHootStatus(){
      return pubPri;}

   public void HAdd(String hot){
      HashList HL = new HashList();
      int count = 0;
      char check = hot.charAt(count);
      while (check != hot.charAt(-1)){
         count = count + 1;
         check = hot.charAt(count);
         if (check == '#'){
            try{HL.ListAdd(hot, count);}
            catch(IOException a){System.out.print("HAdd exception");}
         }
      }
   }
    
   public void TAdd(String hot){   
      TagList TL = new TagList();
      int count = 0;
      char check = hot.charAt(count);
      while (check != hot.charAt(-1)){
         count = count + 1;
         check = hot.charAt(count);
         if (check == '@'){
            try{TL.ListAdd(hot, count);}
            catch(IOException a){System.out.print("TAdd exception");}

         }   
      }
   }
}