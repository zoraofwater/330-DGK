import java.util.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Menu
{
   public static Scanner inLine = new Scanner(System.in), inChar = new Scanner(System.in), inInt = new Scanner(System.in);
   
   String name, pass, email, line;
   char gender;
   int age;
   boolean username, program = true;
   Member user;
   ListofMembers lom = new ListofMembers();
   NonmemberHootFeed nonHoot;
   public void seeMenu(boolean login2, String memName)
   {
      name = memName;
      System.out.println("Please select your option from the following menu: ");
      if(login2 == true)
      {
         System.out.println("P: Post a Hoot");
         System.out.println("S: Subscribe to a member");
         System.out.println("F: View Subscription Hoot Feed");
         System.out.println("U: Update records");
         System.out.println("C: Check for hoots tagged");
      }
      else if (login2 == false)
      {
         System.out.println("R: Register an account");
         System.out.println("L: Log in");
      }      
         
      System.out.println("V: View HootFeed");
      System.out.println("M: Search Member");
      System.out.println("Q: Quit");
      System.out.println("");
   }
   
   public boolean menuChoice(char ch) throws IOException, FileNotFoundException
   {
   
      switch(ch)
         {
            case 'r':
            case 'R':
               System.out.print("Enter username: ");
               name = inLine.next();
               System.out.print("Enter password: ");
               pass = inLine.next();
               System.out.print("Enter email: ");
               email = inLine.next();
               System.out.print("Enter gender(M/F): ");
               gender = inChar.nextLine().charAt(0);
               System.out.print("Enter age (Must be 10+ to make an account): ");
               age = inInt.nextInt();
               user = new Member(name,pass,email,gender,age);
               lom.add(user);
               break;
            case 'L':
            case 'l':
               break;
            case 'V':
            case 'v':
               nonHoot = new NonmemberHootFeed();
               break;
            case 'M':
            case 'm':
               System.out.print("Enter username to search: ");
               name = inLine.next();
               username = lom.searchUser(name);
               if (username == true)
               {
                  System.out.println("Username found.");
               }
               else
               {
                  System.out.println("Username not found.");
               }
               break;
            case 'Q':
            case 'q':
               program = false;   
               break;
            case 'p':
            case 'P':
               //add hoot
               break;
            case 's':
            case 'S':
               //subscribe
               break;
            case 'f':
            case 'F':
               //subscribe hoot feed
               nonHoot = new NonmemberHootFeed();
               break;
            case 'u':
            case 'U':
               // update user records
               break;
            case 'c':
            case 'C':
               //check tags
               break;
            default: 
               System.out.println("You've pressed a key not on our list. Please try again.");  
               break;
         }
      return program;
   }
}