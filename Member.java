import java.io.*;
import java.util.*;
import java.io.BufferedReader.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Member
{
   Member()
   {}

   public void addMember(String name, String pass, String mail, char gen, int ag)
   {
      gender = gen;
      username = name;
      password = pass;
      email = mail;
      win = loss = challenges = 0;
      member = true;
      age = ag;
   }
   
   public void printInfo()
   {
      System.out.print(username + " " + password + " " + email + " " + gender + " " + age);
   }
   
   public String getUsername()
   {
      return username;
   }
   
   public String getPassword()
   {
      return password;
   }
   
   public String getEmail()
   {
      return email;
   }
   
   public int getWin()
   {
      return win;
   }
   
   public int getLoss()
   {
      return loss;
   }
   
   public int getChallenges()
   {
      return challenges;
   }
   
   public int getAge()
   {
      return age;
   }
   
   public char getGender()
   {
      return gender;
   }
   
   //Battle setters and adders
   
   public void setWin(int val) throws FileNotFoundException, IOException{
      //win = val;
      BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
      int winNum = 0;
      boolean foundUser = false;
      String[][] users = new String[1000][8];
      int numOfUsers = 0;
      String line = reader.readLine();
      while (line != null) {
         String parts[] = line.split(" ");
         users[numOfUsers][0] = parts[0]; //username
         users[numOfUsers][1] = parts[1]; //password
         users[numOfUsers][2] = parts[2]; //email
         users[numOfUsers][3] = parts[3]; //age
         users[numOfUsers][4] = parts[4]; //gender
         users[numOfUsers][5] = parts[5]; //wins
         users[numOfUsers][6] = parts[6]; //losses
         users[numOfUsers][7] = parts[7]; //CHALLENGES
         if(username.compareTo(parts[0])==0) {
            foundUser = true;
            int originalWinNum = Integer.parseInt(parts[5]);
            winNum = val;
            parts[5] = Integer.toString(winNum);
         }
      }
      if(foundUser==true){
         PrintWriter pw = new PrintWriter("output.txt");
         pw.close();
         
         FileWriter out = new FileWriter("output.txt",true);
         try {
            for(int i = 0; i > numOfUsers; i++){
               out.write(users[i][0] + " ");
               out.write(users[i][1] + " ");
               out.write(users[i][2] + " ");
               out.write(users[i][3] + " ");
               out.write(users[i][4] + " ");
               out.write(users[i][5] + " ");
               out.write(users[i][6] + " ");
               out.write(users[i][7] + "\n");
            }
            
         }
         catch(IOException a){System.out.println("It didn't work. It did not work.");}
      }
      else {
         System.out.println("I am so sorry, something went wrong...");
      }
      
   }
   
   public void setLoss(int val) throws FileNotFoundException, IOException{
      //loss = val;
      BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
      int lossNum = 0;
      boolean foundUser = false;
      String[][] users = new String[1000][8];
      int numOfUsers = 0;
      String line = reader.readLine();
      while (line != null) {
         String parts[] = line.split(" ");
         users[numOfUsers][0] = parts[0]; //username
         users[numOfUsers][1] = parts[1]; //password
         users[numOfUsers][2] = parts[2]; //email
         users[numOfUsers][3] = parts[3]; //age
         users[numOfUsers][4] = parts[4]; //gender
         users[numOfUsers][5] = parts[5]; //wins
         users[numOfUsers][6] = parts[6]; //losses
         users[numOfUsers][7] = parts[7]; //CHALLENGES
         if(username.compareTo(parts[0])==0) {
            foundUser = true;
            int originalLossNum = Integer.parseInt(parts[6]);
            lossNum = val;
            parts[6] = Integer.toString(lossNum);
            
         }
      }
      if(foundUser==true){
         PrintWriter pw = new PrintWriter("output.txt");
         pw.close();
         
         FileWriter out = new FileWriter("output.txt",true);
         try {
            for(int i = 0; i > numOfUsers; i++){
               out.write(users[i][0] + " ");
               out.write(users[i][1] + " ");
               out.write(users[i][2] + " ");
               out.write(users[i][3] + " ");
               out.write(users[i][4] + " ");
               out.write(users[i][5] + " ");
               out.write(users[i][6] + " ");
               out.write(users[i][7] + "\n");
            }
            
         }
         catch(IOException a){System.out.println("It didn't work. It did not work.");}
      }
      else {
         System.out.println("I am so sorry, something went wrong...");
      }
   }
   
   public void addWin(int val, String username) throws FileNotFoundException, IOException{
      //win = win + val;
      BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
      int winNum = 0;
      boolean foundUser = false;
      String[][] users = new String[1000][8];
      int numOfUsers = 0;
      String line = reader.readLine();
      while (line != null) {
         String parts[] = line.split(" ");
         users[numOfUsers][0] = parts[0]; //username
         users[numOfUsers][1] = parts[1]; //password
         users[numOfUsers][2] = parts[2]; //email
         users[numOfUsers][3] = parts[3]; //age
         users[numOfUsers][4] = parts[4]; //gender
         users[numOfUsers][5] = parts[5]; //wins
         users[numOfUsers][6] = parts[6]; //losses
         users[numOfUsers][7] = parts[7]; //CHALLENGES
         System.out.println(username);
         System.out.println(parts[0]);
         if(username.equals(parts[0])) {
            foundUser = true;
            int originalWinNum = Integer.parseInt(parts[5]);
            winNum = originalWinNum+val;
            parts[5] = Integer.toString(winNum);
         }
         line = reader.readLine();
      }
      System.out.println(numOfUsers);
      System.out.println(foundUser);
      if(foundUser==true){
         PrintWriter pw = new PrintWriter("output.txt");
         FileWriter out = new FileWriter("output.txt",true);
         try {
            for(int i = 0; i > numOfUsers; i++){
            System.out.println("Inforloop");
               out.write(users[i][0] + " ");
               out.write(users[i][1] + " ");
               out.write(users[i][2] + " ");
               out.write(users[i][3] + " ");
               out.write(users[i][4] + " ");
               out.write(users[i][5] + " ");
               out.write(users[i][6] + " ");
               out.write(users[i][7] + "\n");
            }
            
         }
         catch(IOException a){System.out.println("It didn't work. It did not work.");}
         pw.close();
      }
      else {
         System.out.println("I am so sorry, something went wrong...");
      }
   }
   
   public void addLoss(int val) throws FileNotFoundException, IOException{
      //loss = loss + val;
      BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
      int lossNum = 0;
      boolean foundUser = false;
      String[][] users = new String[1000][8];
      int numOfUsers = 0;
      String line = reader.readLine();
      while (line != null) {
         String parts[] = line.split(" ");
         users[numOfUsers][0] = parts[0]; //username
         users[numOfUsers][1] = parts[1]; //password
         users[numOfUsers][2] = parts[2]; //email
         users[numOfUsers][3] = parts[3]; //age
         users[numOfUsers][4] = parts[4]; //gender
         users[numOfUsers][5] = parts[5]; //wins
         users[numOfUsers][6] = parts[6]; //losses
         users[numOfUsers][7] = parts[7]; //CHALLENGES
         if(username.compareTo(parts[0])==0) {
            foundUser = true;
            int originalLossNum = Integer.parseInt(parts[6]);
            lossNum = originalLossNum+val;
            parts[6] = Integer.toString(lossNum);
         }
      }
      if(foundUser==true){
         PrintWriter pw = new PrintWriter("output.txt");
         pw.close();
         
         FileWriter out = new FileWriter("output.txt",true);
         try {
            for(int i = 0; i > numOfUsers; i++){
               out.write(users[i][0] + " ");
               out.write(users[i][1] + " ");
               out.write(users[i][2] + " ");
               out.write(users[i][3] + " ");
               out.write(users[i][4] + " ");
               out.write(users[i][5] + " ");
               out.write(users[i][6] + " ");
               out.write(users[i][7] + "\n");
            }
            
         }
         catch(IOException a){System.out.println("It didn't work. It did not work.");}
      }
      else {
         System.out.println("I am so sorry, something went wrong...");
      }
   }
   
   public void issueChallenge(String rival) throws FileNotFoundException, IOException{
      BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
      int chalNum = 0;
      boolean foundUser = false;
      String[][] users = new String[1000][8];
      int numOfUsers = 0;
      String line = reader.readLine();
      while (line != null) {
         String parts[] = line.split(" ");
         users[numOfUsers][0] = parts[0]; //username
         users[numOfUsers][1] = parts[1]; //password
         users[numOfUsers][2] = parts[2]; //email
         users[numOfUsers][3] = parts[3]; //age
         users[numOfUsers][4] = parts[4]; //gender
         users[numOfUsers][5] = parts[5]; //wins
         users[numOfUsers][6] = parts[6]; //losses
         users[numOfUsers][7] = parts[7]; //CHALLENGES
         if(rival.compareTo(parts[0])==0){
            //find user challenge number
            foundUser = true;
            int originalChalNum = Integer.parseInt(parts[7]);
            chalNum = originalChalNum++;
            parts[7] = Integer.toString(chalNum);
         }
         
         
         numOfUsers++;
         line = reader.readLine();
      }
      if(foundUser==true){
         PrintWriter pw = new PrintWriter("output.txt");
         pw.close();
         
         FileWriter out = new FileWriter("output.txt",true);
         try {
            for(int i = 0; i > numOfUsers; i++){
               out.write(users[i][0] + " ");
               out.write(users[i][1] + " ");
               out.write(users[i][2] + " ");
               out.write(users[i][3] + " ");
               out.write(users[i][4] + " ");
               out.write(users[i][5] + " ");
               out.write(users[i][6] + " ");
               out.write(users[i][7] + "\n");
            }
            
         }
         catch(IOException a){System.out.println("It didn't work. It did not work.");}
      }
      else {
         System.out.println("I am so sorry, but that person does not exist.");
      }
   }
   
   public String username, password, email;
   int win, loss, challenges, age;
   boolean member;
   char gender;
}
