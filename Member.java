import java.io.*;
import java.util.*;
import java.io.BufferedReader.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Member
{
   public String[] users;
   public String[] parts;
   
   Member()
   {}

   public void addMember(String name, String pass, String mail, char gen, int ag)
   {
      gender = gen;
      username = name;
      password = pass;
      email = mail;
      win = loss = challenges = 0;
      member = true;
      age = ag;
   }
   
   public String getUsername()
   {
      return username;
   }
   
   public String getPassword()
   {
      return password;
   }
   
   public String getEmail()
   {
      return email;
   }
   
   public int getWin()
   {
      return win;
   }
   
   public int getLoss()
   {
      return loss;
   }
   
   public int getChallenges()
   {
      return challenges;
   }
   
   public int getAge()
   {
      return age;
   }
   
   public char getGender()
   {
      return gender;
   }
   
   public String username, password, email;
   int win, loss, challenges, age;
   boolean member;
   char gender;
}
