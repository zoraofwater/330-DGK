import java.io.*;

public class ListofMembers
{  
   public FileWriter out;
   public BufferedReader br;

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
   
   public boolean searchLogin(String name, String pass) throws IOException
   {
      br = new BufferedReader(new FileReader("output.txt"));
      boolean user = true;
      String line = br.readLine(), line2 = "";;
           
      while(line != null)
      {  
         line2 = getWord(line);
         
         if(name.equals(line2))
         {
            count++;
            
            line2 = getWord(line);
            if(pass.equals(line2))
            {
               user = true;
               line = null;
            }
            else
            {
               user = false;
               line = null;
            }
         }
         else
         {
            user = false;
            line = br.readLine();
         }
         line2 = "";
         count = 0;
      }
      return user;
   }
   
   public String getWord(String temp)
   {
      String temp2 = "";
      for(char ch = temp.charAt(count); ch != ' '; ch = temp.charAt(count))
      {
         temp2 = temp2 + ch;
         count++;
      }
      return temp2;
   }
   
   private int count = 0;
}