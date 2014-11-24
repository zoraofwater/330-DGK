import java.util.Scanner;
import java.util.*;
import java.io.*;

public class HootHoot
{
   public static Scanner inChar = new Scanner(System.in), inLine = new Scanner(System.in);
   public static void main(String[] args) throws IOException
   {
      char ch;
      boolean program = true, login = false;
      ListofMembers lom = new ListofMembers();
      String name = null, pass;
      Menu menu = new Menu();
      
      while(program == true)
      {
         if(name != null && login == true)
         {
            System.out.println("Welcome, " + name);
         }
         menu.seeMenu(login, name);
         ch = inChar.next().charAt(0);
         System.out.println("");
         program = menu.menuChoice(ch);
         if(ch == 'l' || ch == 'L')
         {  
            System.out.print("Enter username: ");
            name = inLine.next();
            System.out.print("Enter password: ");
            pass = inLine.next();
            login = lom.searchLogin(name,pass);
            if(login == true)
            {
               System.out.println("You have Logged in.");
            }
            else if (login == false)
            {
               System.out.println("Username/Password invalid.");
            }
         }
      }

      
   }
}
