import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class HootHoot
{
   public static Scanner inLine = new Scanner(System.in), inChar = new Scanner(System.in), inInt = new Scanner(System.in);
   public static void main(String[] args) throws IOException, FileNotFoundException
   {
      String name, pass, email, line;
      char ch, gender;
      int age, count = 0;
      Member user;
      ListofMembers lom = new ListofMembers();
      boolean program = true, login = false, username = false;
      NonmemberHootFeed nonHoot;
      
      while(program == true)
      {
         System.out.println("Please select your option from the following menu:");
         System.out.println("R: Register an account");
         System.out.println("L: Log in");
         System.out.println("V: View HootFeed");
         System.out.println("M: Search Member");
         System.out.println("");
         
         ch = inChar.next().charAt(0);
         System.out.println("");
         
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
               break;
            case 'L':
            case 'l':
               System.out.print("Enter username: ");
               name = inLine.next();
               System.out.print("Enter password: ");
               pass = inLine.next();
              // try
               login = lom.searchLogin(name,pass);
               if(login == true)
               {
                  System.out.print("You have Logged in.");
               }
               else if (login == false)
               {
                  System.out.print("Username/Password invalid.");
               }
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
                  System.out.print("Username found.");
               }
               else
               {
                  System.out.print("Username not found.");
               }
               break;
            case 'Q':
            case 'q':
               program = false;   
               break;
            default: 
               System.out.println("You've pressed a key not on our list. Please try again.");  
               break;
         }
         System.out.println("");
      }

      
   }
}
