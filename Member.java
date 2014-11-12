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
   
   public String username, password, email;
   int win, loss, challenges, age;
   boolean member;
   char gender;
}
