import java.io.*;
import java.util.*;
import java.io.BufferedReader.*;

public class MemberHootFeed
{
	public MemberHootFeed()throws FileNotFoundException, IOException{}
   
   Subscribe sub = new Subscribe();
	
	public void viewMemberHootFeed(String user)throws FileNotFoundException, IOException{
		BufferedReader hootReader = new BufferedReader(new FileReader("hootFile.txt"));
		String line = hootReader.readLine();
		String[] users = new String[1000];
		String[] hoots = new String[1000];
		int numOfHoots = 0;
		while (line != null) {
			String parts[] = line.split(" ");
			String hootText = "";
			String uName = "";
			
			int startHoot = 3;
			int endHoot = 1000;
			
			uName = parts[1];
			
			if(sub.searchSub(uName, user) == true)
         {
				for(int i = 4; i < endHoot; i++){
					if (parts[i].compareTo("ENDTHEHOOT") == 0){
						endHoot = i;
					}
					else {
						hootText = hootText + " " + parts[i];
					}
				}
				users[numOfHoots] = uName;
				hoots[numOfHoots] = hootText;
				numOfHoots++;
			}
			line = hootReader.readLine();
		}
		if(numOfHoots==0){
			System.out.println("I am so sorry, it looks like nobody likes you.  So sad.");
		}
		else {
			int pages = numOfHoots / 5;
			int lastPageSize = numOfHoots % 5;
			boolean keepGoing = true;
			for(int pageNum = 0; pageNum < pages; pageNum++){
				int pn = pages - pageNum;
				System.out.println("\nPage " + pn + " of " + pages + ".");
				for(int entryNum = 0; entryNum < 5; entryNum++){
					System.out.print(users[numOfHoots - ( ( pageNum * 5 ) + 1 + entryNum)] + ": ");
					System.out.print(hoots[numOfHoots - ( ( pageNum * 5 ) + 1 + entryNum)] + "\n\n");
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
					System.out.print(users[lastPageSize-1] + ": ");
					System.out.print(hoots[lastPageSize-1] + "\n\n");
				}
			}
		}
	}
}
