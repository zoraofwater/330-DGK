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
         out.write(object.getChallenges() + "\n");
      }finally {
         if (out != null)
         {
            out.close();
         }
      }
   }
   
   public boolean userExists(String name) throws IOException{
      br = new BufferedReader(new FileReader("output.txt"));
      String line = br.readLine();
      while(line != null){
         String parts[] = line.split(" ");
         if(name.equals(parts[0])) {
         System.out.println("inthere");
            return true;
         }
         line = br.readLine();
      }
      return false;
      
   }
   
   public boolean searchLogin(String name, String pass) throws IOException
   {
      br = new BufferedReader(new FileReader("output.txt"));
      boolean user = true;
      String line = br.readLine(), line2 = "";;
           
      while(line != null)
      {  
         line2 = getUser(line);
         
         if(name.equals(line2))
         {
            count++;
            
            line2 = getPass(line, count);
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
   
   public int searchUser(String name) throws IOException
   {
      int num = 1;
      count = 0;
      br = new BufferedReader(new FileReader("output.txt"));
      boolean user = false;
      String line = br.readLine(), line2 = "";;
           
      while(line != null)
      {  
         String[] parts = line.split(" ");
         System.out.println(parts[0]);
         if(name.equals(parts[0]))
         {
            System.out.println("Username: " + parts[0]);
            System.out.println("Age: " + parts[3]);
            System.out.println("Gender: " + parts[4]);
            System.out.println("Battles won: " + parts[5]);
            System.out.println("Battles lost: " + parts[6]);
            System.out.println("Current pending challenges: " + parts[7]);
            System.out.println("Email: " + parts[2]);
            count = num;
            line = null;
            break;
         }
         else
         {
            num++;
            
         }
         line = br.readLine();
         //line2 = "";
      }
      return count;
   }
   
   public String getUser(String temp)
   {
      String temp2 = "";
      count = 0;
      for(char ch = temp.charAt(count); ch != ' '; ch = temp.charAt(count))
      {
         temp2 = temp2 + ch;
         count++;
      }
      return temp2;
   }
   
   public String getPass(String temp, int num)
   {
      String temp2 = "";
      count = num;
      for(char ch = temp.charAt(count); ch != ' '; ch = temp.charAt(count))
      {
         temp2 = temp2 + ch;
         count++;
      }
      
      return temp2;
   }
   
   public int getSize() throws IOException, FileNotFoundException
   {
      int size = 0;
      br = new BufferedReader(new FileReader("output.txt"));
      String line = br.readLine();
           
      while(line != null)
      {  
         size++;
         line = br.readLine();
      }
      return size;

   }
   
   private int count = 0, size = 0;
}
