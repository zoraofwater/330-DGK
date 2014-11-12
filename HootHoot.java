import java.util.Scanner;
import java.util.*;

public class HootHoot {
   public static Scanner inLine = new Scanner(System.in), inChar = new Scanner(System.in), inInt = new Scanner(System.in);
   public static void main(String[] args)
   {
      String name, pass, email;
      char ch;
      int age;
      Member user;
      
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
   }
}
