import java.io.*;

public class ListofMembers
{  
   public FileWriter out;


   public void add(Member object) throws IOException
   {
      out = new FileWriter("output.txt",true);

      try { 
         out.write(object.getUsername() + " ");
         out.write(object.getPassword() + " ");
         out.write(object.getEmail() + " ");
         out.write(object.getAge() + " ");
         out.write(object.getGender() + " ");
         out.write(object.getWin() + " ");
         out.write(object.getLoss() + " ");
         out.write(object.getChallenges() + '\n');
      }finally {
         if (out != null)
         {
            out.close();
         }
      }
   }
}