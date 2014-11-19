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
      String name, pass, email;
      char ch;
      int age, count = 0;
      Member user;
      ListofMembers lom = new ListofMembers();
      boolean loop = true;
      
      while(loop == true)
      {
         System.out.println("Type in a username: ");
         name = inLine.nextLine();
         System.out.println("Type in a password: ");
         pass = inLine.nextLine();
         System.out.println("Type in your email: ");
         email = inLine.nextLine();
         System.out.println("Type in your gender (M/F): ");
         ch = inChar.next().charAt(0);
         System.out.println("Type in your age: ");
         age = inInt.nextInt();
      
         user = new Member(name,pass, email, ch, age);
         user.printInfo();
         System.out.println();
         
         try
         {
            lom.add(user);
         }
         catch(IOException a)
         {
            System.out.println("AJSLDKFAJSDF");
         }
         
         System.out.println(count);
         
         if (count == 2)
         {
            loop = false;
         }
         else
         {
            count++;
         }
      }
   }
}
