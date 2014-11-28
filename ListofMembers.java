import java.io.*;

public class ListofMembers
{  
   public FileWriter out;
   public BufferedReader br;
   public String[][] users;
   public String[] parts;
   
   ListofMembers() throws IOException, FileNotFoundException
   {
      users = new String[getSize()][8];
      size = getSize();
      count = 0;
      BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
      String line = reader.readLine();
      
      while(line != null)
      {
         for(int i = 0; i < 8; i++)
         {
            parts = line.split(" ");
            users[count][i] = parts[i]; //username
         }
         line = reader.readLine();
         count++;
      }
   }
   
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
   
   public void searchUser(String name) throws IOException
   {
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
            line = null;
            user = true;
         }
         else
         {
            line = br.readLine();  
         }
      }
      if(user == false);
      {
         System.out.println("Username not found.");
      }
   }
   
   public int searchUserLine(String name) throws IOException
   {
      int num = 1;
      count = 0;
      br = new BufferedReader(new FileReader("output.txt"));
      boolean user = false;
      String line = br.readLine(), line2 = "";
           
      while(line != null)
      {
         line2 = getUser(line);
         if(name.equals(line2))
         {
            count = num;
            line = null;
         }
         else
         {
            num++;
            line = br.readLine();
         }
         line2 = "";
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
   
   public void addWin(String name, int val) throws IOException
   {
      int temp, chall, win;
      
      temp = searchUserLine(name) - 1;
      win = Integer.parseInt(users[temp][5]) + val;
      chall = Integer.parseInt(users[temp][7]) + val;
      
      users[temp][5] = "" + win;
      users[temp][7] = "" + chall;
   }
   
   public void addLoss(String name, int val) throws IOException
   {
      int temp, chall, loss;
      
      temp = searchUserLine(name) - 1;
      loss = Integer.parseInt(users[temp][6]) + val;
      chall = Integer.parseInt(users[temp][7]) + val;
      
      users[temp][6] = "" + loss;
      users[temp][7] = "" + chall;
   }
   
   public void update() throws FileNotFoundException, IOException
   {
      String temp = "";
      size = getSize();
      String[] hold = new String[size];
      int count = 0, size2 = size - 1, next;

      FileWriter out = new FileWriter("output.txt");
      for(int i = 0; i < size; i++)
      {
         for(int j = 0; j < 8; j++)
         {
            temp = temp + users[i][j] + " ";
         }
         hold[i] = temp;
         temp = "";
      }
      try { 
         out.write(hold[0] + '\n');
      }finally {
         if (out != null)
         {
            out.close();
         }
      }
      FileWriter out2 = new FileWriter("output.txt",true);
      
      try
      {
         for(int i = 1; i < size; i++)
         {
            out2.write(hold[i]+'\n');
         }
      }finally
      {
         out2.close();
      }
	}
   
   private int count = 0, size = 0;
}
