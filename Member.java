import java.util.Scanner;

public class Member extends Nonmember
{
   Member(String name, String pass, String mail, char gen, int ag)
   {
      gender = gen;
      username = name;
      password = pass;
      email = mail;
      win = loss = challenges = 0;
      member = true;
      age = ag;
      subscribedTo = new ArrayList();
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
   public void setWin(int number){
      int moreBattles = number - win;
      win = number;
      challenges = challenges + moreBattles;
   }
   
   public void setLoss(int number){
      int moreBattles = number - loss;
      loss = number;
      challenges = challenges + moreBattles;
   }
   
   public void addWins(){
      System.out.println("How many more battles have you won since you last logged in?");
      Scanner in = new Scanner(System.in);
      int value = in.nextInt();
      while(value<0){
         System.out.println("You cannot win a negative number of battles.  We should try again.");
         System.out.println("How many more battles have you won since you last logged in?");
         value = in.nextInt();
      }
      win = win + value;
      challenges = challenges + value;
   }
   
   public void addLosses(){
      System.out.println("How many more battles have you lost since you last logged in?");
      Scanner in = new Scanner(System.in);
      int value = in.nextInt();
      while(value<0){
         System.out.println("You cannot lose a negative number of battles.  We should try again.");
         System.out.println("How many more battles have you lost since you last logged in?");
         value = in.nextInt();
      }
      loss = loss + value;
      challenges = challenges + value;
   }
   
   
   
   
   
   
   public String username, password, email;
   private int win, loss, challenges, age;
   private boolean member;
   private char gender;
   
   public ArrayList<String> subscribedTo;
   
}
