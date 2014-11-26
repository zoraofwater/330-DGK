import java.util.*;
import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Menu
{
   public static Scanner inLine = new Scanner(System.in), inChar = new Scanner(System.in), inInt = new Scanner(System.in);
   
   String name, pass, email, line, hoot, hTag;
   char gender, val;
   int age, username;
   boolean program = true, pubPri, register, search;
   Member user = new Member();
   ListofMembers lom = new ListofMembers();
   ListOfHoots loh = new ListOfHoots();
   Hoot hot;
   Subscribe sub;
   NonmemberHootFeed nonHoot;
   public void seeMenu(boolean login2, String memName) throws IOException
   {
      register = false;
      sub = new Subscribe();
      name = memName;
      System.out.println("Please select your option from the following menu: ");
      if(login2 == true)
      {
         System.out.println("P: Post a Hoot");
         System.out.println("S: Subscribe to a member");
         System.out.println("F: View Subscription Hoot Feed");
         System.out.println("U: Update records");
         System.out.println("C: Check for hoots tagged");
         System.out.println("W: Add win to record");
         System.out.println("O: Add loss to record");
      }
      else if (login2 == false)
      {
         System.out.println("R: Register an account");
         System.out.println("L: Log in");
      }      
         
      System.out.println("V: View HootFeed");
      System.out.println("M: Search Member");
      System.out.println("H: Search Hashtag");
      System.out.println("Q: Quit");
      System.out.println("");
   }
   
   public boolean menuChoice(char ch) throws IOException, FileNotFoundException
   {
   
      switch(ch)
         {
            case 'r':
            case 'R':
               boolean validName = false;
               while(validName==false){
                  System.out.print("Enter username: ");
                  name = inLine.next();
                  if(!lom.userExists(name)) {
                     validName=true;
                  }
                  else {
                     System.out.println("I am so sorry, but someone has already taken that username.");
                  }
               }
               System.out.print("Enter password: ");
               pass = inLine.next();
               System.out.print("Enter email: ");
               email = inLine.next();
               System.out.print("Enter gender(M/F): ");
               gender = inChar.nextLine().charAt(0);
               System.out.print("Enter age (Must be 10+ to make an account): ");
               age = inInt.nextInt();
               register = true;
               user.addMember(name,pass,email,gender,age);
               lom.add(user);
               sub.update(register);
               break;
            case 'H':
            case 'h':
               System.out.println("What hashtag are you looking for?");
               hTag = inLine.next();
               break;
            case 'L':
            case 'l':
               break;
            case 'V':
            case 'v':
               nonHoot = new NonmemberHootFeed();
               nonHoot.viewNonmemberHootFeed();
               break;
            case 'M':
            case 'm':
               System.out.print("Enter username to search: ");
               name = inLine.next();
               lom.searchUser(name);
               break;
            case 'Q':
            case 'q':
               program = false;   
               break;
            case 'p':
            case 'P':
               System.out.println("What's on your mind?");
               hoot = inLine.nextLine();
               System.out.println("Would you like to make this hoot public? y/n?");
               val = inChar.next().charAt(0);
               if(val =='y' || val == 'Y')
               {
                  pubPri = false;
               }
               else
               {
                  pubPri = true;
               }
               hot = new Hoot(name,pubPri,hoot);
               loh.insert(hot);
               break;
            case 's':
            case 'S':
               System.out.print("Enter username to search: ");
               String name2 = inLine.next();
               sub.add(name2,name);
               sub.update(register);
               break;
            case 'f':
            case 'F':
               //subscribe hoot feed
               memHootFeed = new MemberHootFeed();
               memHootFeed.viewMemberHootFeed(name, sub)
               break;
            case 'c':
            case 'C':
               //check tags
               nonHoot = new NonmemberHootFeed();
               nonHoot.amITagged(name);
               break;
            case 'w':
            case 'W':
               System.out.print("How many wins would you like to add? ");
               int win = inInt.nextInt();
               user.addWin(win, name);
               break;
            case 'o':
            case 'O':
               break;
            default: 
               System.out.println("You've pressed a key not on our list. Please try again.");  
               break;
         }
      return program;
   }
}
