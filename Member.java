public class Member extends Nonmember
{
   Member(String name, String pass, String mail)
   {
      username = name;
      password = pass;
      email = mail;
      win = loss = 0;
      member = true;
   }
   
   public String username, password, email;
   int win, loss;
   boolean member;
}
