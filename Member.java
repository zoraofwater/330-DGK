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
   
   public String username, password, email;
   int win, loss, challenges, age;
   boolean member;
   char gender;
}
