import java.util.Scanner;
import java.util.*;
import java.io.*;

public class HootHoot
{
   public static Scanner inChar = new Scanner(System.in);
   public static void main(String[] args) throws IOException
   {
      char ch;
      boolean program = true;
      Menu menu = new Menu();
      
      while(program == true)
      {
         menu.seeMenu();
         ch = inChar.next().charAt(0);
         System.out.println("");
         program = menu.menuChoice(ch);
      }

      
   }
}
