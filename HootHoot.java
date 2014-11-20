import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class HootHoot
{
   public static Scanner inLine = new Scanner(System.in), inChar = new Scanner(System.in), inInt = new Scanner(System.in);
   public static void main(String[] args)
   {
      String name, pass, email, line;
      char ch, gender;
      int age, count = 0;
      Member user;
      ListofMembers lom = new ListofMembers();
      boolean program = true, login = false;
      
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
               name = input.next();
               System.out.print("Enter password: ");
               pass = input.next();
               System.out.print("Enter email: ");
               email = input.next();
               System.out.print("Enter gender(M/F): ");
               gender = input.nextLine().charAt(0);
               System.out.print("Enter age (Must be 10+ to make an account): ");
               age = input.nextInt();
               user = new Member(name,pass,email,gender,age);
               break;
            default: 
               System.out.println("You've pressed a key not on our list. Please try again.");  
               break;
         }
         System.out.println("");
      }

      
   }
}
