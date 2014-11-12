public class Member extends Nonmember
{
   Member(String name, String pass, String mail)
   {
      username = name;
      password = pass;
      email = mail;
      member = true;
   }
   
   public String username, password, email;
   boolean member;
}
