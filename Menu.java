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
   ListofMembers lom;
   ListOfHoots loh = new ListOfHoots();
   Hoot hot;
   Subscribe sub;
   NonmemberHootFeed nonHoot;
   public void seeMenu(boolean login2, String memName) throws IOException
   {
      register = false;
      lom = new ListofMembers();
      sub = new Subscribe();
      name = memName;
      hoot = "";
      System.out.println("Please select your option from the following menu: ");
      if(login2 == true)//main menu for logged in users
      {
         System.out.println("P: Post a Hoot");
         System.out.println("S: Subscribe to a member");
         System.out.println("F: View Subscription Hoot Feed");
         System.out.println("C: Check for hoots tagged");
         System.out.println("W: Add win to record");
         System.out.println("O: Add loss to record");
      }
      else if (login2 == false)//main menu for users not logged in
      {
         System.out.println("R: Register an account");
         System.out.println("L: Log in");
      }      
         
      System.out.println("V: View HootFeed");//menu for all users
      System.out.println("M: Search Member");
      System.out.println("H: Search Hashtag");
      System.out.println("Q: Quit");
      System.out.println("");
   }
   
   public boolean menuChoice(char ch, boolean login2) throws IOException, FileNotFoundException
   {
   
      switch(ch)
         {
            case 'r': //register user
            case 'R':
               boolean validName = false;
               while(validName==false){
                  System.out.print("Enter username: ");
                  name = inLine.next();
                  if(!lom.userExists(name)) {
                     validName=true;
                  }
                  else {
                     System.out.print("I am so sorry, but someone has already taken that username: ");
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
               while(age < 10)
               {
                  System.out.print("The age is too low for registration. Please type enter a valid age: ");
                  age = inInt.nextInt();
               }
               register = true;
               user.addMember(name,pass,email,gender,age);
               lom.add(user);
               sub.update(register);
               break;
            case 'H': //search for hashtag
            case 'h':
               System.out.println("What hashtag are you looking for?");
               hTag = inLine.next();
               loh.findInstanceOfHashtag(hTag);
               break;
            case 'L': //switch logged in members
            case 'l':
               break;
            case 'V': //view public hoot feed
            case 'v':
               nonHoot = new NonmemberHootFeed();
               nonHoot.viewNonmemberHootFeed(login2,name);
               break;
            case 'M': //look up info on member
            case 'm':
               System.out.print("Enter username to search: ");
               name = inLine.next();
               lom.searchUser(name);
               break;
            case 'Q': //quit program
            case 'q':
               program = false;   
               break;
            case 'p': //write hoot
            case 'P':
               System.out.println("What's on your mind?");
               hoot = inLine.nextLine();
               while (hoot == ""){
                  hoot = inLine.nextLine();
               }
               while(hoot.length() > 140)
               {
                     System.out.println("Your hoot exceeds the 140 character limit. Please try again: ");
                     hoot = inLine.nextLine();
               }
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
            case 's': //subscribe to a member
            case 'S':
               System.out.print("Enter username to search: ");
               String name2 = inLine.next();
               if (name2 == ""){
                  name2 = inLine.nextLine();}               
               sub.add(name2,name);
               sub.update(register);
               break;
            case 'f': //subscribe hoot feed
            case 'F':
               MemberHootFeed memHootFeed = new MemberHootFeed();
               memHootFeed.viewMemberHootFeed(name);
               break;
            case 'c': //check tags
            case 'C':
               nonHoot = new NonmemberHootFeed();
               nonHoot.amITagged(name);
               break;
            case 'w': //add wins to record
            case 'W':
               System.out.print("How many wins would you like to add? ");
               int win = inInt.nextInt();
               lom.addWin(name,win);
               lom.update();
               break;
            case 'o': //add losses to record
            case 'O':
               System.out.print("How many losses would you like to add? ");
               int loss = inInt.nextInt();
               lom.addLoss(name,loss);
               lom.update();
               break;
            default: 
               System.out.println("You've pressed a key not on our list. Please try again.");  
               break;
         }
      return program;
   }
}
