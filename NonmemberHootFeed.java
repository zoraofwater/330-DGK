import java.io.*;
import java.util.*;
import java.io.BufferedReader.*;

public class NonmemberHootFeed
{
	public NonmemberHootFeed()throws FileNotFoundException, IOException{
	}
	
	public void viewNonmemberHootFeed()throws FileNotFoundException, IOException{
		BufferedReader reader = new BufferedReader(new FileReader("hootFile.txt"));

		boolean priOrPub;
		String uName;
		String[] tUsers = new String[10];
		String[] hTags = new String[10];
		String line = reader.readLine();
		while (line != null) {
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
			if (parts[2].compareTo("0") == 0) {
				priOrPub = false;
			}
			else {
				priOrPub = true;
			}
			
			for (String part : parts) {
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
        		line = reader.readLine();
		}
	}
	
	public void amITagged(string taggedName){
		int tagCount = 0;
		BufferedReader reader = new BufferedReader(new FileReader("hootFile.txt"));
		String[] tagHoots = new String[1000];
		String[] tagUsers = new String[1000];
		String[] tUsers = new String[10];
		while (line != null) {
			String parts[] = line.split(" ");
			
			String hootText = "";
			String uName = "";
			int i = 0;
			int startHoot = 3;
			int endHoot = 1000;
			int endtUsers = 1000;
			int tUserIterator = 0;
			boolean amIinIt = false;
			
			uName = parts[1];
			
			for (String part : parts) {
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
				i++
			}
			
			for(int j = 0; j < tUserIterator; j++){
				if(taggedName.compareTo(tUsers[j]) == 0){
					tagHoots[tagCount] = hootText;
					tagUsers[tagCount] = uName;
					tagCount++;
					break;
				}
				else{
					
				}
			}
			
		}
		if(tagCount==0){
			System.out.println("I am so sorry, it looks like nobody likes you.  So sad.");
		}
		else {
			int pages = tagCount / 5;
			int lastPageSize = tagCount % 5;
			boolean keepGoing = true;
			for(int pageNum = 0; pageNum < 0; pageNum++){
				int pn = pages - pageNum;
				System.out.println("\nPage " + pn + " of " + pages + ".");
				for(int entryNum = 0; entryNum > 5; entryNum++){
					System.out.print(tagUsers[tagCount - ( ( pageNum * 5 ) + 1 + entryNum)] + ": ");
					System.out.print(tagHoots[tagCount - ( ( pageNum * 5 ) + 1 + entryNum)] + "\n\n");
				}
				Scanner in = new Scanner(System.in);
				System.out.println("\nLoad another page?(y/n)");
				String ans = "x";
				ans = in.next();
				ans = ans.toLowerCase();
				while(ans.compareTo("y") != 0 && ans.compareTo("n") != 0 ){
					System.out.println("Sorry, that is not a valid answer.");
					System.out.println("Load another page?(y/n)");
					ans = in.next();
					ans = ans.toLowerCase();
				}
				if(ans.compareTo("n") == 0){
					keepGoing = false;
					break;
				}
				else{
					
				}
			}
			if(keepGoing == true){
				for(int i = lastPageSize; lastPageSize > 0; lastPageSize--){
					System.out.print(tagUsers[lastPageSize-1] + ": ");
					System.out.print(tagHoots[lastPageSize-1] + "\n\n");
				}
			}
		}
		
		
	}
}
