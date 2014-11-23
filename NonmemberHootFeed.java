import java.io.*;
import java.util.*;
import java.io.BufferedReader.*;

public class NonmemberHootFeed
{
   //TURN INTO A FILE, BISH!
	LinkedList HootList = new LinkedList();
	List<Hoot> allTheHoots = new LinkedList();
	public NonmemberHootFeed()throws FileNotFoundException, IOException
   {
		BufferedReader reader = new BufferedReader(new FileReader("hootFile.txt"));
		
		
		boolean priOrPub;
		String uName;
		String[] tUsers = new String[10];
		String[] hTags = new String[10];
		
		int listIndex = 0;
		
      String line = reader.readLine();
      
		while (line != null){
			
			String parts[] = line.split(" ");
			
			String hootText = "";
			uName = "";
			
			
			int i = 0;
			int startHoot = 3;
			int endHoot = 1000;
			int endtUsers = 1000;
			int endhTags = 1000;
			int tUserIterator = 0;
			int hTagIterator = 0;
// parts[0] will always be "{"
// parts[1] will always be the username
// parts[2] will always either be "0" which is public or "1" which is private
// parts[3] will always be an open quote
// parts[4] will always be the first word in the hoot
			uName = parts[1];
			if (parts[2].compareTo("0") == 0){
				priOrPub = false;
			}
			else {
				priOrPub = true;
			}
			
			for (String part : parts){
				if(i >= 0 && i <= 3){
					
				}
				else if(i >= 4 && i <= endHoot){
					if (parts[i].compareTo("ENDTHEHOOT") == 0){
						endHoot = i;
					}
					else {
						hootText = hootText + " " + parts[i];
					}
				}
				else if(i > endHoot+1 && i < endtUsers){
					if (parts[i].compareTo(")") == 0){
						endtUsers = i;
					}
					else {
						int size = parts[i].length();
						tUsers[tUserIterator] = parts[i].substring(1, size-1);
						tUserIterator++;
					}
				}
				else if (i > endtUsers+1 && i < endhTags){
					if (parts[i].compareTo("]") == 0){
						endhTags = i;
					}
					else {
						int size = parts[i].length();
						hTags[hTagIterator] = parts[i].substring(0, size-1);
						hTagIterator++;
					}
				}
				i++;
			}
			
			if (priOrPub == false){
				System.out.println(uName + ":");
				System.out.println(hootText + "\n\n");
				
			}
			listIndex++;
         line = reader.readLine();
		}
	}
}
