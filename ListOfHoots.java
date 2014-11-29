import java.util.*;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader.*;
import java.util.Scanner;

public class ListOfHoots
{
	protected boolean HootStatus;
	public ListOfHoots(){}

	public void insert(Hoot thing) throws IOException{
		FileWriter out = new FileWriter("hootFile.txt",true);
		try { 
			out.write("{ " + thing.getUsername() + " ");
			if(thing.getHootStatus() == true){
				out.write("1");
			}
			else {
				out.write("0");
			}
			out.write(" STARTTHEHOOT " + thing.getHoot() + " ENDTHEHOOT ( ");
			//Make an array of strings from the hoot of individual words in hoot
			String parts[] = thing.getHoot().split(" ");
			//int partsSize = parts.size();
			//find all tagged users
			for(String str : parts){
				char[] word = str.toCharArray();
				if(word[0] == '@'){
					out.write(str.substring(1) + " ");	
				}
			}
			out.write(") [ ");
			//find all tagged users
			for(String str : parts){
				char[] word = str.toCharArray();
				if(word[0] == '#'){
					out.write(str.substring(1) + " ");	
				}
			}
			out.write("] }\n");
		}finally {
			if (out != null){
				out.close();
			}
		}
	}
	
	public void findInstanceOfHashtag(String htag)throws FileNotFoundException, IOException{
		BufferedReader reader = new BufferedReader(new FileReader("hootFile.txt"));
		String line = reader.readLine();
		String[] hTagHoots = new String[1000];
		String[] hTagUsers = new String[1000];
		int hootNum = 0;
      boolean exist = false;
		while (line != null){
			String parts[] = line.split(" ");
			String hootText = "";
			String uName = "";
         
			uName = parts[1];
       
			boolean showHoot = false;
			if (parts[2].compareTo("0") == 0){
				int endHoot = 1000;
				for(int i = 4; i < endHoot; i++){
					if (parts[i].compareTo("ENDTHEHOOT") == 0){
						endHoot = i;
					}
					else {
						hootText = hootText + " " + parts[i];
					}
				}
				//parts[endHoot+1] will always be "("
				int endUserTags = 1000;
				for(int i = endHoot+2; i < endUserTags; i++){
					if(parts[i].compareTo(")") == 0){
						endUserTags = i;
					}
				}
				//parts[endUserTag+1] will always be "["
				int endHashtag = 1000;
				for(int i = endUserTags+2; i < endHashtag; i++){
					if(parts[i].compareTo("]") == 0){
						endHashtag = i;
					}
					else{
						if(parts[i].compareTo(htag) == 0){
							showHoot = true;
						}
					}
				}
			}
			if(showHoot == true)
         {
				hTagUsers[hootNum] = uName;
				hTagHoots[hootNum] = hootText;
				hootNum++;
            exist = true;
         }
		   line = reader.readLine();
		}
		
		if(exist == false){
			System.out.println("Sorry, no Hoots match your search.  I guess that makes you sooo unique.");
		}
		else{
			int pages = hootNum / 5;
			int lastPageSize = hootNum % 5;
			boolean keepGoing = true;
			for(int pageNum = 0; pageNum < pages; pageNum++){
				int pn = pages - pageNum;
				System.out.println("\nPage " + pn + " of " + pages + ".");
				for(int entryNum = 0; entryNum < 5; entryNum++){
					System.out.print(hTagUsers[hootNum - ( ( pageNum * 5 ) + 1 + entryNum)] + ": ");
					System.out.print(hTagHoots[hootNum - ( ( pageNum * 5 ) + 1 + entryNum)] + "\n\n");
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
			}
			if(keepGoing == true){
				for(int i = lastPageSize; lastPageSize > 0; lastPageSize--){
					System.out.print(hTagUsers[lastPageSize-1] + ": ");
					System.out.print(hTagHoots[lastPageSize-1] + "\n\n");
				}
			}	
		}
	}
}
